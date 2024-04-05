package be.ugent.objprog.ugentopoly.tiles.tile;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tileCards.StreetCard;
import be.ugent.objprog.ugentopoly.tiles.tileCompanions.StreetCompanion;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StreetTile extends SmallTile {

    private static final int STRIP_WIDTH = 30;
    private final String color;
    private final String text;

    // Constructor
    public StreetTile(StreetCompanion companion, String id, String color) {
        super(companion, id);
        this.color = color;
        this.text = PropertyLoader.getLabel(id);
        setup(id);
        this.card = new StreetCard(text, color, companion);
    }

    @Override
    public void setup(String id) {
        HBox hbox = new HBox();

        Label label = new Label(this.text);
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        label.setWrapText(true);

        StackPane pane = new StackPane(label);
        pane.setPrefWidth(Tile.LONG_SIDE - 10);
        pane.setPrefHeight(Tile.SHORT_SIDE);

        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Paint.valueOf(this.color));
        rectangle.setHeight(Tile.SHORT_SIDE);
        rectangle.setWidth(STRIP_WIDTH);
        setAlignment(rectangle, Pos.CENTER_RIGHT);

        HBox.setHgrow(pane, Priority.ALWAYS);

        hbox.getChildren().addAll(pane, rectangle);

        getChildren().addAll(hbox, tileButton);
    }
}