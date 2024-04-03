package be.ugent.objprog.ugentopoly.TileCards;

import be.ugent.objprog.ugentopoly.GameBoard.MiddleSection;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HorizontalCard extends TemplateCard {

    public static final Double WIDTH = MiddleSection.getSize() / 2;
    public static final Double HEIGHT = MiddleSection.getSize() / 3;

    public HorizontalCard() {
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

        getChildren().addAll(border);
    }
}
