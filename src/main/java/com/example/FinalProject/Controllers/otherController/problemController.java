package com.example.FinalProject.Controllers.otherController;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class problemController {

    @FXML
    public Hyperlink homebtn;

    @FXML
    public Hyperlink communitybtn;

    @FXML
    public Hyperlink faqbtn;

    @FXML
    public WebView showhackerrank;

    @FXML
    public ImageView profilepic;

    @FXML
    public TextField profilebtn;

    WebEngine engine;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        engine = showhackerrank.getEngine();
        engine.load("https://www.hackerrank.com/dashboard");
    }
}
