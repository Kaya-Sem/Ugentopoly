package be.ugent.objprog.ugentopoly.Tiles.Tile;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TileImageView extends ImageView {
    public TileImageView(Image image){
        super(image);

        setFitHeight(Tile.SHORT_SIDE / 1.5);
        setFitWidth(Tile.SHORT_SIDE / 1.5);
        setPreserveRatio(true);
    }
}

