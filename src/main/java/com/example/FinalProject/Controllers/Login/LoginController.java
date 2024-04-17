package com.example.FinalProject.Controllers.Login;

import com.example.FinalProject.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
}
