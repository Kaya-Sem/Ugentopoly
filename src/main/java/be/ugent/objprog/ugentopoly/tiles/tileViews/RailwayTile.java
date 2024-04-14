package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.tileCards.RailwayCard;
import be.ugent.objprog.ugentopoly.tiles.tileModels.RailwayTileModel;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class RailwayTile extends SmallTile {
    private static final Image image = new Image(Objects.requireNonNull(SmallTile.class.getResourceAsStream(
            "/be/ugent/objprog/ugentopoly/assets/railway.png"))
            );

    // Constructor
    public RailwayTile(RailwayTileModel model){
        super(model);
        this.card = new RailwayCard(
                image,
                PropertyLoader.getLabel(model.getId()),
                String.valueOf(model.getCost()),
                String.valueOf(model.getRent()));
        setup();
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