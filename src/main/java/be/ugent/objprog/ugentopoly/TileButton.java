package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.GameBoard.Board;
import be.ugent.objprog.ugentopoly.GameBoard.MiddleSection;
import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;

public class TileButton extends ToggleButton {

    public TileButton() {
        setMaxWidth(Double.MAX_VALUE);
        setMaxHeight(Double.MAX_VALUE);
        setToggleGroup(Board.TOGGLE_GROUP);
        setStyle("-fx-background-color: transparent;");
    }

    /* MVC model? set a current present card current game state: selected card: None/VerticalCard
    static class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {


            System.err.println((isSelected) ? this + " Button selected" : this + "Button deselected");
        }
    }*/
}
