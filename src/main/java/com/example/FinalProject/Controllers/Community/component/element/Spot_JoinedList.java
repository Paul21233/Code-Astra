package com.example.FinalProject.Controllers.Community.component.element;

import com.example.FinalProject.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Spot_JoinedList extends VBox {

    @FXML
    public VBox paneList;

    public Spot_JoinedList() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/Community/component/elements/spotJoinedList.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

}