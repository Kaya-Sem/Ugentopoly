package be.ugent.objprog.ugentopoly.tiles.tile;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tileCards.RailwayCard;
import be.ugent.objprog.ugentopoly.tiles.tileCompanions.RailwayCompanion;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class RailwayTile extends SmallTile {
    private static final Image image = new Image(Objects.requireNonNull(SmallTile.class.getResourceAsStream(
            "/be/ugent/objprog/ugentopoly/assets/railway.png"))
            );

    private String cost;
    private String rent;

    // Constructor
    public RailwayTile(RailwayCompanion companion, String id){
        super(companion, id);
        setup(id);
        this.cost = companion.cost();
        this.rent = companion.rent();
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

    private RailwayCard createCard(String text) {
        return new RailwayCard(RailwayTile.image, text, cost, rent) {
        };
    }
}