package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.InvalidationListener;

abstract public class CornerTile extends Tile implements InvalidationListener {

    public CornerTile(TileModel model) {
        super(model);
        setMinHeight(Tile.LONG_SIDE);
        setMaxHeight(Tile.LONG_SIDE);
        setMaxWidth(Tile.LONG_SIDE);
        setMinWidth(Tile.LONG_SIDE);
    }
}