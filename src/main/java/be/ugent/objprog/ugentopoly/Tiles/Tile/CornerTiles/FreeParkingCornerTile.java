package be.ugent.objprog.ugentopoly.Tiles.Tile.CornerTiles;

import be.ugent.objprog.ugentopoly.Parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.TileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.Tiles.Tile.TileImageView;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FreeParkingCornerTile extends CornerTile {
    private final Image image = new Image("/be/ugent/objprog/ugentopoly/assets/free_parking.png");

    public FreeParkingCornerTile(Record companion, String id) {
        super(companion, id);
        setup(id);
        this.card = createCard(PropertyLoader.getLabel(id));
    }

    protected BasicVerticalCard createCard(String text) {
        return new BasicVerticalCard(
                this.image,
                text
        );
    }

    // TODO extract setFont and label to class. (or css?)
    @Override
    protected void setup(String id) {
        VBox vBox = new VBox();
        String[] text = PropertyLoader.getLabel(id).split(" ");
        Label textLabel1 = new Label(text[0]);
        textLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        Label textLabel2 = new Label(text[1]);
        textLabel2.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        TileImageView image = new TileImageView(this.image, 1.5, true);
        vBox.getChildren().addAll(textLabel1, image, textLabel2);
        vBox.setAlignment(Pos.CENTER);
        vBox.setRotate(-135);
        getChildren().addAll(vBox, this.tileButton );
    }
}
