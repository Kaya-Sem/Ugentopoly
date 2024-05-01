package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.tiles.TileHBox;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.ChanceTileModel;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ChanceTileView extends SmallTileView {

    public ChanceTileView(ChanceTileModel model){
        super(model);

        TileImageView imageView = new TileImageView(model.getImage());
        String text = model.getName();
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);

        TileHBox hbox = new TileHBox(imageView, textLabel);
        getChildren().addAll(hbox, badgeHolders, tileButton);
    }

}