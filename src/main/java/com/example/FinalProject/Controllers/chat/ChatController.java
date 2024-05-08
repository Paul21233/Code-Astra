
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ChatController {

    @FXML
    private TextArea messageArea;

    @FXML
    private TextArea inputField;

    @FXML
    private Button sendButton;

    public void initialize() {
        // Set focus to input field when the window is opened
        inputField.requestFocus();
    }

    @FXML
    private void handleSendButtonAction() {
        sendMessage();
    }

    @FXML
    private void handleInputFieldKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            sendMessage();
            event.consume(); // Prevent new line in text area
        }
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            // Append message to message area
            messageArea.appendText("You: " + message + "\n");

            // Clear input field
            inputField.clear();

            // Here you would send the message to the recipient
            // For now, we'll just print it to the console
            System.out.println("Message sent: " + message);
        }
    }
}
