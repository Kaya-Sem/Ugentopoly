package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.GameBoard.Board;
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

        setOnAction(new ButtonHandler());
    }


    // TODO add basic event handler. On button press, display card in center of board with the card information
    // MVC model? set a current present card
    static class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            ToggleButton source  =(ToggleButton) event.getSource();
            boolean isSelected = source.isSelected();
            if(isSelected) {
                System.out.println("Button selected");
            } else {
                System.out.println("Button is deselected");
            }
        }
}
}
