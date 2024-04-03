package be.ugent.objprog.ugentopoly.TileCards;

import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;
import be.ugent.objprog.ugentopoly.Tiles.TileCompanions.StreetCompanion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import static javafx.geometry.Pos.*;
import static javafx.geometry.Pos.CENTER_RIGHT;

public class StreetCard extends HorizontalCard {
    public StreetCard(String text, String color, StreetCompanion c) {



        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 15));

        Label cost = new Label(c.cost() + "€");
        cost.setFont(Font.font("Arial", FontWeight.THIN, 11));

        VBox info = new VBox(
                textLabel,
                cost,
                new Label("\n"),
                new rentLabel("rent 0", c.rent0()),
                new rentLabel("rent 1", c.rent1()),
                new rentLabel("rent 2", c.rent2()),
                new rentLabel("rent 3", c.rent3()),
                new rentLabel("rent 4", c.rent4()),
                new rentLabel("rent 5", c.rent5())
        );

        info.setAlignment(CENTER_LEFT);
        info.setMaxWidth(WIDTH / 2);
//        info.setPadding(new Insets(20, 20, 20, 20));

        Rectangle bar = new Rectangle(Tile.SHORT_SIDE - 3, HEIGHT - 3);
        bar.setFill(Paint.valueOf(color));
        bar.setArcHeight(20);
        bar.setArcWidth(20);


        HBox hBox = new HBox(info);
        hBox.setAlignment(CENTER);
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.setAlignment(CENTER_LEFT);

        setAlignment(bar, CENTER_RIGHT);

        getChildren().addAll(hBox, bar);
    }


    private static class rentLabel extends HBox {
        public rentLabel(String preText, String rentAmount){
            Label text = new Label(preText);
            Label amount = new Label(rentAmount + "€");
            amount.setFont(Font.font("Arial", FontWeight.BOLD, 13));
            Region region = new Region();

            setHgrow(region, Priority.ALWAYS);

            setAlignment(CENTER_LEFT);
            setSpacing(30);
        getChildren().addAll(text, region, amount);
        }
    }
}
