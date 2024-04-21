package com.example.FinalProject.Controllers.Login;

import com.example.FinalProject.App;
import com.example.FinalProject.Controllers.Register.registerController;
import com.example.FinalProject.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @FXML
    public Button loginbtn;

    @FXML
    public TextField usernamField;

    @FXML
    public PasswordField passField;

    @FXML
    public Button registerbtn;

    // retrieving the data from the database
    @FXML
    public void connectButtonClicked(ActionEvent event) throws IOException {
        DatabaseManager connection = new DatabaseManager();
        Connection connectDB = connection.getConnection();

        String connectQuery = "SELECT * FROM users WHERE username = '" + usernamField.getText() + "'" +
                "AND password = '" + passField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                usernamField.setText(queryOutput.getString("username"));
                passField.setText(queryOutput.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // scene change to the register page
    @FXML
    public void registerButtonClicked(ActionEvent event) throws IOException {
        try {
            // load the register page FXML file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/Register/register.fxml"));
            Parent root = loader.load();

            // get the controller for the register page
            registerController rc = loader.getController();

            // Show the register page
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // closing the window
            Stage homeStage = (Stage) registerbtn.getScene().getWindow();
            homeStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
