package com.example.FinalProject.Controllers.Community.component.element;

import com.example.FinalProject.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PageContainer extends VBox {
    @FXML
    public VBox container;

    public PageContainer() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/Community/component/elements/pageContainer.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }
}