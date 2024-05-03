package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.tiles.TileImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.GoToJailTileModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.regex.Pattern;

public class GoToJailCornerTileView extends CornerTileView {
    private static final double ROTATION = -45;
    private static final Pattern PATTERN = Pattern.compile("\\n");
    protected static final double SCALAR = 1.7;
    private static final double SIZE = LONG_SIDE - 30;

    public GoToJailCornerTileView(GoToJailTileModel model) {
        super(model);

        // make more versatile. What if they add a string with no newline? it will crash the program
        String[] text = PATTERN.split(model.getName());

        Label textLabel1 = new Label(text[0]);
        Label textLabel2 = new Label(text[1]);

        textLabel1.getStyleClass().add("bold-label-medium");
        textLabel2.getStyleClass().add("bold-label-medium");

        TileImageView image = new TileImageView(model.getImage(), SCALAR, true);

        VBox vBox = new VBox(textLabel1, image, textLabel2);
        vBox.setMaxHeight(SIZE);
        vBox.setMaxWidth(SIZE);
        vBox.setAlignment(Pos.CENTER);
        vBox.setRotate(ROTATION);

        getChildren().addAll(vBox, badgeHolders, tileButton);
    }
}