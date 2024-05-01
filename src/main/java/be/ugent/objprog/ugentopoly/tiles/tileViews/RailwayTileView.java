package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.tiles.TileHBox;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.RailwayTileModel;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RailwayTileView extends SmallTileView {

    public RailwayTileView(RailwayTileModel model){
        super(model);

        TileImageView imageView = new TileImageView(model.getImage());

        Label textLabel = new Label(model.getTileName());
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);

        TileHBox hBox = new TileHBox(imageView, textLabel);

        getChildren().addAll(hBox, badgeHolders, tileButton);
    }

}