package com.example.FinalProject.Controllers.Community.component.element.dialog;

import com.example.FinalProject.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class Reply extends DialogPane {
    @FXML
    public TextArea txtMessage;

    public Reply() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                App.class.getResource("/Fxml/Community/component/elements/dialogs/Dialog_Reply.fxml")
        );
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

}