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

public class ChanceTileView extends SmallTile {
    // TODO can stay in the model
    private static final Image image = new Image(
            Objects.requireNonNull(
                    ChestTileView.class.getResourceAsStream(
                            "/be/ugent/objprog/ugentopoly/assets/chance.png")
            ));

    public ChanceTileView(TileModel model){
        super(model);
        setup();
        card = new BasicVerticalCard(image, PropertyLoader.getLabel(model.getId()));
    }

    // OPTIMIZE
    @Override
    protected void setup() {
        TileHBox hbox = new TileHBox();
        TileImageView imageView = new TileImageView(image);
        String text = PropertyLoader.getLabel(model.getId());
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);
        hbox.getChildren().addAll(imageView, textLabel);
        getChildren().addAll(hbox, tileButton);
    }

}