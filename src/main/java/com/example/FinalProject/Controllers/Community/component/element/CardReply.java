package com.example.FinalProject.Controllers.Community.component.element;

import com.example.FinalProject.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardReply extends HBox {
    String replyID,commentID,authorID;

    @FXML
    private Label cReplyAuthor;
    @FXML
    private Label cReplyDate;
    @FXML
    private Label cReplyMessage;

    public CardReply(String replyID, String commentID, String authorID, String authorName, String message, String date) throws IOException, ParseException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/Community/component/elements/contentReplyCard.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        this.replyID = replyID;
        this.commentID = commentID;
        this.authorID = authorID;
        this.cReplyAuthor.setText(authorName);
        this.cReplyMessage.setText(message);

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date newDate = dt.parse(date);
        SimpleDateFormat dt1 = new SimpleDateFormat("d-MMM-yy HH:mm");

        String strDate = dt1.format(newDate);
        this.cReplyDate.setText(strDate);
    }


}