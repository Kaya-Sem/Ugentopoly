package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.TileHBox;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileModels.ChanceTileModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class ChanceTileView extends SmallTileView {

    public ChanceTileView(ChanceTileModel model){
        super(model);
        setup();
    }

    // OPTIMIZE
    @Override
    protected void setup() {
        ChanceTileModel model = (ChanceTileModel) this.model; // HACK
        TileImageView imageView = new TileImageView(model.getImage());
        String text = model.getTileName();
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);

        TileHBox hbox = new TileHBox(imageView, textLabel);
        getChildren().addAll(hbox, badgeHolders, tileButton);
    }

}