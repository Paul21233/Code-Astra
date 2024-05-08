package com.example.FinalProject.Controllers.resource;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class javaReController {

    @FXML
    public WebView javaResource;

    public void initialize() {
        WebEngine webEngine = javaResource.getEngine();
        webEngine.load("https://www.geeksforgeeks.org/java/");
    }
}
