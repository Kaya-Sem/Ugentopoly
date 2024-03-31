package be.ugent.objprog.ugentopoly.Tiles.Tile;

import java.util.Map;

abstract public class CornerTile extends Tile{

    protected static final Map<String, String> IMAGES = Map.of(
            "tile.start", "/be/ugent/objprog/ugentopoly/assets/start.png /be/ugent/objprog/ugentopoly/assets/start-arrow.png",
            "tile.jail", "/be/ugent/objprog/ugentopoly/assets/jail.png",
            "tile.freeparking", "/be/ugent/objprog/ugentopoly/assets/free_parking.png",
            "tile.gotojail", "/be/ugent/objprog/ugentopoly/assets/go_to_jail.png"
    );

    public CornerTile(Record companion, String id) {
        super(companion, id);
        setMinHeight(Tile.LONG_SIDE);
        setMinWidth(Tile.LONG_SIDE);

        setup(id);
    }

    abstract void setup(String id);
}
