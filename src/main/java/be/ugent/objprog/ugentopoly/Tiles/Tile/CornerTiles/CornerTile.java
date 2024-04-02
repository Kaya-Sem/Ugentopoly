package be.ugent.objprog.ugentopoly.Tiles.Tile.CornerTiles;

import be.ugent.objprog.ugentopoly.TileButton;
import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;

import java.util.Map;

abstract public class CornerTile extends Tile {
   final TileButton tileButton = new TileButton();

    protected static final Map<String, String> IMAGES = Map.of(
            "tile.jail", "/be/ugent/objprog/ugentopoly/assets/jail.png",
            "tile.freeparking", "/be/ugent/objprog/ugentopoly/assets/free_parking.png",
            "tile.gotojail", "/be/ugent/objprog/ugentopoly/assets/go_to_jail.png"
    );

    public CornerTile(Record companion, String id) {
        super(companion, id);
        setMinHeight(Tile.LONG_SIDE);
        setMaxHeight(Tile.LONG_SIDE);
        setMaxWidth(Tile.LONG_SIDE);
        setMinWidth(Tile.LONG_SIDE);

        tileButton.setOnAction(event -> handleButton(event, companion));
    }
}
