package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class TileHBox extends HBox {
    private static final int SPACING = 10;
    private static final int PADDING = 5;

    public TileHBox(){
        setMinHeight(Tile.SHORT_SIDE);
        setMaxHeight(Tile.SHORT_SIDE);
        setMinWidth(Tile.LONG_SIDE);
        setMaxWidth(Tile.LONG_SIDE);

        setPadding(new Insets(PADDING));
        setAlignment(Pos.CENTER);
        setSpacing(SPACING);
    }
}