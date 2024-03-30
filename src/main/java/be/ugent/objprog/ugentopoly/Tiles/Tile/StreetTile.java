package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.TileButton;
import be.ugent.objprog.ugentopoly.Parsers.PropertyLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StreetTile extends SmallTile {
    private static final int STRIP_WIDTH = 30;

    // TODO set default to white
    private String color = "#FF5FFF";
    protected int rotatie;

    // Constructor
    public StreetTile(Record companion, String id, String color) {
        super(companion, id);
        this.color = color;

        setup(id);
    }

    @Override
    public void setup(String id) {
        HBox hbox = new HBox();

        Label label = new Label(PropertyLoader.getLabel(id));
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        label.setWrapText(true);

        StackPane pane = new StackPane(label);
        pane.setPrefWidth(Tile.LONG_SIDE - 10);
        pane.setPrefHeight(Tile.SHORT_SIDE);

        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Paint.valueOf(color));
        rectangle.setHeight(Tile.SHORT_SIDE);
        rectangle.setWidth(STRIP_WIDTH);

        HBox.setHgrow(pane, Priority.ALWAYS);
        HBox.setHgrow(rectangle, Priority.SOMETIMES);

        hbox.getChildren().addAll(pane, rectangle);
        ToggleButton toggleButton = new TileButton();
        getChildren().addAll(hbox, toggleButton);
    }
}
