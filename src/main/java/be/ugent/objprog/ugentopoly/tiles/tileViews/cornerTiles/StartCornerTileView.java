package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.StartTileModel;
import javafx.geometry.Pos;

public class StartCornerTileView extends CornerTileView {

    protected static final double SCALAR = 1.5;
    protected static final int ROTATION = 90;
    protected static final int XTRANSLATE = -20;

    public StartCornerTileView(StartTileModel model) {
        super(model);

        TileImageView arrowImageView = new TileImageView(model.getArrowImage(), SCALAR, true);
        TileImageView startImageView = new TileImageView(model.getImage(), 1.0, true);

        arrowImageView.setTranslateX(XTRANSLATE);
        arrowImageView.setRotate(ROTATION);

        setAlignment(arrowImageView, Pos.CENTER_LEFT);

        getChildren().addAll(arrowImageView, startImageView, badgeHolders, tileButton);
    }

}