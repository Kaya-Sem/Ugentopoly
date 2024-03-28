package be.ugent.objprog.ugentopoly.Tiles.TileCompanions.Tile;

import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

public abstract class Tile extends ToggleButton {
    public final static double LONG_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES) * 2);
    public static final double SHORT_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES));

   Record companion;
   String id;

    public Tile(Record companion, String id){

        this.companion = companion;
        this.id = id;

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
