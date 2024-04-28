package be.ugent.objprog.ugentopoly.tiles.tileCards;

import be.ugent.objprog.ugentopoly.gameBoard.BoardModel;
import be.ugent.objprog.ugentopoly.gameBoard.MiddleSection;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VerticalCard extends TemplateCard {
    public static final Double HEIGHT = BoardModel.MIDDLE_AREA_SIZE / 2;
    public static final Double WIDTH = BoardModel.MIDDLE_AREA_SIZE / 3;


    public VerticalCard() {
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

        // TODO i think this is unneeded
        StackPane content = new StackPane();
        content.setPadding(new Insets(10, 10, 10, 10));
        content.setBackground(Background.fill(Color.TRANSPARENT));
        content.setAlignment(Pos.CENTER);

        getChildren().addAll(border, content);
    }
}