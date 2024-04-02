package be.ugent.objprog.ugentopoly.GameBoard;
import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.InputStream;
import java.util.Objects;

public class MiddleSection extends StackPane {
    private static final double SIZE = (Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES) * 9;

    private final StackPane displayedCard;

    public  MiddleSection(){
        setMinSize(SIZE, SIZE);
        setMaxSize(SIZE, SIZE);

        // Load the bottom image
        Image bottomImage = new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream("/be/ugent/objprog/ugentopoly/gent.jpg")));
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

        // card in the middle
        this.displayedCard = new StackPane();

        getChildren().addAll(bottomImageView, logo, displayedCard);
    }


    // Method to update the placeholder with new content
    public void updateDisplayedCard(StackPane card) {
        displayedCard.getChildren().clear();
        if (card != null) {
            displayedCard.getChildren().addAll(card);
        }
    }

    public static double getSize(){
        return SIZE;
    }
}
