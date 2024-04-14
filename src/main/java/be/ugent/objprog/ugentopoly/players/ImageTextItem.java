package be.ugent.objprog.ugentopoly.players;

import javafx.scene.image.Image;

public record ImageTextItem(String text, Image image) {

    @Override
    public String toString() {
        return text; // Display text in combo box
    }
}