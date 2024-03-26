package be.ugent.objprog.ugentopoly.TileNodes;

import javafx.scene.image.ImageView;

public class StreetTile extends SmallTile {
    private static final double COLORSTRIP_WIDTH = 33.0;
    private static final double COLORSTRIP_HEIGHT = Tile.SHORT_SIDE;

    private static final String COLOR = "#FF0000";
    private static final ImageView image = null;
    protected int rotatie;

    // Constructor
    public StreetTile(
            int rotatie,
            String text,
            String color
    ){
        super(rotatie);
        setText(text);
        setStyle("-fx-background-color: " + COLOR + ", #FFFFFF; " +
                "-fx-background-insets: 0, 0 25  0 0 " + 25 + "px; " + // Adjust insets for thickness
                "-fx-background-radius: 0;"); // Ensure there's no border radius
    }
}

