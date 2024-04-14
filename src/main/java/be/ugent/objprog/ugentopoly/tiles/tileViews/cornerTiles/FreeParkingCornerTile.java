package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FreeParkingCornerTile extends CornerTile {
    private final Image image = new Image("/be/ugent/objprog/ugentopoly/assets/free_parking.png");

    public FreeParkingCornerTile(TileModel model) {
        super(model);
        this.model = model;
        this.model.addListener(this);
        setup();
        this.card = new BasicVerticalCard(this.image, PropertyLoader.getLabel(model.getId()));
    }

    // TODO extract setFont and label to class. (or css?)
    @Override
    protected void setup() {
        TileImageView image = new TileImageView(this.image, 1.7, true);

        String[] text = PropertyLoader.getLabel(model.getId()).split(" ");
        Label textLabel1 = new Label(text[0]);
        Label textLabel2 = new Label(text[1]);

        textLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel2.setFont(Font.font("Arial", FontWeight.BOLD, 10));

        VBox vBox = new VBox(textLabel1, image, textLabel2);
        vBox.setMaxWidth(Tile.LONG_SIDE - 30);
        vBox.setMaxHeight(Tile.LONG_SIDE - 30);
        vBox.setAlignment(Pos.CENTER);
        vBox.setRotate(-135);

        getChildren().addAll(vBox, tileButton );
    }

    @Override
    public void invalidated(Observable observable) {

    }
}