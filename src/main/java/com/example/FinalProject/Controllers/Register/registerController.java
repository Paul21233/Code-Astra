package com.example.FinalProject.Controllers.Register;

import com.example.FinalProject.Database.DatabaseManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerController {

    @FXML
    public PasswordField password;

    @FXML
    public TextField username;

    @FXML
    public TextField email;

    @FXML
    public TextField phone;

    @FXML
    public DatePicker dob;

    @FXML
    public Button signUp;

    @FXML
    public CheckBox agree_tc;

    @FXML
    public Label home;

    @FXML
    public Label edit;

    @FXML
    public Label about;

    @FXML
    public Hyperlink loginbtn;

    @FXML
    public ChoiceBox levelSelect;

    @FXML
    public Button backbtn;

    @FXML
    private void handleCreateAccount(ActionEvent event) {
        if (!signUp.isDisabled()) {
            String username = this.username.getText().trim();
            String email = this.email.getText().trim();
            String phone = this.phone.getText().trim();
            String password = this.password.getText();
            String dob = this.dob.getValue().toString();

            DatabaseManager databaseManager = new DatabaseManager();
            Connection connection = databaseManager.getConnection();

            if (connection != null) {
                try {
                    String sql = "INSERT INTO users (username, email, phonenum, password, dob) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, username);
                    statement.setString(2, email);
                    statement.setString(3, phone);
                    statement.setString(4, password);
                    statement.setString(5, dob);

                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("User registered successfully!");
                    } else {
                        System.out.println("Failed to register user!");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Failed to connect to the database!");
            }
        }
    }

    @FXML
    public void handleBackbtn(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/windowOne.fxml"));
        try {
            Parent root = loader.load();
            // Create a new scene with the previous page
            Scene scene = new Scene(root);
            // Get the stage (window) from the button's scene
            Stage stage = (Stage) backbtn.getScene().getWindow();
            // Set the new scene on the stage
            stage.setScene(scene);
            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
