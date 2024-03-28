package be.ugent.objprog.ugentopoly.GameBoard;
import be.ugent.objprog.ugentopoly.GameBoard.Board;
import be.ugent.objprog.ugentopoly.Tiles.TileCompanions.Tile.Tile;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.InputStream;
import java.util.Objects;

public class MiddleSection extends StackPane {
    private static final double SIZE = (Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES) * 9;

    public  MiddleSection(){

        setPrefSize(SIZE, SIZE);
        setMaxSize(SIZE, SIZE);
        setAlignment(Pos.CENTER); // Center content within the StackPane

        // Load the bottom image
        InputStream bottomImageStream = getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/gent.jpg");
        Image bottomImage = new Image(Objects.requireNonNull(bottomImageStream));
        ImageView bottomImageView = new ImageView(bottomImage);
        bottomImageView.setViewport(new Rectangle2D(0, 0, SIZE, SIZE));

        // TODO extract logo or make cleaner
        // Load the top image
        InputStream topImageStream = getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/logo.png");
        Image topImage = new Image(Objects.requireNonNull(topImageStream));
        ImageView logo = new ImageView(topImage);
        //topImageView.setViewport(new Rectangle2D(0, 0, SIZE, SIZE));

        // Scale down the logo to fit within the bounds
        logo.setPreserveRatio(true);
        logo.setFitWidth(Board.BOARD_SIZE - 2 * Tile.LONG_SIDE);
        logo.setFitHeight(SIZE * 0.15);
        logo.setRotate(45.0);

        getChildren().addAll(bottomImageView, logo);
    }

    public static double getSize(){
        return SIZE;
    }
}
