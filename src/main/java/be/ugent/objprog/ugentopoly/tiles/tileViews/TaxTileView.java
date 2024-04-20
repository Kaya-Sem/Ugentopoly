package be.ugent.objprog.ugentopoly.tiles.tileViews;

import java.util.Objects;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.TileHBox;
import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileCards.TaxCard;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TaxTileModel;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TaxTileView extends SmallTile {
    private static final Image image = new Image(
            Objects.requireNonNull(
                    ChestTileView.class.getResourceAsStream(
                            "/be/ugent/objprog/ugentopoly/assets/tax.png")));

    // Constructor
    public TaxTileView(TaxTileModel model) {
        super(model);
        setup();
        card = new TaxCard(image, PropertyLoader.getLabel(model.getId()), "200"); // TODO don't hardcode this
    }

    // OPTIMIZE
    protected void setup() {
        TileHBox hBox = new TileHBox();
        String text = PropertyLoader.getLabel(model.getId());
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);

        hBox.getChildren().addAll(new TileImageView(image), textLabel);

        getChildren().addAll(hBox, tileButton, badgeHolders);
    }

    public TaxTileModel getModel() {
        return (TaxTileModel) model;
    }
}