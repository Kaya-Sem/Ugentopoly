package be.ugent.objprog.ugentopoly.bars;

import java.util.List;
import java.util.stream.IntStream;

import be.ugent.objprog.ugentopoly.gameBoard.MiddleSection;
import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/*
    initializeRowConstraints() : fill the bar with 8 rows, as to create 8 places for tiles.
    populate() : places 9 received tiles in the slots.
    NON-URGENT write documentation for BARS
*/

public class HorizontalBar extends GridPane implements Bar {
    private static final int NUM_COLS = 8;
    private static final double COL_WIDTH = Tile.SHORT_SIDE;

    private final List<? extends Tile> tiles;

    private void initializeColumnConstraints() {
        IntStream.range(0, NUM_COLS).forEach(i -> getColumnConstraints().add(new ColumnConstraints(COL_WIDTH)));
    }

    public HorizontalBar(Tile[] tiles) {
        this.tiles = List.of(tiles);
        setPrefWidth(MiddleSection.getSize());
        setPrefHeight(Tile.LONG_SIDE);

        initializeColumnConstraints();
        populate();
    }

    public void populate() {
        assert tiles.size() == 9 : "tileViews size expected: 9 but got " + tiles.size();
        IntStream.range(0, 9).forEach(i -> {
            Tile tile = tiles.get(i);
            add(tile, i, 0);
        });
    }

    public void applyRotation(double angle) {
        tiles.forEach(tile -> tile.applyRotation(angle));
    }

}