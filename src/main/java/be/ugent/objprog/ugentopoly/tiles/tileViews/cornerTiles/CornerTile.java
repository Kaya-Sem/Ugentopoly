package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.InvalidationListener;

public class CornerTile extends Tile {

    public CornerTile(TileModel model) {
        super(model);
        setMinHeight(LONG_SIDE);
        setMaxHeight(LONG_SIDE);
        setMaxWidth(LONG_SIDE);
        setMinWidth(LONG_SIDE);
    }
}