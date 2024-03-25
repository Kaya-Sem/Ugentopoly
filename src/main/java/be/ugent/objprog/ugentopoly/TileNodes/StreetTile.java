package be.ugent.objprog.ugentopoly.TileNodes;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class StreetTile extends SmallTile {
    private static final double COLORSTRIP_WIDTH = 33.0;
    private static final double COLORSTRIP_HEIGHT = Tile.SHORT_SIDE;

    private static final Color COLOR = Color.BLACK;
    private static final ImageView image = null;
    protected int rotatie;

    // Constructor
    public StreetTile(
            int rotatie,
            String lotText
    ){
        super(rotatie);

        Rectangle sliver = new Rectangle(5, 0, 10, 20);
        sliver.setFill(Color.RED);
        StackPane stackPane = new StackPane(sliver);
        setText(lotText);
        getStyleClass().add("colored-strip");
    }
}

