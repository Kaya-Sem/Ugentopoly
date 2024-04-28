package be.ugent.objprog.ugentopoly;

import javafx.scene.image.Image;
import java.io.InputStream;

public class CustomImage extends Image {

    public CustomImage(InputStream is) {
        super(is);
    }

    public CustomImage(String imageName) {
        super(makeInputStream(imageName));
    }

    private static InputStream makeInputStream(String imageName) {
        InputStream is = CustomImage.class.getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/" + imageName);
        if (null == is) {
            throw new IllegalArgumentException("Image not found: " + imageName);
        }
        return is;
    }
}