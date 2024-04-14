package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class ChestTile extends SmallTile {

    private final Image image = new Image(
            Objects.requireNonNull(
                    ChestTile.class.getResourceAsStream(
                            "/be/ugent/objprog/ugentopoly/assets/chest.png")
            ));

    // Constructor
    public ChestTile(TileModel model){
        super(model);
        setup();
        this.card = createCard(PropertyLoader.getLabel(model.getId()));
    }


    // OPTIMIZE
    protected void setup(String id) {
        TileHBox hBox = new TileHBox();
        TileImageView imageView = new TileImageView(image);
        String text = PropertyLoader.getLabel(id);
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);
        hBox.getChildren().addAll(imageView, textLabel);
        getChildren().addAll(hBox, tileButton);
    }

    private BasicVerticalCard createCard(String text) {
        return new BasicVerticalCard(this.image, text);
    }

    public TileModel getModel() {
        return model;
    }
}