package com.example.FinalProject.Controllers.Register;

import com.example.FinalProject.App;
import com.example.FinalProject.Controllers.Community.CommunityController;
import com.example.FinalProject.Controllers.HomeController;
import com.example.FinalProject.Controllers.Login.LoginController;
import com.example.FinalProject.Controllers.faqController;
import com.example.FinalProject.Database.DatabaseManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
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
    public Label about;

    @FXML
    public Hyperlink loginbtn;

    @FXML
    public Button backbtn;

    @FXML
    public Hyperlink homebtn;

    @FXML
    public Hyperlink communitybtn;

    @FXML
    public Hyperlink faqbtn;

    @FXML
    public TextField userLevelText;

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
                        String level = userLevelText.getText().trim();
                        // User registered successfully
                        // Redirect based on user level
                        if (level.equalsIgnoreCase("beginner")) {
                            // Load page for beginners
                            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/page2/page2.fxml"));
                            Parent root = null;
                            try {
                                root = loader.load();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                        } else if (level.equalsIgnoreCase("intermediate")) {
                            // Load page for intermediates
                            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/interPage/interpage.fxml"));
                            Parent root = null;
                            try {
                                root = loader.load();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                        }
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

    //
    @FXML
    public void handleLoginButtonClick(ActionEvent event) {
        try{
            // loading the login page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/Login/login.fxml"));
            Parent root = loader.load();

            // get the controller for the login page
            LoginController lc = (LoginController) loader.getController();

            // show the login page
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // closing the window
            Stage homeStage = (Stage) loginbtn.getScene().getWindow();
            homeStage.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // scene change to home page
    @FXML
    public void handleHomeButtonClick(ActionEvent event) {
        try{
            // loading the home page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/home.fxml"));
            Parent root = loader.load();

            // get the controller for the home page
            HomeController hc = (HomeController) loader.getController();

            // show the home page
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // closing the window
            Stage homeStage = (Stage) homebtn.getScene().getWindow();
            homeStage.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // scene change to community page
    @FXML
    public void handleCommunityButtonClick(ActionEvent event) {
        try{
            // loading the community page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/community/loading_page.fxml"));
            Parent root = loader.load();

            // get the controller for the community page
            CommunityController cc = (CommunityController) loader.getController();

            // show the community page
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // closing the window
            Stage homeStage = (Stage) communitybtn.getScene().getWindow();
            homeStage.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void handleFaqButtonClick(ActionEvent event) {
        try{
            // loading the faq page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/faq.fxml"));
            Parent root = loader.load();

            // get the controller for the faq page
            faqController fc = (faqController) loader.getController();

            // show the faq page
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // closing the window
            Stage homeStage = (Stage) communitybtn.getScene().getWindow();
            homeStage.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // setting user level
    @FXML
    public void setUserLevel(String level) {
        if (level.equals("beginner")) {
            userLevelText.setText("Welcome, Beginner!");
        } else if (level.equals("intermediate")) {
            userLevelText.setText("Welcome, Intermediate!");
        } else {
            userLevelText.setText("Welcome!");
        }
    }
}
