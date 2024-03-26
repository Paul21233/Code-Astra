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
            Parent root = FXMLLoader.load(App.class.getResource("Fxml/windowOne.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(event ->
            {
                event.consume();
                Log_out(stage);
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Log_out(Stage stage)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to Logout");
        //  alert.setContentText("Do You want to save before exiting?:");
        if (alert.showAndWait().get()== ButtonType.OK)
        {
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
