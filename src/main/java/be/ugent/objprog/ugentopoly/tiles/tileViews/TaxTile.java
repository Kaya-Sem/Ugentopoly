package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.tileCards.TaxCard;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TaxTileModel;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class TaxTile extends SmallTile {
    private static final Image image = new Image(
            Objects.requireNonNull(
                    ChestTile.class.getResourceAsStream(
                            "/be/ugent/objprog/ugentopoly/assets/tax.png")
            ));

    // Constructor
    public TaxTile(TaxTileModel model){
        super(model);
        setup();
        this.card = createCard(PropertyLoader.getLabel(model.getId()));
    }

    // OPTIMIZE
    protected void setup() {
        TileHBox hBox = new TileHBox(); // TODO update constructor to take children?

        TileImageView imageView = new TileImageView(image);

        String text = PropertyLoader.getLabel(model.getId());
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);

        hBox.getChildren().addAll(imageView, textLabel);

        getChildren().addAll(hBox, tileButton);
    }

    private TaxCard createCard(String text) {
        return new TaxCard(image, text, "200");
    }

}