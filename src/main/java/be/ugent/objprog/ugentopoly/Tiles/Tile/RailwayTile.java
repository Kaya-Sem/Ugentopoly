package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.Parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.TileButton;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class RailwayTile extends SmallTile {
    private static final Image image = new Image(
            Objects.requireNonNull(
                    ChestTile.class.getResourceAsStream(
                            "/be/ugent/objprog/ugentopoly/assets/railway.png")
            ));

    // Constructor
    public RailwayTile(
            Record companion,
            String id
    ){
        super(companion, id);
    }

    // OPTIMIZE
    @Override
    protected void setup(String id) {
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

