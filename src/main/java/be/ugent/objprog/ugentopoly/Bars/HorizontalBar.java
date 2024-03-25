package be.ugent.objprog.ugentopoly.Bars;

import be.ugent.objprog.ugentopoly.MiddleSection;
import be.ugent.objprog.ugentopoly.TileNodes.Tile;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import java.util.List;

public class HorizontalBar extends GridPane implements Bar{
    private static final ColumnConstraints[] COLUMN_CONSTRAINTS = {
            new ColumnConstraints(Tile.SHORT_SIDE),
            new ColumnConstraints(Tile.SHORT_SIDE),
            new ColumnConstraints(Tile.SHORT_SIDE),
            new ColumnConstraints(Tile.SHORT_SIDE),
            new ColumnConstraints(Tile.SHORT_SIDE),
            new ColumnConstraints(Tile.SHORT_SIDE),
            new ColumnConstraints(Tile.SHORT_SIDE),
            new ColumnConstraints(Tile.SHORT_SIDE),
    };


    public HorizontalBar() {
        setPrefWidth(MiddleSection.getSize());
        setPrefHeight(Tile.LONG_SIDE);
        getColumnConstraints().addAll(
            COLUMN_CONSTRAINTS
        );
    }

    public void populate(List<? extends Tile> tiles){
        for (int i = 0; i < 9; i++) {
            Tile tile = tiles.get(i);
            add(tile, i, 0);
        }
    }
}
