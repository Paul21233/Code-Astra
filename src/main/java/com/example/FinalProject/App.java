package com.example.FinalProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        try{
//            FXMLLoader root = new FXMLLoader(App.class.getResource("/Fxml/Register/register.fxml"));
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(App.class.getResource("/Fxml/Register/register.fxml")));
            Scene scene = new Scene(root.load());
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
