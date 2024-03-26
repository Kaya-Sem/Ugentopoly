package be.ugent.objprog.ugentopoly.Bars;

import be.ugent.objprog.ugentopoly.MiddleSection;
import be.ugent.objprog.ugentopoly.TileNodes.Tile;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;

public class VerticalBar extends GridPane implements Bar {
    private static final int NUM_ROWS = 8;
    private static final double ROW_HEIGHT = Tile.SHORT_SIDE;

    public VerticalBar(){
        setPrefWidth(Tile.LONG_SIDE);
        setPrefHeight(MiddleSection.getSize());
        initializeRowConstraints();
    }

    private void initializeRowConstraints() {
        for (int i = 0; i < NUM_ROWS; i++) {
            getRowConstraints().add(new RowConstraints(ROW_HEIGHT));
        }
    }


    // Fill the bar with the nine received tiles.
    public void populate(List<? extends Tile> tiles){
        for (int i = 0; i < 9; i++) {
            Tile tile = tiles.get(i);
            add(tile, 0, i);
        }
    }
}
