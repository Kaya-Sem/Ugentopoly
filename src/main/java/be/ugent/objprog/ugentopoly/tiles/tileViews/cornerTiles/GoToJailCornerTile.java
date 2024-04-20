package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GoToJailCornerTile extends CornerTile {
    private static final double ROTATION = -45;
    private final Image image = new Image("/be/ugent/objprog/ugentopoly/assets/go_to_jail.png");

    public GoToJailCornerTile(TileModel model) {
        super(model);
        setup();
        this.card = new BasicVerticalCard(this.image, PropertyLoader.getLabel(model.getId()));
    }

    // TODO extract setFont and label to class. (or css?)
    @Override
    protected void setup() {
        VBox vBox = new VBox();

        // make more versatile. What if they add a string with no newline? it will crash the program
        String[] text = PropertyLoader.getLabel(model.getId()).split("\\n");

        Label textLabel1 = new Label(text[0]);
        Label textLabel2 = new Label(text[1]);

        textLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel2.setFont(Font.font("Arial", FontWeight.BOLD, 10));

        TileImageView image = new TileImageView(this.image, 1.7, true);

        vBox.getChildren().addAll(textLabel1, image, textLabel2);
        vBox.setMaxHeight(LONG_SIDE - 30);
        vBox.setMaxWidth(LONG_SIDE - 30);
        vBox.setAlignment(Pos.CENTER);
        vBox.setRotate(ROTATION);

        getChildren().addAll(vBox, badgeHolders, tileButton);
    }

}