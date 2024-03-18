package be.ugent.objprog.ugentopoly.tiles;

import javafx.scene.layout.ColumnConstraints;
/* Tile.LONG_SIDE notation for better context. Can be used without but is clearer
*
*/


public class HorizontalTile extends Tile{
    public HorizontalTile(){
        setPrefWidth(Tile.LONG_SIDE);
        setPrefHeight(Tile.SHORT_SIDE);
        //setText("Button");

        getColumnConstraints().addAll( // Set column constraints
                new ColumnConstraints(Tile.LONG_SIDE /4)
        );

    }
}
