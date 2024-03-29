package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.scene.layout.StackPane;

public abstract class Tile extends StackPane {
    public final static double LONG_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES) * 2);
    public final static double SHORT_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES));

    Record companion;
    String id;

    public Tile(Record companion, String id){
        this.companion = companion;
        this.id = id;
    }

    abstract void setup();
}

