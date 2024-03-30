package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.Parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.TileButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class ChanceTile extends SmallTile {
    private static final Image image = new Image(
            Objects.requireNonNull(
                    ChestTile.class.getResourceAsStream(
                            "/be/ugent/objprog/ugentopoly/assets/chance.png")
            ));

    // Constructor
    public ChanceTile(
            Record companion,
            String id
    ){
        super(companion, id);
    }

    // OPTIMIZE
    @Override
    void setup(String id) {
        HBox hbox = new HBox();
        hbox.setMinWidth(Tile.LONG_SIDE);
        hbox.setMaxWidth(Tile.LONG_SIDE);
        hbox.setMinWidth(Tile.LONG_SIDE);
        hbox.setMaxWidth(Tile.LONG_SIDE);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(20);
        hbox.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(ChestTile.SHORT_SIDE / 2);
        imageView.setFitWidth(ChestTile.SHORT_SIDE / 2);
        imageView.setPreserveRatio(true);


        String text = PropertyLoader.getLabel(id);
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        textLabel.setWrapText(true);

        hbox.getChildren().addAll(imageView, textLabel);

        ToggleButton toggleButton = new TileButton();
        getChildren().addAll(hbox, toggleButton);
    }
}

