package be.ugent.objprog.ugentopoly.gameboard.bars;

import java.util.List;
import java.util.stream.IntStream;

import be.ugent.objprog.ugentopoly.gameboard.BoardModel;
import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/*
    initializeRowConstraints() : fill the bar with 8 rows, as to create 8 places for tiles.
    populate() : places 9 received tiles in the slots.
    NON-URGENT write documentation for BARS
*/

public class HorizontalBar extends GridPane implements Bar {
    private static final double COL_WIDTH = TileView.SHORT_SIDE;
    private static final double OFFSET = 14.5;
    private final List<? extends TileView> tiles;
    private static final int TILESLOTS = 9;

    public HorizontalBar(List<TileView> tileViews, int direction) {
        tiles = tileViews;
        applyDefaults();
        applyRotation(direction);
    }

    private void applyDefaults() {
        setMinWidth(BoardModel.MIDDLE_AREA_SIZE);
        setMaxWidth(BoardModel.MIDDLE_AREA_SIZE);
        setMinHeight(TileView.LONG_SIDE);
        setMaxHeight(TileView.LONG_SIDE);

        initializeColumnConstraints();
        populate();
    }

    private void initializeColumnConstraints() {
        IntStream.range(1, TILESLOTS).forEach(i -> getColumnConstraints().add(new ColumnConstraints(COL_WIDTH)));
    }

    public void populate() {
        IntStream.range(0, TILESLOTS).forEach(i -> add(tiles.get(i), i, 0));
    }

    public void applyRotation(int angle) {
        setTranslateX(-OFFSET);
        setTranslateY(+OFFSET);
        tiles.forEach(tile -> tile.applyRotation(angle));
    }

}