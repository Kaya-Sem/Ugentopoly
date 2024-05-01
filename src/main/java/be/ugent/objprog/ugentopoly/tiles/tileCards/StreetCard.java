package be.ugent.objprog.ugentopoly.tiles.tileCards;

import be.ugent.objprog.ugentopoly.tiles.tileModels.StreetTileModel;
import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static javafx.geometry.Pos.*;

public class StreetCard extends HorizontalCard {
    protected static final int ROUNDING = 20;
    protected static final int PADDING = 35;

    public StreetCard(StreetTileModel model) {
        Label textLabel = new Label(model.getName());
        textLabel.setFont(Font.font("Raleway", FontWeight.EXTRA_BOLD, 15));

        Label costLabel = new Label("€" + model.getCost());
        costLabel.setFont(Font.font("Arial", FontWeight.THIN, 11));

        VBox info = new VBox(
                textLabel,
                costLabel,
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