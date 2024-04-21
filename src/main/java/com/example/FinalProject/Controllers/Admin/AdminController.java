package com.example.FinalProject.Controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdminController {
    @FXML
    public Label adminName;

    @FXML
    public TabPane tabPane;

    @FXML
    public Tab registerMemberTab;

    @FXML
    public TextField username;

    @FXML
    public Button registerbtn;

    @FXML
    public TextField emailField;

    @FXML
    public Label successLabel;

    @FXML
    public DatePicker dobField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public Tab updateinfoTab;

    @FXML
    public TextField newName;

    @FXML
    public Button updatebtn;

    @FXML
    public ChoiceBox nameChoiceMenu;

    @FXML
    public DatePicker dobNew;

    @FXML
    public Tab removeMemTab;

    @FXML
    public Button removebtn;

    public void onUpdateAction(ActionEvent actionEvent) {
    }

    public void onRemoveAction(ActionEvent actionEvent) {
    }

    public void onRegisterAction(ActionEvent actionEvent) {
    }

    public void onLogoutAction(ActionEvent actionEvent) {
    }
}
