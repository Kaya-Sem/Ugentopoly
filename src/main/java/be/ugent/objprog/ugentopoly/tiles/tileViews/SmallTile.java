package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;

public abstract class SmallTile extends Tile {

    public SmallTile(TileModel model) {
        super(model);
        setMinHeight(Tile.SHORT_SIDE);
        setMaxHeight(Tile.SHORT_SIDE);
        setMinWidth(Tile.LONG_SIDE);
        setMaxWidth(Tile.LONG_SIDE);
    }
}