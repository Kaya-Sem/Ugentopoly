package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.JailTileModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class JailCornerTileView extends CornerTileView {
    protected static final int ROTATIONANGLE = 135; // TODO extract to connertile?

    public JailCornerTileView(JailTileModel model){
        super(model);

        VBox vBox = new VBox();

        Label textLabel = new Label(PropertyLoader.getLabel(getModel().getId()));
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));

        TileImageView tileImageView= new TileImageView(model.getImage(), 1.5, true);

        vBox.getChildren().addAll(tileImageView, textLabel);
        vBox.setMaxHeight(LONG_SIDE - 30);
        vBox.setMaxWidth(LONG_SIDE - 30);
        vBox.setAlignment(Pos.CENTER);
        vBox.setRotate(ROTATIONANGLE);

        getChildren().addAll(vBox, badgeHolders, tileButton);
    }

}