package com.example.FinalProject.Controllers;

import com.example.FinalProject.App;
import com.example.FinalProject.Controllers.Community.CommunityController;
import com.example.FinalProject.Controllers.Login.LoginController;
import com.example.FinalProject.Controllers.Register.registerController;
import com.example.FinalProject.Controllers.otherController.page2Controller;
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
    public Hyperlink communitybtn;

    @FXML
    public Hyperlink faqbtn;

    @FXML
    public Hyperlink loginbtn;

    @FXML
    public Button beginbtn;

    @FXML
    public Button interbtn;

    @FXML
    public Button page2;

    // scene change to the register panel (Beginner)
    @FXML
    public void handleBeginButtonClick(ActionEvent event) {
        try {
            // load the register page FXML file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/Register/register.fxml"));
            Parent root = loader.load();

            // get the controller for the register page
            registerController rc = loader.getController();
            rc.setUserLevel("beginner");

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

    // scene change to the register page (intermediate)
    @FXML
    public void handleInterButtonClick(ActionEvent event) {
        try {
            // load the register page FXML file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/Register/register.fxml"));
            Parent root = loader.load();

            // get the controller for the register page
            registerController rc = loader.getController();
            rc.setUserLevel("intermediate");

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

    // scene change to community page
    @FXML
    public void handleCommunityButtonClick(ActionEvent event) {
        try{
            // loading the login page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/community/loading_page.fxml"));
            Parent root = loader.load();

            // get the controller for the login page
            CommunityController cc = (CommunityController) loader.getController();

            // show the login page
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

    }

    @FXML
    public void handlepage2ButtonClick(ActionEvent event) {
        try{
            // loading the login page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/page2/page2.fxml"));
            Parent root = loader.load();

            // get the controller for the login page
            page2Controller pc = (page2Controller) loader.getController();

            // show the login page
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // closing the window
            Stage homeStage = (Stage) page2.getScene().getWindow();
            homeStage.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
