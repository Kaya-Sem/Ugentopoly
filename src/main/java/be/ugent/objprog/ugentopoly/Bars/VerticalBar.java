package be.ugent.objprog.ugentopoly.Bars;

import be.ugent.objprog.ugentopoly.GameBoard.MiddleSection;
import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;

/*
    initializeRowConstraints() : fill the bar with 8 rows, as to create 8 places for tiles.
    populate() : places 9 received tiles in the slots.
    NON URGENT write documentation for BARS
*/

public class VerticalBar extends GridPane implements Bar {
    private static final int NUM_ROWS = 8;
    private static final double ROW_HEIGHT = Tile.SHORT_SIDE;

    private final List<? extends Tile> tiles;

    public VerticalBar(List<? extends Tile> tiles) {
        this.tiles = tiles;
        setPrefWidth(Tile.LONG_SIDE);
        setPrefHeight(MiddleSection.getSize());

        initializeRowConstraints();
        populate(tiles);
    }

    private void initializeRowConstraints() {
        for (int i = 0; i < NUM_ROWS; i++) {
            getRowConstraints().add(new RowConstraints(ROW_HEIGHT));
        }
    }

    public void populate(List<? extends Tile> tiles) {
        if (tiles.size() == 9) {
            for (int i = 0; i < 9; i++) {
                Tile tile = tiles.get(i);
                add(tile, 0, i);
            }
        } else {
            throw new IllegalArgumentException("tile list must be of size 9!");
        }
    }

    public void applyRotation(double angle) {
        for (Tile tile : this.tiles) {
            tile.applyRotation(angle);
        }
    }
}
