package be.ugent.objprog.ugentopoly.players;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Pion extends ImageView {
    private static final double SIZE = 30.0;
    protected static final double DROPSHADOWRADIUS = 10.0;

    public Pion(Image image) {
        setImage(image);
        setPreserveRatio(true);
        setFitHeight(SIZE);
        setFitWidth(SIZE);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(DROPSHADOWRADIUS);
        dropShadow.setColor(Color.BLACK);

        setEffect(dropShadow);
    }
}