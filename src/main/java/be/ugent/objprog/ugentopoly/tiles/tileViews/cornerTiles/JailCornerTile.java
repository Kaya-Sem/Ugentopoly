package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import be.ugent.objprog.ugentopoly.tiles.tileViews.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class JailCornerTile extends CornerTile {
    private final Image image = new Image("/be/ugent/objprog/ugentopoly/assets/jail.png");

    public JailCornerTile(TileModel model){
        super(model);
        setup();
        this.card = createCard(PropertyLoader.getLabel(model.getId()));
    }

    private BasicVerticalCard createCard(String text) {
        return new BasicVerticalCard(this.image, text
        );
    }

    public void setup() {
        VBox vBox = new VBox();

        Label textLabel = new Label(PropertyLoader.getLabel(model.getId()));
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));

        TileImageView tileImageView= new TileImageView(image, 1.5, true);

        vBox.getChildren().addAll(tileImageView, textLabel);
        vBox.setMaxHeight(Tile.LONG_SIDE - 30);
        vBox.setMaxWidth(Tile.LONG_SIDE - 30);
        vBox.setAlignment(Pos.CENTER);
        // MAKE ROTATION CONSTANT
        vBox.setRotate(135);

        getChildren().addAll(vBox, tileButton);
    }

    @Override
    public void invalidated(Observable observable) {
// NEEDSLOG
    }
}