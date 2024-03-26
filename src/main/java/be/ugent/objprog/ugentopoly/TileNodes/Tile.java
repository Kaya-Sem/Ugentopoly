package be.ugent.objprog.ugentopoly.TileNodes;

import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class Tile extends ToggleButton {
    public final static double LONG_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES) * 2);
    public static final double SHORT_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES));

    public Tile(){
        setOnAction(new ButtonHandler());

        //TODO is this border needed? I think it can be removed -> css styling
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
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