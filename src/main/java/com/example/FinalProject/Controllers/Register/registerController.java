package com.example.FinalProject.Controllers.Register;

//import com.example.FinalProject.DatabaseManager;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.Objects;
//
//public class registerController {
//
//    @FXML
//    private TextField usernameCheck;
//
//    @FXML
//    private TextField emailPicker;
//
//    @FXML
//    private TextField phonePicker;
//
//    @FXML
//    private DatePicker dobPicker;
//
//    @FXML
//    private PasswordField PasswordCreate;
//
//    @FXML
//    private PasswordField confirmPassword;
//
//    @FXML
//    private CheckBox confirmTerms;
//
//    @FXML
//    private Button SignupClick;
//
////    @FXML
////    private Label Name;
////
////    @FXML
////    private Label Email;
////    @FXML
////    private Label Phone;
////    @FXML
////    private Label DOB;
////    @FXML
////    private Label Pass;
////    @FXML
////    private Label ConfirmPass;
//
//
//    @FXML
//    void sign_up(ActionEvent event) throws IOException{
//        if(confirmTerms.isSelected()){
//            try{
//                String username = usernameCheck.getText();
//                String password = PasswordCreate.getText();
//                String email = emailPicker.getText();
//                String phone = phonePicker.getText();
//                String dob = dobPicker.getValue().toString();
//
//                DatabaseManager.registerUser(username, password, email, phone, dob);
//
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}


import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class registerController {

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private ImageView loginOk;

    @FXML
    private ImageView passwordOk;

    @FXML
    private Button createAccountButton;

    public void initialize() {
        Image okSymbol = new Image(Objects.requireNonNull(getClass().getResourceAsStream("ok_symbol.png")));
        loginOk.setImage(okSymbol);
        loginOk.setVisible(false);
        passwordOk.setImage(okSymbol);
        passwordOk.setVisible(false);

        loginField.textProperty().addListener((observable, oldValue, newValue) -> validateLoginField());
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> validatePasswordField());

        createAccountButton.disableProperty().bind(loginOk.visibleProperty().not().or(passwordOk.visibleProperty().not()));
    }

    private void validateLoginField() {
        loginOk.setVisible(loginField.getText().length() >= 4);
    }

    private void validatePasswordField() {
        passwordOk.setVisible(passwordField.getText().length() >= 6);
    }

    @FXML
    private void handleCreateAccount(ActionEvent event) {
        if (loginOk.isVisible() && passwordOk.isVisible()) {
            String login = loginField.getText();
            String password = passwordField.getText();

            // Make HTTP request to Django backend to create an account
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        URL url = new URL("http://your-django-backend-url/create_account/");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("POST");
                        connection.setDoOutput(true);
                        // Add parameters (login, password) to the request body
                        // Here you would typically use JSON or other format suitable for your backend
                        String postData = "login=" + login + "&password=" + password;
                        connection.getOutputStream().write(postData.getBytes());

                        // Handle response
                        int responseCode = connection.getResponseCode();
                        // Handle response based on response code
                        if (responseCode == HttpURLConnection.HTTP_OK) {
                            // Account created successfully
                            System.out.println("Account created successfully");
                        } else {
                            // Error handling for failed account creation
                            System.out.println("Failed to create account");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            };

            new Thread(task).start();
        }
    }
}
