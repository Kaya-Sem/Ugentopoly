package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.TileButton;
import javafx.scene.image.Image;

import java.util.Objects;

public class StartTile extends CornerTile{

    public StartTile(Record companion, String id){
        super(companion, id);
        setup(id);
    }

    // TODO make res path a constant
    void setup(String id){
        String[] paths = CornerTile.IMAGES.get(id).split(" ");

        Image arrow = new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(paths[1])));

        Image start = new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(paths[0])));


        TileButton toggleButton = new TileButton();
        getChildren().addAll(toggleButton);

    }
}
