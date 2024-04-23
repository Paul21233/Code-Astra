package com.example.FinalProject.Controllers.Community.component.element;

import com.example.FinalProject.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import java.io.IOException;

public class NotifLabel extends Label {
    public NotifLabel() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/Community/component/elements/NotificationPane.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }
}