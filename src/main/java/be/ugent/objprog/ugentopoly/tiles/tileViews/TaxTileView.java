package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.TileHBox;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TaxTileModel;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TaxTileView extends SmallTileView {

    public TaxTileView(TaxTileModel model) {
        super(model);

        TileHBox hBox = new TileHBox();
        String text = PropertyLoader.getLabel(model.getId());
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);

        hBox.getChildren().addAll(new TileImageView(model.getImage()), textLabel);
        getChildren().addAll(hBox, badgeHolders, tileButton);
    }

    public TaxTileModel getModel() {
        return (TaxTileModel) model;
    }
}