package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.FreeParkingModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FreeParkingCornerTileView extends CornerTileView {

    protected static final int VALUE = -135; // TODO extract to parent class

    public FreeParkingCornerTileView(FreeParkingModel model) {
        super(model);

        // TODO
        TileImageView image = new TileImageView(model.getImage(), 1.7, true);

        String[] text = PropertyLoader.getLabel(getModel().getId()).split(" ");
        Label textLabel1 = new Label(text[0]);
        Label textLabel2 = new Label(text[1]);

        textLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel2.setFont(Font.font("Arial", FontWeight.BOLD, 10));

        VBox vBox = new VBox(textLabel1, image, textLabel2);
        vBox.setMaxWidth(LONG_SIDE - 30);
        vBox.setMaxHeight(LONG_SIDE - 30);
        vBox.setAlignment(Pos.CENTER);
        vBox.setRotate(VALUE);

        getChildren().addAll(vBox, badgeHolders, tileButton);
    }

}