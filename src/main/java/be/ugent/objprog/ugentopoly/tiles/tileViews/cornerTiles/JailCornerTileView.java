package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.JailTileModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class JailCornerTileView extends CornerTileView {
    protected static final int ROTATIONANGLE = 135;
    protected static final double SCALAR = 1.5;
    private static final double SIZE = LONG_SIDE - 30;

    public JailCornerTileView(JailTileModel model){
        super(model);

        VBox vBox = new VBox();

        Label textLabel = new Label(PropertyLoader.getLabel(getModel().getId()));
        textLabel.getStyleClass().add("bold-label-small");

        TileImageView tileImageView= new TileImageView(model.getImage(), SCALAR, true);

        vBox.getChildren().addAll(tileImageView, textLabel);
        vBox.setMaxHeight(SIZE);
        vBox.setMaxWidth(SIZE);
        vBox.setAlignment(Pos.CENTER);
        vBox.setRotate(ROTATIONANGLE);

        getChildren().addAll(vBox, badgeHolders, tileButton);
    }

}