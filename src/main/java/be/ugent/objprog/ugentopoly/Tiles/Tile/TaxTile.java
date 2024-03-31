package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.Parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.TileButton;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class TaxTile extends SmallTile {
    private static final Image image = new Image(
            Objects.requireNonNull(
                    ChestTile.class.getResourceAsStream(
                            "/be/ugent/objprog/ugentopoly/assets/tax.png")
            ));

    // Constructor
    public TaxTile(
            Record companion,
            String id
    ){
        super(companion, id);
        setup(id);
    }

    // OPTIMIZE
    @Override
    void setup(String id) {
        TileHBox hbox = new TileHBox();

        TileImageView imageView = new TileImageView(image);

        String text = PropertyLoader.getLabel(id);
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);

        hbox.getChildren().addAll(imageView, textLabel);

        ToggleButton toggleButton = new TileButton();
        getChildren().addAll(hbox, toggleButton);
    }
}

