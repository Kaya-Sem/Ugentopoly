package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;

public class StartCornerTile extends CornerTile {
    private final Image startImage = new Image("/be/ugent/objprog/ugentopoly/assets/start.png");
    private final Image arrowImage = new Image("/be/ugent/objprog/ugentopoly/assets/start-arrow.png");

    public StartCornerTile(TileModel model) {
        super(model);
        setup();
        card = new BasicVerticalCard(startImage,PropertyLoader.getLabel(model.getId()));
        // HACK cards should be defined in the model, not the view
    }

    public void setup() {
        TileImageView arrowImageView = new TileImageView(arrowImage, 1.5, true);
        TileImageView startImageView = new TileImageView(startImage, 1.0, true);

        arrowImageView.setTranslateX(-20);
        arrowImageView.setRotate(90);

        setAlignment(arrowImageView, Pos.CENTER_LEFT);

        getChildren().addAll(arrowImageView, startImageView, badgeHolders, tileButton);
    }
}