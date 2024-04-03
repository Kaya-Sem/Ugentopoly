package be.ugent.objprog.ugentopoly.TileCards;

import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;
import be.ugent.objprog.ugentopoly.Tiles.TileCompanions.StreetCompanion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StreetCard extends HorizontalCard {
    public StreetCard(String text, String color, StreetCompanion c) {

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(20, 20, 20, 20));


        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 15));

        Label cost = new Label(c.cost() + "€");
        cost.setFont(Font.font("Arial", FontWeight.THIN, 11));

        HBox rent1 = new rentLabel("level 1", c.rent1());
        HBox rent2 = new rentLabel("level 2", c.rent2());
        HBox rent3 = new rentLabel("level 3", c.rent3());
        HBox rent4 = new rentLabel("level 4", c.rent4());
        HBox rent5 = new rentLabel("level 5", c.rent5());

        VBox info = new VBox(
                textLabel,
                cost,
                new Label("\n"),
                new rentLabel("level 0", c.rent0()),
                rent1,
                rent2,
                rent3,
                rent4,
                rent5
        );

        info.setAlignment(Pos.CENTER_LEFT);

        Rectangle bar = new Rectangle(Tile.SHORT_SIDE - 3, HEIGHT - 3);
        bar.setFill(Paint.valueOf(color));
        bar.setArcHeight(20);
        bar.setArcWidth(20);


        hBox.getChildren().addAll(info);
        hBox.setAlignment(Pos.CENTER_LEFT);

        setAlignment(bar, Pos.CENTER_RIGHT);

        getChildren().addAll(hBox, bar);
    }


    private static class rentLabel extends HBox {
        public rentLabel(String preText, String rentAmount){
            Label text = new Label(preText);
            Label amount = new Label(rentAmount + "€");
            amount.setAlignment(Pos.CENTER_RIGHT);
            setAlignment(Pos.CENTER_LEFT);
            setSpacing(30);
        getChildren().addAll(text, amount);
        }
    }
}
