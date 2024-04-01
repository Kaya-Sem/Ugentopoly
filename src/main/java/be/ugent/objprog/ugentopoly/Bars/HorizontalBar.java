package be.ugent.objprog.ugentopoly.Bars;

import be.ugent.objprog.ugentopoly.GameBoard.MiddleSection;
import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import java.util.List;

public class HorizontalBar extends GridPane implements Bar{
    private static final int NUM_COLS = 8;
    private static final double COL_WIDTH = Tile.SHORT_SIDE;

    private void initializeColumnConstraints(){
        for (int i=0; i< NUM_COLS; i++) {
            getColumnConstraints().add(new ColumnConstraints(COL_WIDTH));
        }
    }

    public HorizontalBar(List<? extends Tile> tiles) {
        setPrefWidth(MiddleSection.getSize());
        setPrefHeight(Tile.LONG_SIDE);

        initializeColumnConstraints();
        populate(tiles);
    }

    public void populate(List<? extends Tile> tiles){
        for (int i = 0; i < 9; i++) {
            Tile tile = tiles.get(i);
            add(tile, i, 0);
        }
    }
}
