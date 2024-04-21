package com.example.FinalProject.Controllers;

import com.example.FinalProject.App;
import com.example.FinalProject.Controllers.Login.LoginController;
import com.example.FinalProject.Controllers.Register.registerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    public TextField searchbar;

    @FXML
    public Button beginbtn;

    @FXML
    public Button interbtn;

    @FXML
    public Hyperlink hiwbtn;

    @FXML
    public Hyperlink homebtn;

    @FXML
    public Hyperlink faqbtn;

    @FXML
    public Hyperlink loginbtn;

    // scene change to the register panel
    @FXML
    public void handleBeginButtonClick(ActionEvent event) {
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
            Stage homeStage = (Stage) beginbtn.getScene().getWindow();
            homeStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Scene change to the login panel
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
}
