package com.example.FinalProject.Controllers.ChatBot;

import com.example.FinalProject.App;
import com.example.FinalProject.Controllers.Community.CommunityController;
import com.example.FinalProject.Controllers.HomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatBotController {

    @FXML
    public WebView botShow;

    @FXML
    public Hyperlink homebtn;

    @FXML
    public Hyperlink communitybtn;

    @FXML
    public Hyperlink faqbtn;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        // Load the provided link in the WebView
        botShow.getEngine().load("https://widget.yourgpt.ai/d971c659-0502-4e48-bf70-fe948557835e");
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

    // scene change to home page
    @FXML
    public void handleHomeButtonClick(ActionEvent event) {
        try{
            // loading the login page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/home.fxml"));
            Parent root = loader.load();

            // get the controller for the login page
            HomeController hc = (HomeController) loader.getController();

            // show the login page
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
}
