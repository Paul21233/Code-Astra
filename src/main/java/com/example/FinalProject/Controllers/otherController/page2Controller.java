package com.example.FinalProject.Controllers.otherController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class page2Controller {

    @FXML
    public Button cbtn;

    @FXML
    public Button htmlbtn;

    @FXML
    public Button pythonbtn;

    @FXML
    public Button cppbtn;

    @FXML
    public Button javabtn;

    @FXML
    public Button cssbtn;

    @FXML
    public ImageView profiePic;

    @FXML
    public ImageView showicon;

    @FXML
    public TextArea overview;

    @FXML
    public Button nextbtn;

    @FXML
    private void handleHtmlButtonClick(ActionEvent event) {
        // Set HTML icon in the showicon ImageView
        showicon.setImage(new Image("/image/html_icon.png")); // Replace "/path/to/html_icon.png" with the actual path

        // Set overview text for HTML language
        overview.setText("HTML (Hypertext Markup Language) is the standard markup language for creating web pages and web applications. "
                + "It describes the structure of a web page semantically and consists of a series of elements that enclose different parts of the content.");
    }
}
