package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.TileButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.Objects;

public class UtilityTile extends SmallTile {

    // Constructor
    public UtilityTile(Record companion, String id){
        super(companion, id);
        setup(id);
    }

    public UtilityTile(String id) {
        super(id);
        setup(id);
    }

    @Override
    protected void setup(String id) {
        String imageName = id.substring(5) + ".png";
        String imagePath = "/be/ugent/objprog/ugentopoly/assets/" + imageName;
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));

        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(Tile.SHORT_SIDE  -13);
        imageView.setFitWidth(Tile.LONG_SIDE- 13);
        imageView.setPreserveRatio(true);

        StackPane pane = new StackPane(imageView);
        pane.setPrefWidth(Double.MAX_VALUE);
        pane.setPrefHeight(Double.MAX_VALUE);
        pane.setPadding(new Insets(10, 10, 10, 10));

        getChildren().addAll(pane, tileButton);
}
}

