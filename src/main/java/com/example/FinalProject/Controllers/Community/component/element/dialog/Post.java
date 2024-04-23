package com.example.FinalProject.Controllers.Community.component.element.dialog;

import com.example.FinalProject.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

import java.io.IOException;

public class Post extends DialogPane {
    @FXML
    private Label dPostTitle;
    @FXML
    public HTMLEditor postEditor;
    @FXML
    public TextField txtName;

    public Post() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                App.class.getResource("/Fxml/Community/component/elements/dialogs/Dialog_Posts.fxml")
        );
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

}