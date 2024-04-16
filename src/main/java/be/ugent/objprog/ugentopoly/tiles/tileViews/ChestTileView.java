package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.TileHBox;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class ChestTileView extends SmallTile {

    private final Image image = new Image(
            Objects.requireNonNull(
                    ChestTileView.class.getResourceAsStream(
                            "/be/ugent/objprog/ugentopoly/assets/chest.png")
            ));

    // Constructor
    public ChestTileView(TileModel model){
        super(model);
        this.model = model;
        this.model.addListener(this);
        setup();
        this.card = new BasicVerticalCard(image, PropertyLoader.getLabel(model.getId()));
    }


    // OPTIMIZE
    protected void setup() {
        TileHBox hBox = new TileHBox();
        TileImageView imageView = new TileImageView(image);
        String text = PropertyLoader.getLabel(model.getId());
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);
        hBox.getChildren().addAll(imageView, textLabel);

        getChildren().addAll(hBox, tileButton);
    }

}