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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.awt.*;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    @FXML
    public Button sendbtn;

    @FXML
    public TextField msgfield;

    @FXML
    public ScrollPane scrollpane;

    @FXML
    public VBox vbox_msg;

    private Server server;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            server = new Server(new ServerSocket(1234));
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error creating server");
        }

        vbox_msg.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                scrollpane.setVvalue((double)newValue);
            }
        });

        server.recieveMessageFromClient(vbox_msg);

        sendbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String msg = msgfield.getText();
                if(msg.length()>0){
                    HBox hbox = new HBox();
                    hbox.setAlignment(Pos.CENTER_RIGHT);
                    hbox.setPadding(new javafx.geometry.Insets(5, 5, 5, 10));

                    Text text = new Text(msg);
                    TextFlow textflow = new TextFlow(text);

                    textflow.setStyle("-fx-color: rgb(239, 242,255)" +
                            "-fx-background-color: rgb(15, 125,242)" +
                            "-fx-background-radius: 20px");

                    textflow.setPadding(new javafx.geometry.Insets(5, 10, 5, 10));

                    hbox.getChildren().add(textflow);
                    vbox_msg.getChildren().add(hbox);

                    server.sendMessageToclient(msg);
                    msgfield.clear();
                }
            }
        });
    }

    public static void addLabel(String messageFromclient, VBox vbox){
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPadding(new javafx.geometry.Insets(5, 5, 5, 10));

        Text text = new Text(messageFromclient);
        TextFlow textflow = new TextFlow(text);
        textflow.setStyle("-fx-color: rgb(239, 242,255)" +
                "-fx-background-color: rgb(15, 125,242)" +
                "-fx-background-radius: 20px");

        textflow.setPadding(new javafx.geometry.Insets(5, 10, 5, 10));
        hbox.getChildren().add(textflow);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vbox.getChildren().add(hbox);

            }
        });
    }
}