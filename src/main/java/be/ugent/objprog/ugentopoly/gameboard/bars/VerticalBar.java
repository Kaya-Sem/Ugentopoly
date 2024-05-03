package be.ugent.objprog.ugentopoly.gameboard.bars;

import java.util.List;
import java.util.stream.IntStream;

import be.ugent.objprog.ugentopoly.gameboard.BoardModel;
import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/*
    initializeRowConstraints() : fill the bar with 8 rows, as to create 8 places for tiles.
    populate() : places 9 received tiles in the slots.
    NON-URGENT write documentation for BARS
*/

public class VerticalBar extends GridPane implements Bar {
    private static final double ROW_HEIGHT = TileView.SHORT_SIDE;
    private final List<? extends TileView> tiles;
    private static final int TILESLOTS = 9;

    public VerticalBar(List<TileView> tileViews) {
        tiles = tileViews;
        applyDefaults();
    }

    public VerticalBar(List<TileView> tileViews, int direction) {
        tiles = tileViews;
        applyDefaults();
        setRotate(direction);
    }

    private void applyDefaults() {
        setMinWidth(TileView.LONG_SIDE);
        setMaxWidth(TileView.LONG_SIDE);
        setMinHeight(BoardModel.MIDDLE_AREA_SIZE);
        setMaxHeight(BoardModel.MIDDLE_AREA_SIZE);

        initializeRowConstraints();
        populate();
    }

    private void initializeRowConstraints() {
        IntStream.range(1, TILESLOTS).forEach(i -> getRowConstraints().add(new RowConstraints(ROW_HEIGHT)));
    }

    public void populate() {
        IntStream.range(0, TILESLOTS).forEach(i -> add(tiles.get(i), 0, i));
    }

    public void applyRotation(int angle) {
        tiles.forEach(tile -> tile.applyRotation(angle));
    }
}