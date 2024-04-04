package be.ugent.objprog.ugentopoly.tiles.tile;

public abstract class SmallTile extends Tile {

    public SmallTile(Record companion, String id) {
        super(companion, id);
        setMinHeight(Tile.SHORT_SIDE);
        setMaxHeight(Tile.SHORT_SIDE);
        setMinWidth(Tile.LONG_SIDE);
        setMaxWidth(Tile.LONG_SIDE);
    }
}