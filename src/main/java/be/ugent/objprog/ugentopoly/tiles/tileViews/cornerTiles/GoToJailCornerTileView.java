package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.GoToJailTileModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GoToJailCornerTileView extends CornerTileView {
    private static final double ROTATION = -45;

    public GoToJailCornerTileView(TileModel model) {
        super(model);
        setup();
    }

    // TODO extract setFont and label to class. (or css?)
    @Override
    protected void setup() {
        GoToJailTileModel model = (GoToJailTileModel) this.model;
        VBox vBox = new VBox();

        // make more versatile. What if they add a string with no newline? it will crash the program
        String[] text = PropertyLoader.getLabel(getModel().getId()).split("\\n");

        Label textLabel1 = new Label(text[0]);
        Label textLabel2 = new Label(text[1]);

        textLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel2.setFont(Font.font("Arial", FontWeight.BOLD, 10));

        TileImageView image = new TileImageView(model.getImage(), 1.7, true);

        vBox.getChildren().addAll(textLabel1, image, textLabel2);
        vBox.setMaxHeight(LONG_SIDE - 30);
        vBox.setMaxWidth(LONG_SIDE - 30);
        vBox.setAlignment(Pos.CENTER);
        vBox.setRotate(ROTATION);

        getChildren().addAll(vBox, badgeHolders, tileButton);
    }

}