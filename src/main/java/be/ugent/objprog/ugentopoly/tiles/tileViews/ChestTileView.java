package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.factories.PropertyFactory;
import be.ugent.objprog.ugentopoly.tiles.TileHBox;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.ChestTileModel;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ChestTileView extends SmallTileView {

    public ChestTileView(ChestTileModel model){
        super(model);

        TileImageView imageView = new TileImageView(model.getImage());
        String text = PropertyFactory.getString(getModel().getId());
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);

        TileHBox hBox = new TileHBox(imageView, textLabel);

        getChildren().addAll(hBox, badgeHolders, tileButton);
    }

}