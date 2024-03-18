package be.ugent.objprog.ugentopoly.tiles;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public abstract class Tile extends GridPane {
    public final static double LONG_SIDE = ((845.0 / 13) * 2);
    public static final double SHORT_SIDE = ((845.0 / 13));

    public Tile(){
        getChildren().add(new Label("Tile"));
        // TODO add basic event handler
    }
}
