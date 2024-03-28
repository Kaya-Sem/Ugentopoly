package be.ugent.objprog.ugentopoly.Tiles.TileCompanions.Tile;

import javafx.geometry.Pos;

public class CornerTile extends Tile{
    public CornerTile(Record companion, String id) {
        super(companion, id);
        setMinHeight(Tile.LONG_SIDE);
        setMinWidth(Tile.LONG_SIDE);
        setAlignment(Pos.CENTER);


    }
}
