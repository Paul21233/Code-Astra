package com.example.FinalProject.Controllers.Register;

import com.example.FinalProject.DatabaseManager;
import javafx.concurrent.Task;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

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
}
