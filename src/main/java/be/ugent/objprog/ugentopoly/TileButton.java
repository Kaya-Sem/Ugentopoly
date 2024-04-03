package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.GameBoard.Board;
import javafx.scene.control.ToggleButton;

public class TileButton extends ToggleButton {

    public TileButton() {
        setMaxWidth(Double.MAX_VALUE);
        setMaxHeight(Double.MAX_VALUE);
        setToggleGroup(Board.TOGGLE_GROUP);
        setStyle("-fx-background-color: transparent;");
    }
}
