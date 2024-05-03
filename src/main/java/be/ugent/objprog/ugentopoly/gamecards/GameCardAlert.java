package be.ugent.objprog.ugentopoly.gamecards;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.CustomImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;

public class GameCardAlert extends Alert {

    public GameCardAlert(String message) {
        super(AlertType.NONE);
        setTitle("");
        setHeaderText(null);
        setContentText(message);

        setGraphic(null);

        ButtonType closeButton = new ButtonType("OK");
        getButtonTypes().add(closeButton);

        Button okButton = (Button) getDialogPane().lookupButton(closeButton);
        okButton.setOnAction(e -> close());
    }
}