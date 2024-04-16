package be.ugent.objprog.ugentopoly.players;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pion extends ImageView {
    private static final double SIZE = 30.0;

    public Pion(Image image) {
        setImage(image);

        setPreserveRatio(true);
        setFitHeight(SIZE);
        setFitWidth(SIZE);

    }
}