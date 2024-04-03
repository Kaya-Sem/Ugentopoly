package be.ugent.objprog.ugentopoly.TileCards;

import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TaxCard extends VerticalCard {
    public TaxCard(Image image, String text, String cost){
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(Tile.LONG_SIDE);
        imageView.setFitWidth(Tile.LONG_SIDE);

        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label costLabel = new Label(cost + "€");
        costLabel.setFont(Font.font("Arial", FontWeight.THIN, 12));

        vBox.getChildren().addAll(imageView, textLabel, costLabel);
        getChildren().addAll(vBox);
    }
}
