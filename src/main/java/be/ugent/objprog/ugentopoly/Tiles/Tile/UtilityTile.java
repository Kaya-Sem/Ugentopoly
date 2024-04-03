package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.TileCards.UtilityCard;
import be.ugent.objprog.ugentopoly.Tiles.TileCompanions.UtilityCompanion;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.Objects;

public class UtilityTile extends SmallTile {


    private Image image;

    // Constructor
    public UtilityTile(UtilityCompanion companion, String id) {
        super(companion, id);
        setup(id);
        this.card = createCard(this.image, companion.cost());
    }

    @Override
    protected void setup(String id) {
        String imageName = id.substring(5) + ".png";
        String imagePath = "/be/ugent/objprog/ugentopoly/assets/" + imageName;
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        this.image = image;

        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(Tile.SHORT_SIDE - 13);
        imageView.setFitWidth(Tile.LONG_SIDE - 13);
        imageView.setPreserveRatio(true);

        StackPane pane = new StackPane(imageView);
        pane.setPrefWidth(Double.MAX_VALUE);
        pane.setPrefHeight(Double.MAX_VALUE);
        pane.setPadding(new Insets(10, 10, 10, 10));

        getChildren().addAll(pane, tileButton);
    }

    private UtilityCard createCard(Image image, String cost) {
        return new UtilityCard(image, cost);
    }
}
