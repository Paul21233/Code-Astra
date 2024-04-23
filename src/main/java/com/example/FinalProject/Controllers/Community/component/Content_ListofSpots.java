package com.example.FinalProject.Controllers.Community.component;

import com.example.FinalProject.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;

public class Content_ListofSpots extends VBox {
    @FXML
    public Label PostBtn;
    @FXML
    public Label SpotBtn;
    @FXML
    public Label cListSpotTitle;
    @FXML
    public FontIcon sIcon;
    @FXML
    public Pagination cPageSpots;
    @FXML
    public Label searchText;

    public Content_ListofSpots() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/Community/component/contentListofSpots.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }
}