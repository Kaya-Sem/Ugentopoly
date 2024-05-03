package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class TileHBox extends HBox {
    private static final int SPACING = 10;
    private static final int PADDING = 5;

    public TileHBox(){
        applySettings();
    }

    private void applySettings() {
        setMinHeight(TileView.SHORT_SIDE);
        setMaxHeight(TileView.SHORT_SIDE);
        setMinWidth(TileView.LONG_SIDE);
        setMaxWidth(TileView.LONG_SIDE);

        setPadding(new Insets(PADDING));
        setAlignment(Pos.CENTER);
        setSpacing(SPACING);
    }

    public TileHBox(Node... children) {
        super(children);
        applySettings();
    }
}