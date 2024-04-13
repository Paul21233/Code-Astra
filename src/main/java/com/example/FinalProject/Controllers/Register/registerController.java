package com.example.FinalProject.Controllers.Register;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Objects;

public class registerController {

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private TextField username;

    @FXML
    private Label home;

    @FXML
    private Label edit;

    @FXML
    private Label about;

    @FXML
    private TextField email;

    @FXML
    private TextField phone;

    @FXML
    private DatePicker dob;

    @FXML
    private Button signUp;

    @FXML
    private CheckBox agree_tc;

    @FXML
    private Label successMessageLabel, errorLabel;

    @FXML
    private void initialize()
    {
        username.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        email.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        phone.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        dob.valueProperty().addListener((observable, oldValue, newValue) -> validateFields());
        password.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        confirmPassword.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
    }

    @FXML
    private void validateFields() {
//        boolean emailValid = isValidEmail(email.getText());
//        boolean phoneValid = isValidPhoneNumber(phone.getText());

        signUp.setDisable(
                username == null || username.getText().trim().isEmpty() ||
                email == null || email.getText().trim().isEmpty() || phone == null || phone.getText().isEmpty() ||
                        dob == null || dob.getValue() == null ||
                        password.getText().length() < 6 ||
                        !password.getText().equals(confirmPassword.getText())
        );
    }

    @FXML
    private void handleCreateAccount(ActionEvent event) {
        validateFields();
        if (!signUp.isDisabled()) {
            String username = this.username.getText().trim();
            String email = this.email.getText().trim();
            String phone = this.phone.getText().trim();
            LocalDate dob = this.dob.getValue();
            String password = this.password.getText();

            // Hash the password securely
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            // Sending data to Django backend
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try
                    {
                        URL url = new URL("http://127.0.0.1:8000/register/");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("POST");
                        connection.setDoOutput(true);

                        String postData = "username=" + URLEncoder.encode(username, StandardCharsets.UTF_8) +
                                "&email=" + URLEncoder.encode(email, StandardCharsets.UTF_8) +
                                "&phone=" + URLEncoder.encode(phone, StandardCharsets.UTF_8) +
                                "&dob=" + URLEncoder.encode(dob.toString(), StandardCharsets.UTF_8) +
                                "&hashed_password=" + URLEncoder.encode(hashedPassword, StandardCharsets.UTF_8);

                        connection.getOutputStream().write(postData.getBytes());

                        int responseCode = connection.getResponseCode();
                        Platform.runLater(() -> {
                            if (responseCode == HttpURLConnection.HTTP_OK) {
                                // Display success message
                                successMessageLabel.setVisible(true);
                                successMessageLabel.setText("Account created successfully!");
                            } else {
                                // Display error message based on responseCode
                                String errorMessage = switch (responseCode) {
                                    case HttpURLConnection.HTTP_BAD_REQUEST -> "Invalid input data";
                                    case HttpURLConnection.HTTP_CONFLICT -> "Username already exists";
                                    default -> "Unexpected error";
                                };
                                errorLabel.setText(errorMessage);
                            }
                        });
                    } catch (IOException e) {
                        // Handle network errors on UI thread
                        // Handle network errors on UI thread
                        Platform.runLater(() -> {
                            errorLabel.setText("Network error occurred. Please try again.");
                        });
                    }
                    return null;
                }
            };



            Platform.runLater(() -> {
                new Thread(task).start();
            });

        }
    }

    // Custom validation functions
//    private boolean isValidEmail(String email) {
//        // a regular expression to check email format
//        String emailRegex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,}$";
//        return email.matches(emailRegex);
//    }
//
//    private boolean isValidPhoneNumber(String phone) {
//        // phone number format validation
//        return phone.matches("\\d{10}");
//    }
}
