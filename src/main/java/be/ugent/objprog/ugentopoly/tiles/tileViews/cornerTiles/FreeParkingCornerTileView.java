package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.FreeParkingModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FreeParkingCornerTileView extends CornerTileView {

    protected static final int VALUE = -135;
    protected static final double SCALAR = 1.7;
    private static final double SIZE = LONG_SIDE - 30;

    public FreeParkingCornerTileView(FreeParkingModel model) {
        super(model);

        TileImageView image = new TileImageView(model.getImage(), SCALAR, true);

        String[] text = PropertyLoader.getLabel(getModel().getId()).split(" ");
        Label textLabel1 = new Label(text[0]);
        Label textLabel2 = new Label(text[1]);

        textLabel1.getStyleClass().add("bold-label-small");
        textLabel2.getStyleClass().add("bold-label-small");

        VBox vBox = new VBox(textLabel1, image, textLabel2);
        vBox.setMaxWidth(SIZE);
        vBox.setMaxHeight(SIZE);
        vBox.setAlignment(Pos.CENTER);
        vBox.setRotate(VALUE);

        getChildren().addAll(vBox, badgeHolders, tileButton);
    }

}