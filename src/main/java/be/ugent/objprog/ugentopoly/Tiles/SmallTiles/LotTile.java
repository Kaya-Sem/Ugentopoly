package be.ugent.objprog.ugentopoly.Tiles.SmallTiles;

import be.ugent.objprog.ugentopoly.Tiles.Tile;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LotTile extends SmallTile{
    private static final double RECTANGLE_WIDTH = 33.0;
    private static final double RECTANGLE_HEIGHT = Tile.SHORT_SIDE;

    private static final Color COLOR = Color.BLACK;
    private static final ImageView image = null;

    public LotTile(){
    Rectangle colorZone = new Rectangle(RECTANGLE_WIDTH, RECTANGLE_HEIGHT, COLOR);
        colorZone.setTranslateX((Tile.LONG_SIDE - RECTANGLE_WIDTH) / 2); // Centering the rectangle horizontally

    // Create a StackPane to overlay the colored rectangle on the toggle button
    StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(this, colorZone); // Add the toggle button and colored rectangle to the stack pane
        StackPane.setAlignment(colorZone, javafx.geometry.Pos.CENTER); // Center the colored rectangle within the stack pane

    // Set the stack pane as the content of the toggle button
    setContentDisplay(ContentDisplay.GRAPHIC_ONLY); // Show only the graphic content (the colored rectangle)
    setGraphic(stackPane);
    }
}
