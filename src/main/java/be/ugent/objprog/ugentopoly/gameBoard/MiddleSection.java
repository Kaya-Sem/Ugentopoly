package be.ugent.objprog.ugentopoly.gameBoard;

import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MiddleSection extends StackPane {
    static final double SIZE = (Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES) * 9;

    private static final Image BACKGROUND = new Image(
            MiddleSection.class
                    .getResourceAsStream("/be/ugent/objprog/ugentopoly/gent3.jpg"));
    private static final Image LOGO = new Image(
            MiddleSection.class.getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/logo.png"));

    private final StackPane displayedCard;

    public MiddleSection() {
        setMinSize(SIZE, SIZE);
        setMaxSize(SIZE, SIZE);

        this.displayedCard = new StackPane();

        ImageView background = new ImageView(BACKGROUND);
        ImageView logo = new ImageView(LOGO);
        background.setFitHeight(SIZE);
        background.setFitWidth(SIZE);
        background.setPreserveRatio(true);

        logo.setPreserveRatio(true);
        logo.setFitWidth(Board.BOARD_SIZE);
        logo.setFitHeight(SIZE * 0.15);
        logo.setRotate(45.0);

        getChildren().addAll(background, logo, displayedCard);
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
