package be.ugent.objprog.ugentopoly.tiles.tile.cornerTiles;

import be.ugent.objprog.ugentopoly.tiles.tile.Tile;

abstract public class CornerTile extends Tile {

    public CornerTile(Record companion, String id) {
        super(companion, id);
        setMinHeight(Tile.LONG_SIDE);
        setMaxHeight(Tile.LONG_SIDE);
        setMaxWidth(Tile.LONG_SIDE);
        setMinWidth(Tile.LONG_SIDE);
    }
}
