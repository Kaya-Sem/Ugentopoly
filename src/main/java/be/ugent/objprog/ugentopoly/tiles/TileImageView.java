package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TileImageView extends ImageView {

    // Standard constructor, default scalar
    public TileImageView(Image image){
        super(image);

        setFitHeight(TileView.SHORT_SIDE / 1.5);
        setFitWidth(TileView.SHORT_SIDE / 1.5);
        setPreserveRatio(true);
    }

    // Secondary constructor
    public TileImageView(Image image, Double scalar, boolean isCorner){
        super(image);

        double value = (isCorner) ? TileView.LONG_SIDE / scalar : TileView.SHORT_SIDE / scalar;
        setFitHeight(value);
        setFitWidth(value);

        setPreserveRatio(true);
    }
}