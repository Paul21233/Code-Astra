package com.example.FinalProject.Controllers.resource;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class pythonReController {

    @FXML
    public WebView pythonResource;

    @FXML
    public void initialize() {
        WebEngine engine = pythonResource.getEngine();
        engine.load("www.python.org");
    }
}
