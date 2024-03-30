package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.Parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.TileButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.Map;
import java.util.Objects;

public class CornerTile extends Tile{

    private static final Map<String, String> IMAGES = Map.of(
            "tile.start", "/be/ugent/objprog/ugentopoly/assets/start.png",
            "tile.jail", "/be/ugent/objprog/ugentopoly/assets/jail.png",
            "tile.freeparking", "/be/ugent/objprog/ugentopoly/assets/free_parking.png",
            "tile.gotojail", "/be/ugent/objprog/ugentopoly/assets/go_to_jail.png"
    );

    public CornerTile(Record companion, String id) {
        super(companion, id);
        setMinHeight(Tile.LONG_SIDE);
        setMinWidth(Tile.LONG_SIDE);
        setAlignment(Pos.CENTER);

        setup(id);
    }

    @Override
    void setup(String id) {
        ToggleButton toggleButton = new TileButton();
        String text = PropertyLoader.getLabel(id);

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(IMAGES.get(id))));
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(Tile.LONG_SIDE - 20);
        imageView.setFitHeight(Tile.LONG_SIDE - 20);
        imageView.setPreserveRatio(true);

        StackPane stackPane = new StackPane();
        stackPane.setPadding(new Insets(20));

        Label label = new Label(null, stackPane);
        label.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();

        setAlignment(vbox, Pos.CENTER);
        vbox.getChildren().addAll(new Label(text), label);


        getChildren().addAll(vbox, toggleButton);

    }
}
