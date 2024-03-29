package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.Parsers.PropertyLoader;
import javafx.scene.control.Label;

public class StreetTile extends SmallTile {
    private static final int COLORSTRIP_WIDTH = 33;
    private static final double COLORSTRIP_HEIGHT = Tile.SHORT_SIDE; //TODO remove

    // TODO set default to white
    private static final String color = "#FF5FFF";
    protected int rotatie;

    // Constructor
    public StreetTile(
            Record companion,
            String id
    ){
        super(companion, id);

        Label label = new Label(PropertyLoader.getTileText(id));
        getChildren().add(label);

        setStyle("-fx-background-color: " + color + ", #FFFFFF; " +
                "-fx-background-insets: 0, 0 25 0 0 " + 55 + "px; " + // Adjust insets for thickness
                "-fx-background-radius: 0;"); // Ensure there's no border radius
    }
}

