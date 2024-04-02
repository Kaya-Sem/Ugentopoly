package be.ugent.objprog.ugentopoly.Cards;

import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Card extends StackPane {
    public static final Double HEIGHT = Tile.LONG_SIDE * 2 + Tile.SHORT_SIDE;
    public static final Double WIDTH = Tile.LONG_SIDE + Tile.SHORT_SIDE;


    public Card() {
        setMinHeight(HEIGHT);
        setMinWidth(WIDTH);
        setMaxHeight(HEIGHT);
        setMaxWidth(WIDTH);
        setBackground(Background.fill(Color.TRANSPARENT));

        Rectangle border = new Rectangle(WIDTH, HEIGHT);
        border.setStroke(Color.BLACK);
        border.setStrokeWidth(3);
        border.setFill(Color.WHITE);
        border.setArcHeight(20);
        border.setArcWidth(20);

        // Apply drop shadow effect to the rectangle
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);
        dropShadow.setOffsetX(-5);
        dropShadow.setOffsetY(5);
        dropShadow.setColor(Color.DIMGREY); // Set the color of the drop shadow
        border.setEffect(dropShadow);

        getChildren().add(border);
    }
}
