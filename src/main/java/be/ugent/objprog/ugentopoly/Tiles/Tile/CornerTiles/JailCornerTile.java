package be.ugent.objprog.ugentopoly.Tiles.Tile.CornerTiles;

import be.ugent.objprog.ugentopoly.Parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.TileButton;
import be.ugent.objprog.ugentopoly.Tiles.Tile.TileImageView;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class JailCornerTile extends CornerTile {

    public JailCornerTile(Record companion, String id){
        super(companion, id);
        setup(id);
    }

    public void setup(String id) {
        VBox vBox = new VBox();

        Label textLabel = new Label(PropertyLoader.getLabel(id));
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));

        TileImageView tileImageView= new TileImageView(new Image(CornerTile.IMAGES.get(id)), 1.5, true);

        vBox.getChildren().addAll(tileImageView, textLabel);
        vBox.setAlignment(Pos.CENTER);
        vBox.setRotate(135);

        getChildren().addAll(vBox, tileButton);

    }
}
