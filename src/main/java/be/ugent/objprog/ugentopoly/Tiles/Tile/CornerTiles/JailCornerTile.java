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

public class JailCornerTile extends CornerTile {
    private final Image image = new Image("/be/ugent/objprog/ugentopoly/assets/jail.png");

    public JailCornerTile(Record companion, String id){
        super(companion, id);
        setup(id);
        this.card = createCard(PropertyLoader.getLabel(id));
    }

    private BasicVerticalCard createCard(String text) {
        return new BasicVerticalCard(this.image, text
        );
    }

    public void setup(String id) {
        VBox vBox = new VBox();

        Label textLabel = new Label(PropertyLoader.getLabel(id));
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));

        TileImageView tileImageView= new TileImageView(image, 1.5, true);

        vBox.getChildren().addAll(tileImageView, textLabel);
        vBox.setAlignment(Pos.CENTER);
        vBox.setRotate(135);

        getChildren().addAll(vBox, tileButton);
    }
}
