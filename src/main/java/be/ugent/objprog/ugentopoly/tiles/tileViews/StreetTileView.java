package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.tiles.tileModels.StreetTileModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class StreetTileView extends SmallTileView {

    private static final int COLORSTRIP_WIDTH = 30;

    public StreetTileView(StreetTileModel model) {
        super(model);

        Label label = new Label(model.getName());
        label.setAlignment(Pos.CENTER);
        label.getStyleClass().add("bold-label-small");
        label.setWrapText(true);

        StackPane pane = new StackPane(label);
        pane.setPrefWidth(LONG_SIDE - 10);
        pane.setPrefHeight(SHORT_SIDE);

        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Paint.valueOf(model.getColor()));
        rectangle.setHeight(SHORT_SIDE);
        rectangle.setWidth(COLORSTRIP_WIDTH);
        setAlignment(rectangle, Pos.CENTER_RIGHT);

        HBox.setHgrow(pane, Priority.ALWAYS);

        HBox hbox = new HBox(pane, rectangle);
        getChildren().addAll(hbox, badgeHolders, tileButton);
    }
}