package be.ugent.objprog.ugentopoly.TileNodes;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class CornerTile extends Tile{
    public CornerTile() {
        super();
        setMinHeight(Tile.LONG_SIDE);
        setMinWidth(Tile.LONG_SIDE);
        setAlignment(Pos.CENTER);


    }
}
