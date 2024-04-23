package com.example.FinalProject.Controllers.ChatBot;

import com.example.FinalProject.App;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import com.example.FinalProject.App;
import com.example.FinalProject.Controllers.ChatBot.botParser;
import com.example.FinalProject.Views.BotMessage;

import static org.apache.commons.lang3.SystemProperties.getUserName;

public class BotController {

    @FXML
    public TextField messageTextField;

    @FXML
    public Button sendButton;

    @FXML
    public VBox messages;

    @FXML
    public ScrollPane scrollPane;

    @FXML
    public ProgressIndicator loadingProgressIndicator;

    @FXML
    public void initialize(){
        Thread thread = new Thread(() -> {
            try{
                botParser.getInstance().init(); //Initialize parser

                //Remove progress indicator from pane
                Platform.runLater(() -> {
                    ((Pane) this.loadingProgressIndicator.getParent()).getChildren().remove(this.loadingProgressIndicator);
                    this.loadingProgressIndicator = null;

                    this.sendButton.setDisable(false);
                    this.messageTextField.setDisable(false);
                });
            }catch(Exception exception){
                exception.printStackTrace();

                Platform.runLater(() ->
                        this.showErrorAlert(
                                "An error occurred while loading the bot",
                                exception.getClass().getName() + ": " + exception.getMessage()
                        ));

                Platform.exit();
            }
        });
        thread.start();

        this.scrollPane.vvalueProperty().bind(this.messages.heightProperty());
    }

    @FXML
    public void onSendButtonPressed(){
        final String text = this.messageTextField.getText().trim();

        if(!text.equals("")){
            this.sendButton.setDisable(true);
            this.messageTextField.setText("");
            this.messageTextField.setDisable(true);

            this.addMessage(
                    new Image(App.class.getResource("/image/boy.png").toString()),
                    text,
                    false
            );

            Thread thread = new Thread(() -> {
                try{
                    final String answer = botParser.getInstance().sendAI(text);

                    Platform.runLater(() -> {
                        this.addMessage(
                                new Image(App.class.getResource("/image/support.png").toString()),
                                answer,
                                true
                        );

                        this.sendButton.setDisable(false);
                        this.messageTextField.setDisable(false);
                    });
                }catch(Exception exception){
                    exception.printStackTrace();

                    Platform.runLater(() ->
                            this.showErrorAlert(
                                    "An error occurred while send message!",
                                    exception.getClass().getName() + ": " + exception.getMessage()
                            )
                    );
                }
            });

            thread.start();
        }else{
            this.showErrorAlert("Type message...", null);
        }
    }

    @FXML
    public void onMessageTextFieldKeyReleased(KeyEvent keyEvent){
        if(keyEvent.getCode() == KeyCode.ENTER){
            this.onSendButtonPressed();
        }
    }

    private void addMessage(Image image, String text, boolean second){
        BotMessage message = new BotMessage(this.scrollPane);
        message.setBotMessage(text);
        message.setAvatar(image);

        if(second)
            message.changeOrientation();

        this.messages.getChildren().add(message);
    }

    private void showErrorAlert(String header, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

//    @FXML
//    private void sendMessageToChatbot(String message) {
//        String response = "";
//
//        // Check if the user is signed in
//        boolean isSignedIn = checkUserSignIn(); // Implement this method to check user sign-in status
//
//        // If user is signed in, retrieve their name
//        String userName = "";
//        if (isSignedIn) {
//            userName = getUserName(); // Implement this method to retrieve the user's name
//        }
//
//        // Modify message to include user's name if signed in
//        if (!userName.isEmpty()) {
//            message = "Hi " + userName + "! " + message;
//        }
//
//        // Send the modified message to the chatbot and receive response
//        response = sendToChatbot(message); // Implement this method to send message to chatbot
//
//        // Process and display chatbot response
//        displayChatbotResponse(response);
//    }

//    @FXML
//    private void displayChatbotResponse(String response) {
//
//    }
//
//    @FXML
//    private String sendToChatbot(String message) {
//    }
//
//    @FXML
//    private boolean checkUserSignIn() {
//    }
}