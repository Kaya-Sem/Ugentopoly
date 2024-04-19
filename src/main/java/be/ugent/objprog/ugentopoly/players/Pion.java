package be.ugent.objprog.ugentopoly.players;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Pion extends ImageView {
    private static final double SIZE = 50.0;
    protected static final double DROPSHADOWRADIUS = 10.0;

    public Pion(Image image) {
        setImage(image);
        setPreserveRatio(true);
        setFitHeight(SIZE);
        setFitWidth(SIZE);

        // Create a drop shadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(DROPSHADOWRADIUS);
        dropShadow.setColor(Color.BLACK);

        // Apply the drop shadow effect to the ImageView
        setEffect(dropShadow);
    }
}