package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.tiles.tileCards.StreetCard;
import be.ugent.objprog.ugentopoly.tiles.tileModels.StreetTileModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StreetTileView extends SmallTile {

    private final StreetTileModel model;
    private static final int STRIP_WIDTH = 30;
    private String owner = ""; // TODO implement owner in tilemodel and have it Simple. blah blah

    // Constructor
    public StreetTileView(StreetTileModel model) {
        super(model);
        this.model = model;
        this.model.addListener(this);
        card = new StreetCard(this.model);
        setup();
        // NEEDSLOG
    }

    @Override
    public void setup() {
        HBox hbox = new HBox();

        Label label = new Label(model.getStreetName());
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        label.setWrapText(true);

        StackPane pane = new StackPane(label);
        pane.setPrefWidth(LONG_SIDE - 10);
        pane.setPrefHeight(SHORT_SIDE);

        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Paint.valueOf(model.getColor()));
        rectangle.setHeight(SHORT_SIDE);
        rectangle.setWidth(STRIP_WIDTH);
        setAlignment(rectangle, Pos.CENTER_RIGHT);

        HBox.setHgrow(pane, Priority.ALWAYS);

        hbox.getChildren().addAll(pane, rectangle);

        getChildren().addAll(hbox, tileButton);
    }

    @Override
    public void invalidated(Observable observable) {
        super.invalidated(observable);
        StreetTileModel streetTileModel = (StreetTileModel) observable;
        owner = streetTileModel.getOwner();
    }
}