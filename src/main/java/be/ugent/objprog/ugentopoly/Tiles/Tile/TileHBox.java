package be.ugent.objprog.ugentopoly.Tiles.Tile;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class TileHBox extends HBox {

    public TileHBox(){
        setMinWidth(Tile.LONG_SIDE);
        setMaxWidth(Tile.LONG_SIDE);
        setMinHeight(Tile.LONG_SIDE);
        setMaxHeight(Tile.LONG_SIDE);
        setPadding(new Insets(5, 5, 5, 5));
        setSpacing(10);
        setAlignment(Pos.CENTER);
    }
}
