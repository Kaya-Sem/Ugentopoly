package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.GameBoard.Board;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;

public abstract class Tile extends StackPane {
    public final static double LONG_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES) * 2);
    public final static double SHORT_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES));
    protected ToggleButton toggleButton;
    Record companion;
    String id;

    public Tile(
            Record companion,
            String id
    ){
        this.companion = companion;
        this.id = id;

        this.toggleButton = new ToggleButton();

        // Button setup
        toggleButton.setMaxWidth(Double.MAX_VALUE);
        toggleButton.setMaxHeight(Double.MAX_VALUE);
        setAlignment(toggleButton, Pos.CENTER);
        toggleButton.setToggleGroup(Board.TOGGLE_GROUP);
        toggleButton.setStyle("-fx-background-color: transparent;");
        toggleButton.setOnAction(new ButtonHandler());

        getChildren().add(toggleButton);
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
