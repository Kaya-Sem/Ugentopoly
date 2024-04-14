package be.ugent.objprog.ugentopoly.tiles.tileCards;

import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BasicVerticalCard extends VerticalCard {

    public BasicVerticalCard(Image image, String text) {

        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(Tile.LONG_SIDE);
        imageView.setFitWidth(Tile.LONG_SIDE);

        VBox vBox = new VBox(imageView, textLabel);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefHeight(Double.MAX_VALUE);
        vBox.setPrefWidth(Double.MAX_VALUE);
        vBox.setSpacing(10);

        getChildren().addAll(vBox);
    }
}