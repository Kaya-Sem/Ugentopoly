package be.ugent.objprog.ugentopoly;

import javafx.scene.image.Image;

public enum ApplicationIcon {
    ;

    public static Image icon() {
        return new Image(ApplicationIcon.class.getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/chest.png"));
    }
}