package be.ugent.objprog.ugentopoly.Tiles.Tile.CornerTiles;

import be.ugent.objprog.ugentopoly.Parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.TileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.Tiles.Tile.TileImageView;
import javafx.geometry.Pos;
import javafx.scene.image.Image;

public class StartCornerTile extends CornerTile {
    private final Image startImage = new Image("/be/ugent/objprog/ugentopoly/assets/start.png");
    private final Image arrowImage = new Image("/be/ugent/objprog/ugentopoly/assets/start-arrow.png");

    public StartCornerTile(Record companion, String id) {
        super(companion, id);
        setup(id);
        this.card = createCard(PropertyLoader.getLabel(id));
    }

    public void setup(String id) {

        TileImageView arrowImageView = new TileImageView(arrowImage, 2.0, true);
        arrowImageView.setRotate(90);
        setAlignment(arrowImageView, Pos.CENTER_LEFT);

        TileImageView startImage = new TileImageView(this.startImage, 1.0, true);
        setAlignment(startImage, Pos.CENTER_RIGHT);

        getChildren().addAll(startImage, arrowImageView, tileButton);
    }

    public BasicVerticalCard createCard(String text) {
        return new BasicVerticalCard(
                this.startImage,
                text
        );
    }
}
