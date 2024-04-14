package be.ugent.objprog.ugentopoly.tiles.tileViews;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TileImageView extends ImageView {

    // Standard constructor, default scalar
    public TileImageView(Image image){
        super(image);

        setFitHeight(Tile.SHORT_SIDE / 1.5);
        setFitWidth(Tile.SHORT_SIDE / 1.5);
        setPreserveRatio(true);
    }

    // Secondary constructor
    public TileImageView(Image image, Double scalar, boolean isCorner){
        super(image);

        double value = (isCorner) ? Tile.LONG_SIDE / scalar : Tile.SHORT_SIDE / scalar;
        setFitHeight(value);
        setFitWidth(value);

        setPreserveRatio(true);
    }
}