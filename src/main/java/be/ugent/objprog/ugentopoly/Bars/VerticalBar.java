package be.ugent.objprog.ugentopoly.Bars;

import be.ugent.objprog.ugentopoly.Tiles.HorizontalTile;
import be.ugent.objprog.ugentopoly.Tiles.MiddleSection;
import be.ugent.objprog.ugentopoly.Tiles.Tile;
import be.ugent.objprog.ugentopoly.Tiles.VerticalTile;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;

public class VerticalBar extends GridPane implements Bar {
    private static final RowConstraints[] ROW_CONSTRAINTS = {
            new RowConstraints(VerticalTile.SHORT_SIDE),
            new RowConstraints(VerticalTile.SHORT_SIDE),
            new RowConstraints(VerticalTile.SHORT_SIDE),
            new RowConstraints(VerticalTile.SHORT_SIDE),
            new RowConstraints(VerticalTile.SHORT_SIDE),
            new RowConstraints(VerticalTile.SHORT_SIDE),
            new RowConstraints(VerticalTile.SHORT_SIDE),
            new RowConstraints(VerticalTile.SHORT_SIDE),
            // TODO maybe create a class or enum for this, too much repetition
    };


    public VerticalBar(){
        setPrefWidth(VerticalTile.LONG_SIDE);
        setPrefHeight(MiddleSection.getSize());
        getRowConstraints().addAll(ROW_CONSTRAINTS);
        setAlignment(Pos.CENTER);
    }
    public void addChildren(List<? extends Tile> tiles){
        for (int i = 0; i < 9; i++) {
            Tile tile = tiles.get(i);
            add(tile, 0, i);
        }

    }
}
