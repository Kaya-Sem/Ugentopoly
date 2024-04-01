package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.TileButton;
import javafx.geometry.Pos;
import javafx.scene.image.Image;

public class StartTile extends CornerTile {

    public StartTile(Record companion, String id) {
        super(companion, id);
        setup(id);
    }

    void setup(String id) {
        String imagePath = "/be/ugent/objprog/ugentopoly/assets/start.png";
        String arrowPath = "/be/ugent/objprog/ugentopoly/assets/start-arrow.png";

        TileImageView arrowImageView = new TileImageView(new Image(arrowPath), 2.0, true);
        arrowImageView.setRotate(90);
        setAlignment(arrowImageView, Pos.CENTER_LEFT);

        TileImageView startImage = new TileImageView(new Image(imagePath), 1.0, true);
        setAlignment(startImage, Pos.CENTER_RIGHT);

        TileButton toggleButton = new TileButton();
        getChildren().addAll(startImage, arrowImageView, toggleButton);

    }
}
