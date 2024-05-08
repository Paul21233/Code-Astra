package com.example.FinalProject.Controllers.chat;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    @FXML
    public TextArea messageArea;

    @FXML
    public TextArea inputField;

    @FXML
    public Button sendButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set focus to input field when the window is opened
        inputField.requestFocus();
    }

    @FXML
    public void handleSendButtonAction() {
        sendMessage();
    }

    @FXML
    public void handleInputFieldKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            sendMessage();
            event.consume();
        }
    }

    @FXML
    public void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            // Append message to message area
            messageArea.appendText("You: " + message + "\n");

            // Clear input field
            inputField.clear();

            // For now, we'll just print it to the console
            System.out.println("Message sent: " + message);
        }
    }
}