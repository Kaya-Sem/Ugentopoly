package be.ugent.objprog.ugentopoly.gameBoard;

import java.util.Objects;

import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MiddleSection extends StackPane {
    static final double SIZE = (Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES) * 9;

    private static final Image BACKGROUND = new Image(
            Objects.requireNonNull(MiddleSection.class
                    .getResourceAsStream("/be/ugent/objprog/ugentopoly/gent3.jpg")));
    private static final Image LOGO = new Image(
            Objects.requireNonNull(MiddleSection.class
                    .getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/logo.png")));

    private final StackPane displayedCard;

    public MiddleSection() {
        setMinSize(SIZE, SIZE);
        setMaxSize(SIZE, SIZE);

        this.displayedCard = new StackPane();

        ImageView bottomImageView = new ImageView(BACKGROUND);
        ImageView logo = new ImageView(LOGO);

        bottomImageView.setViewport(new Rectangle2D(0, 0, SIZE, SIZE));

        logo.setPreserveRatio(true);
        logo.setFitWidth(Board.BOARD_SIZE);
        logo.setFitHeight(SIZE * 0.15);
        logo.setRotate(45.0);

        getChildren().addAll(bottomImageView, logo, displayedCard);
    }

    public void updateDisplayedCard(StackPane card) {
        displayedCard.getChildren().clear();
        if (card != null) {
            displayedCard.getChildren().addAll(card);
        }
    }

    public static double getSize() {
        return SIZE;
    }
}