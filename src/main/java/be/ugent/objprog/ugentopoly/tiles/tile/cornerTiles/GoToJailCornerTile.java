package be.ugent.objprog.ugentopoly.tiles.tile.cornerTiles;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tile.Tile;
import be.ugent.objprog.ugentopoly.tiles.tile.TileImageView;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GoToJailCornerTile extends CornerTile {
    private static final double ROTATION = -45;
    private final Image image = new Image("/be/ugent/objprog/ugentopoly/assets/go_to_jail.png");

    public GoToJailCornerTile(Record companion, String id) {
        super(companion, id);
        setup(id);
        this.card = createCard(PropertyLoader.getLabel(id));
    }

    private BasicVerticalCard createCard(String text) {
        return new BasicVerticalCard(this.image, text);
    }

    // TODO extract setFont and label to class. (or css?)
    @Override
    protected void setup(String id) {
        VBox vBox = new VBox();

        String[] text = PropertyLoader.getLabel(id).split("\\n");

        Label textLabel1 = new Label(text[0]);
        Label textLabel2 = new Label(text[1]);

        textLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        textLabel2.setFont(Font.font("Arial", FontWeight.BOLD, 10));

        TileImageView image = new TileImageView(this.image, 1.7, true);

        vBox.getChildren().addAll(textLabel1, image, textLabel2);
        vBox.setMaxHeight(Tile.LONG_SIDE - 30);
        vBox.setMaxWidth(Tile.LONG_SIDE - 30);
        vBox.setAlignment(Pos.CENTER);
        vBox.setRotate(ROTATION);

        getChildren().addAll(vBox, tileButton);
    }
}