package be.ugent.objprog.ugentopoly.tiles.tile.cornerTiles;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tile.TileImageView;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

public class StartCornerTile extends CornerTile {
    private final Image startImage = new Image("/be/ugent/objprog/ugentopoly/assets/start.png");
    private final Image arrowImage = new Image("/be/ugent/objprog/ugentopoly/assets/start-arrow.png");

    public StartCornerTile(Record companion, String id) {
        super(companion, id);
        setup(id);
        this.card = new BasicVerticalCard(this.startImage,PropertyLoader.getLabel(id));
    }

    public void setup(String id) {


        TileImageView arrowImageView = new TileImageView(arrowImage, 2.0, true);
        TileImageView startImageView = new TileImageView(this.startImage, 1.0, true);

        arrowImageView.setRotate(90);


        setAlignment(arrowImageView, Pos.CENTER_LEFT);

        HBox hBox = new HBox(arrowImageView, startImageView);
        hBox.setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(hBox, tileButton);
    }
}
