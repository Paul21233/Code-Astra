package com.example.FinalProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        try{
//            FXMLLoader root = new FXMLLoader(App.class.getResource("/Fxml/resources/javaResource.fxml"));
            FXMLLoader root = new FXMLLoader(App.class.getResource("/Fxml/home.fxml"));
            Scene scene = new Scene(root.load());
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            stage.getIcons().add(new Image(String.valueOf(App.class.getResource("/image/logo.png"))));
            stage.setScene(scene);
            stage.setTitle("Code Astra");
            stage.setResizable(false);
            stage.resizableProperty().setValue(Boolean.FALSE);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
