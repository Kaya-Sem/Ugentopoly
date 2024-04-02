package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;
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

        getChildren().add(border);
    }
}
