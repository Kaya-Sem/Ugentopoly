package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.players.Pion;
import javafx.scene.image.Image;

public enum PionFactory {
    ;

    public static Pion createPion(Image image) {
        return new Pion(image);
    }
}