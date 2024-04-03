package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.Parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.TileCards.BasicVerticalCard;
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
    public RailwayTile(Record companion, String id){
        super(companion, id);
        setup(id);
        this.card = createCard(PropertyLoader.getLabel(id));
    }

    // OPTIMIZE
    @Override
    protected void setup(String id) {
        TileHBox hbox = new TileHBox();

        TileImageView imageView = new TileImageView(image);

        String text = PropertyLoader.getLabel(id);
        Label textLabel = new Label(text);
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel.setWrapText(true);

        hbox.getChildren().addAll(imageView, textLabel);

        getChildren().addAll(hbox, tileButton);
    }

    private BasicVerticalCard createCard(String text) {
        return new BasicVerticalCard(RailwayTile.image, text) {
        };
    }
}

