package com.example.FinalProject.Controllers.Community.component;

import com.example.FinalProject.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;

public class Content_ListofPosts extends VBox {

    @FXML
    public Label cLatestBtn;
    @FXML
    public Label cListPostTitle;
    @FXML
    public Pagination cPagePosts;
    @FXML
    public Label cPopularBtn;
    @FXML
    public FontIcon cPostReturn;

    public Content_ListofPosts() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/Community/component/contentListofPosts.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();

    }
}