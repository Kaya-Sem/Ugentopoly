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
        this.model = model;
        this.model.addListener(this);
        setup();
        this.card = new BasicVerticalCard(this.startImage,PropertyLoader.getLabel(model.getId()));
    }

    public void setup() {
        TileImageView arrowImageView = new TileImageView(arrowImage, 1.5, true);
        TileImageView startImageView = new TileImageView(this.startImage, 1.0, true);

        arrowImageView.setTranslateX(-20);
        arrowImageView.setRotate(90);

        setAlignment(arrowImageView, Pos.CENTER_LEFT);

        getChildren().addAll(arrowImageView, startImageView, tileButton);
    }

    @Override
    public void invalidated(Observable observable) {
        // NEEDSLOG
    }

    public TileModel getModel() {
        return model;
    }
}