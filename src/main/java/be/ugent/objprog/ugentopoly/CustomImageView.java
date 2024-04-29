package be.ugent.objprog.ugentopoly;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CustomImageView extends ImageView {
    public CustomImageView() {
        setPreserveRatio(true);
    }

    public CustomImageView(double fitHeight, double fitWidth ) {
        applyCommonSettings(fitHeight, fitWidth);
    }

    public CustomImageView(double fitHeight, double fitWidth, Image image) {
        setImage(image);
        applyCommonSettings(fitHeight, fitWidth);
    }

    public CustomImageView(double fitSize) {
        applyCommonSettings(fitSize, fitSize);
    }

    private void applyCommonSettings(double height, double width) {
        setPreserveRatio(true);
        setFitHeight(height);
        setFitWidth(width);
    }
}