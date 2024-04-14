package be.ugent.objprog.ugentopoly.tiles.tileCards;

import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class RailwayCard extends VerticalCard{
    public RailwayCard(Image image, String text, String cost, String rent) {
        Label textLabel = new Label(text);
        Label costLabel = new Label(cost + "€");
        costLabel.setTextAlignment(TextAlignment.LEFT);

        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        VBox title = new VBox(textLabel, costLabel);
        title.setAlignment(Pos.CENTER);

        Label preText = new Label(" rent");
        Label rentLabel = new Label(rent + "€");
        rentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));

        HBox rentBox = new HBox(rentLabel, preText);
        rentBox.setAlignment(Pos.CENTER);


        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(Tile.LONG_SIDE);
        imageView.setFitWidth(Tile.LONG_SIDE);

        VBox vBox = new VBox(imageView, title, rentBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefHeight(Double.MAX_VALUE);
        vBox.setPrefWidth(Double.MAX_VALUE);
        vBox.setSpacing(10);

        getChildren().addAll(vBox);

    }
}