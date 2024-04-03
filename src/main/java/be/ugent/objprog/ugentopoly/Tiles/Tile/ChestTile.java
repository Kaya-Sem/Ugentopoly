package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.Parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.TileButton;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class ChestTile extends SmallTile {

    private static final Image image = new Image(
            Objects.requireNonNull(
                    ChestTile.class.getResourceAsStream(
                            "/be/ugent/objprog/ugentopoly/assets/chest.png")
            ));

    // Constructor
    public ChestTile(Record companion, String id){
        super(companion, id);
        setup(id);
    }

    public ChestTile(String id) {
        super(id);
        setup(id);
    }


    // OPTIMIZE
    protected void setup(String id) {
        TileHBox hBox = new TileHBox();

        TileImageView imageView = new TileImageView(image);

        String text = PropertyLoader.getLabel(id);
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);

        hBox.getChildren().addAll(imageView, textLabel);

        getChildren().addAll(hBox, tileButton);
    }
}

