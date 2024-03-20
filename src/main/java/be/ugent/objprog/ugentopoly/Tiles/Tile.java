package be.ugent.objprog.ugentopoly.Tiles;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class Tile extends GridPane {
    public final static double LONG_SIDE = ((845.0 / 13) * 2);
    public static final double SHORT_SIDE = ((845.0 / 13));

    public Tile(){
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        // TODO add basic event handler
    }
}
