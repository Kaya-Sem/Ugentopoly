package be.ugent.objprog.ugentopoly.Tiles;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class LotTile extends SmallTile {
    private static final double COLORSTRIP_WIDTH = 33.0;
    private static final double COLORSTRIP_HEIGHT = Tile.SHORT_SIDE;

    private static final Color COLOR = Color.BLACK;
    private static final ImageView image = null;

    public LotTile(){
        setOnAction(new ButtonHandler());

        Text text = new Text("hello");
        getChildren().addAll(text);


    }
}
