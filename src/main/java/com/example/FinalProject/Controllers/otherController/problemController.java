package com.example.FinalProject.Controllers.otherController;

import com.example.FinalProject.App;
import com.example.FinalProject.Controllers.Community.CommunityController;
import com.example.FinalProject.Controllers.HomeController;
import com.example.FinalProject.Controllers.faqController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class problemController {

    @FXML
    public Hyperlink homebtn;

    @FXML
    public Hyperlink communitybtnnav;

    @FXML
    public Hyperlink faqbtn;

    @FXML
    public WebView problemView;

//    WebEngine engine;

    @FXML
    public void initialize(){
        WebEngine engine = problemView.getEngine();
        engine.load("https://www.hackerrank.com/dashboard");
    }

    @FXML
    public void communitybtnnavAction(ActionEvent event) {
        try{
            // loading the login page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/community/loading_page.fxml"));
            Parent root = loader.load();

            // get the controller for the login page
            CommunityController cc = (CommunityController) loader.getController();

            // show the login page
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Code Astra");
            stage.getIcons().add(new Image(String.valueOf(App.class.getResource("/image/Code_Astra Logo OG.png"))));
            stage.show();

            // closing the window
            Stage homeStage = (Stage) communitybtnnav.getScene().getWindow();
            homeStage.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void faqbtnAction(ActionEvent event) {
        try{
            // loading the faq page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/faq.fxml"));
            Parent root = loader.load();

            // get the controller for the faq page
            faqController fc = (faqController) loader.getController();

            // show the faq page
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Code Astra");
            stage.getIcons().add(new Image(String.valueOf(App.class.getResource("/image/Code_Astra Logo OG.png"))));
            stage.show();

            // closing the window
            Stage homeStage = (Stage) faqbtn.getScene().getWindow();
            homeStage.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void homebtnAction(ActionEvent event) {
        try{
            // loading the home page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/home.fxml"));
            Parent root = loader.load();

            // get the controller for the home page
            HomeController hc = (HomeController) loader.getController();

            // show the home page
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Code Astra");
            stage.getIcons().add(new Image(String.valueOf(App.class.getResource("/image/Code_Astra Logo OG.png"))));
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
