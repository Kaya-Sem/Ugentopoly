package be.ugent.objprog.ugentopoly.gameboard;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.CustomImageView;
import be.ugent.objprog.ugentopoly.UgentopolyScene;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class MiddleSection extends StackPane implements InvalidationListener {

   private static final Image BACKGROUND = new CustomImage("gent3.jpg");
    private static final Image LOGO = new CustomImage("logo.png");

    protected static final double ROTATION = 45.0;
    protected static final double SCALAR = 0.15;

    private final BoardModel boardModel;
    private final StackPane cardHolder;

    public MiddleSection(BoardModel boardModel) {
        cardHolder = new StackPane();
        this.boardModel = boardModel;
        this.boardModel.addListener(this);

        double size = BoardModel.MIDDLE_AREA_SIZE;
        setMinSize(size, size);
        setMaxSize(size, size);

        CustomImageView background = new CustomImageView(size , UgentopolyScene.BOARD_SIZE, BACKGROUND);
        CustomImageView logo = new CustomImageView(UgentopolyScene.BOARD_SIZE * SCALAR, size, LOGO);

        logo.setRotate(ROTATION);

        getChildren().addAll(background, logo, cardHolder);
    }

    @Override
    public void invalidated(Observable observable) {
        cardHolder.getChildren().clear();
        if (boardModel.getDisplayedCard() != null) {
            cardHolder.getChildren().add(boardModel.getDisplayedCard());
        }
    }
}