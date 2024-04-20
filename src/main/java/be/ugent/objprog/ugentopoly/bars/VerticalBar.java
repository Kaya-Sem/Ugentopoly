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
    private static final int NUMTILES = 9;
    private static final double ROW_HEIGHT = Tile.SHORT_SIDE;
    private final List<? extends Tile> tiles;

    public VerticalBar(List<Tile> tiles) {
        this.tiles = tiles;
        setMinWidth(Tile.LONG_SIDE);
        setMaxWidth(Tile.LONG_SIDE);
        setMinHeight(MiddleSection.getSize());
        setMaxHeight(MiddleSection.getSize());

        initializeRowConstraints();
        populate();
    }

    private void initializeRowConstraints() {
        IntStream.range(1, NUMTILES).forEach(i -> getRowConstraints().add(new RowConstraints(ROW_HEIGHT)));
    }

    public void populate() {
        IntStream.range(0, NUMTILES).forEach(i -> add(tiles.get(i), 0, i));
    }

    public void applyRotation(double angle) {
        tiles.forEach(tile -> tile.applyRotation(angle));
    }
}