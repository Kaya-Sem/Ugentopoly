package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.StartTileModel;
import javafx.geometry.Pos;
import javafx.scene.image.Image;

public class StartCornerTileView extends CornerTileView {

    public StartCornerTileView(StartTileModel model) {
        super(model);

        // TODO
        TileImageView arrowImageView = new TileImageView(model.getArrowImage(), 1.5, true);
        TileImageView startImageView = new TileImageView(model.getStartImage(), 1.0, true);

        arrowImageView.setTranslateX(-20);
        arrowImageView.setRotate(90);

        setAlignment(arrowImageView, Pos.CENTER_LEFT);

        getChildren().addAll(arrowImageView, startImageView, badgeHolders, tileButton);
    }

}