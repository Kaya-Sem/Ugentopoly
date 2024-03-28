package be.ugent.objprog.ugentopoly.Tiles.TileCompanions.Tile;

import javafx.scene.image.ImageView;

public class StreetTile extends SmallTile {
    private static final double COLORSTRIP_WIDTH = 33.0;
    private static final double COLORSTRIP_HEIGHT = Tile.SHORT_SIDE;

    // TODO set default to white
    private static final String COLOR = "#FFFFFF";
    private static final ImageView image = null;
    protected int rotatie;

    // Constructor
    public StreetTile(
            Record companion,
            String text,
            String color

    ){
        setText(text);
        this.companion = companion;
        // TODO use constant that i defined!
        setStyle("-fx-background-color: " + COLOR + ", #FFFFFF; " +
                "-fx-background-insets: 0, 0 25  0 0 " + 25 + "px; " + // Adjust insets for thickness
                "-fx-background-radius: 0;"); // Ensure there's no border radius
    }
}

