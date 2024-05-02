package be.ugent.objprog.ugentopoly;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class CustomImageView extends ImageView {
    protected static final double DROPSHADOWRADIUS = 10.0;

    public CustomImageView(double fitHeight, double fitWidth, Image image) {
        setImage(image);
        applyCommonSettings(fitHeight, fitWidth);
    }

    public CustomImageView(double fitSize) {
        applyCommonSettings(fitSize, fitSize);
    }

    // builder pattern
    public CustomImageView addDropShadow() {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(DROPSHADOWRADIUS);
        shadow.setColor(Color.BLACK);

        setEffect(shadow);

        return this;
    }

    private void applyCommonSettings(double height, double width) {
        setPreserveRatio(true);
        setFitHeight(height);
        setFitWidth(width);
    }
}