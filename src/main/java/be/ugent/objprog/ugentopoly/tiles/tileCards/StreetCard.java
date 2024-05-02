package be.ugent.objprog.ugentopoly.tiles.tileCards;

import be.ugent.objprog.ugentopoly.tiles.tileModels.StreetTileModel;
import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import static javafx.geometry.Pos.*;

public class StreetCard extends HorizontalCard {
    protected static final int ROUNDING = 20;
    protected static final int PADDING = 35;

    public StreetCard(StreetTileModel model) {
        Label nameLabel = new Label(model.getName());
        Label costLabel = new Label("€" + model.getCost());
        Label ownerLabel = new Label();
        ownerLabel.textProperty().bind(model.ownerProperty());

        nameLabel.getStyleClass().add("bold-label-large");
        ownerLabel.getStyleClass().add("owner-label");
        costLabel.getStyleClass().add("thin-label-medium");

        HBox title = new HBox(nameLabel, costLabel);
        title.setAlignment(CENTER_LEFT);
        title.setSpacing(10);

        VBox info = new VBox(
                title,
                ownerLabel,
                new Label("\n"),
                new Label("rent: €" + model.getRent())
        );

        info.setAlignment(TOP_LEFT);
        info.setPadding(new Insets(PADDING));

        Rectangle coloredBar = new Rectangle(TileView.SHORT_SIDE - 3, HEIGHT - 3);
        coloredBar.setFill(Paint.valueOf(model.getColor()));
        coloredBar.setArcHeight(ROUNDING);
        coloredBar.setArcWidth(ROUNDING);

        setAlignment(coloredBar, CENTER_RIGHT);

        getChildren().addAll(info, coloredBar);
    }

}