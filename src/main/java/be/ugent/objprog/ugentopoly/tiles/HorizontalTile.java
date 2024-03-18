package be.ugent.objprog.ugentopoly.tiles;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
/* Tile.LONG_SIDE notation for better context. Can be used without but is clearer
*
*/


public class HorizontalTile extends Tile{
    public HorizontalTile(){
        setPrefWidth(Tile.LONG_SIDE);
        setPrefHeight(Tile.SHORT_SIDE);
        //setText("Button");




    }
}
