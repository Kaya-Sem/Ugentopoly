package be.ugent.objprog.ugentopoly.gameBoard;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.CustomImageView;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MiddleSection extends StackPane implements InvalidationListener {

   private static final Image BACKGROUND = new CustomImage("gent3.jpg");
    private static final Image LOGO = new CustomImage("logo.png");

    protected static final double ROTATION = 45.0;
    protected static final double SCALAR = 0.15;

    private final BoardModel boardModel;
    private final StackPane cardHolder;

    public MiddleSection(BoardModel boardModel) {
        this.boardModel = boardModel;
        this.boardModel.addListener(this);

        double size = BoardModel.MIDDLE_AREA_SIZE;
        setMinSize(size, size);
        setMaxSize(size, size);

        cardHolder = new StackPane();

        CustomImageView background = new CustomImageView(size , boardModel.BOARD_SIZE, BACKGROUND);
        CustomImageView logo = new CustomImageView(BoardModel.BOARD_SIZE * SCALAR, size, LOGO);

        logo.setRotate(ROTATION);

        getChildren().addAll(background, logo, cardHolder);
    }

    @Override
    public void invalidated(Observable observable) {
        cardHolder.getChildren().clear();
        if (null != boardModel.getDisplayedCard()) {
            cardHolder.getChildren().add(boardModel.getDisplayedCard());
        }
    }
}