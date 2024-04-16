package be.ugent.objprog.ugentopoly.bars;

import java.util.List;
import java.util.stream.IntStream;

import be.ugent.objprog.ugentopoly.gameBoard.MiddleSection;
import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/*
    initializeRowConstraints() : fill the bar with 8 rows, as to create 8 places for tiles.
    populate() : places 9 received tiles in the slots.
    NON-URGENT write documentation for BARS
*/

public class VerticalBar extends GridPane implements Bar {
    private static final int NUM_ROWS = 8;
    private static final double ROW_HEIGHT = Tile.SHORT_SIDE;

    private final List<? extends Tile> tiles;

    public VerticalBar(Tile[] tiles) {
        this.tiles = List.of(tiles);
        setPrefWidth(Tile.LONG_SIDE);
        setPrefHeight(MiddleSection.getSize());

        initializeRowConstraints();
        populate();
    }

    private void initializeRowConstraints() {
        IntStream.range(0, NUM_ROWS).forEach(i -> getRowConstraints().add(new RowConstraints(ROW_HEIGHT)));
    }

    public void populate() {
        assert tiles.size() == 9 : "tileViews size expected: 9 but got " + tiles.size();
        IntStream.range(0, 9).forEach(i -> {
            Tile tile = tiles.get(i);
            add(tile, 0, i);
        });
    }

    public void applyRotation(double angle) {
        tiles.forEach(tile -> tile.applyRotation(angle));
    }
}