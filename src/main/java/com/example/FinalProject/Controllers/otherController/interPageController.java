package com.example.FinalProject.Controllers.otherController;

import com.example.FinalProject.App;
import com.example.FinalProject.Controllers.HomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class interPageController {

    @FXML
    public Hyperlink homebtn;

    @FXML
    public Hyperlink communitybtnnav;

    @FXML
    public Hyperlink faqbtn;

    @FXML
    public Button problemSolvebtn;

    @FXML
    public Button contestbtn;

    @FXML
    public void initialize() {

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

    @FXML
    public void communitybtnnavAction(ActionEvent event) {

    }

    @FXML
    public void faqbtnAction(ActionEvent event) {

    }

    @FXML
    public void problemSolvebtnAction(ActionEvent event) {
        try{
            // loading the problem solving page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/interPage/problemPage.fxml"));
            Parent root = loader.load();

            // get the controller for the login page
            problemController pc = (problemController) loader.getController();

            // show the problem solving page
            Stage solvingstage = new Stage();
            solvingstage.setScene(new Scene(root));
            solvingstage.setTitle("Code Astra");
            solvingstage.getIcons().add(new Image(String.valueOf(App.class.getResource("/image/Code_Astra Logo OG.png"))));
            solvingstage.show();

            // closing the window
            Stage solveStage = (Stage) problemSolvebtn.getScene().getWindow();
            solveStage.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void contestbtnAction(ActionEvent event) {
        try{
            // loading the contest page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/interPage/contestPage.fxml"));
            Parent root = loader.load();

            // get the controller for the contest page
            contestController cc = (contestController) loader.getController();

            // show the contest page
            Stage conteststage = new Stage();
            conteststage.setScene(new Scene(root));
            conteststage.setTitle("Code Astra");
            conteststage.getIcons().add(new Image(String.valueOf(App.class.getResource("/image/Code_Astra Logo OG.png"))));
            conteststage.show();

            // closing the window
            Stage contestStage = (Stage) contestbtn.getScene().getWindow();
            contestStage.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
