package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TileImageView extends ImageView {
    private static final double SIZE = TileView.SHORT_SIDE / 1.5;

    public TileImageView(Image image){
        super(image);

        setFitHeight(SIZE);
        setFitWidth(SIZE);
        setPreserveRatio(true);
    }

    public TileImageView(Image image, Double scalar, boolean isCorner){
        super(image);

        double value = (isCorner) ? TileView.LONG_SIDE / scalar : TileView.SHORT_SIDE / scalar;
        setFitHeight(value);
        setFitWidth(value);

        setPreserveRatio(true);
    }
}