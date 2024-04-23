package com.example.FinalProject.Controllers.Community.component.element.dialog;

import com.example.FinalProject.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;

import java.io.IOException;

public class Confirm extends DialogPane {
    @FXML
    public Label lblMessage;

    public Confirm() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                App.class.getResource("/Fxml/Community/component/elements/dialogs/Dialog_Confirm.fxml")
        );
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

}