package be.ugent.objprog.ugentopoly.tiles;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class TileButton extends ToggleButton {

    public static final ToggleGroup TOGGLE_GROUP = new ToggleGroup();

    public TileButton() {
        setMaxWidth(Double.MAX_VALUE);
        setMaxHeight(Double.MAX_VALUE);
        setToggleGroup(TOGGLE_GROUP);
        setStyle("-fx-background-color: transparent;");
    }
}