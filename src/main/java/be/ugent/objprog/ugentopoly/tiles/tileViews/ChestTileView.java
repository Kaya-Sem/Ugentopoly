package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.TileHBox;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileModels.ChestTileModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class ChestTileView extends SmallTileView {

    public ChestTileView(TileModel model){
        super(model);
        setup();
    }

    // HACK remove setup and model casting
    protected void setup() {
        ChestTileModel model = (ChestTileModel) this.model;
        TileImageView imageView = new TileImageView(model.getImage());
        String text = PropertyLoader.getLabel(getModel().getId());
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);

        TileHBox hBox = new TileHBox(imageView, textLabel);

        getChildren().addAll(hBox, badgeHolders, tileButton);
    }

}