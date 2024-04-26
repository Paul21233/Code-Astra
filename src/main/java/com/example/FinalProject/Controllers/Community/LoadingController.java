package com.example.FinalProject.Controllers.Community;

import com.example.FinalProject.App;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LoadingController {
    @FXML
    public Text txt_Title1;

    @FXML
    private Text txt_Title;

    @FXML
    void initialize() {
        Stage loginStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Fxml/Community/mainView.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginStage.getIcons().add(new Image(String.valueOf(App.class.getResource("/image/Code_Astra Logo OG.png"))));
        loginStage.setScene(scene);
        loginStage.setTitle("Code Astra");
        loginStage.setResizable(false);
        loginStage.resizableProperty().setValue(Boolean.FALSE);
        // Delay for 2 seconds before redirecting to the community page
        FadeTransition transition = new FadeTransition(Duration.seconds(2), txt_Title);
        transition.setFromValue(1.0);
        transition.setToValue(1.0);
        transition.play();

        transition.setOnFinished(event -> {
            Stage splashStage = (Stage) txt_Title.getScene().getWindow();
            splashStage.close();
            loginStage.show();
        });
    }
}
