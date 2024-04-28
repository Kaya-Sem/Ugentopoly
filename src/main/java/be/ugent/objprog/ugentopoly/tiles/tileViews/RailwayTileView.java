package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.TileHBox;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileCards.RailwayCard;
import be.ugent.objprog.ugentopoly.tiles.tileModels.RailwayTileModel;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class RailwayTileView extends SmallTileView {


    // Constructor
    public RailwayTileView(RailwayTileModel model){
        super(model);
        setup();
    }

    // OPTIMIZE
    @Override
    protected void setup() {
        RailwayTileModel model = (RailwayTileModel) this.model;
        TileImageView imageView = new TileImageView(model.getImage());

        // HACK use tileName
        String text = model.getTileName();
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);

        TileHBox hBox = new TileHBox(imageView, textLabel);

        getChildren().addAll(hBox, badgeHolders, tileButton);
    }
}