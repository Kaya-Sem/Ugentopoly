package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.gameBoard.BoardModel;
import be.ugent.objprog.ugentopoly.tiles.PionHolder;
import be.ugent.objprog.ugentopoly.tiles.TileButton;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

public class TileView extends StackPane implements InvalidationListener{
    public final static double LONG_SIDE = ((BoardModel.BOARD_SIZE / BoardModel.getSmallTilesInBar()) * 2);
    public final static double SHORT_SIDE = ((BoardModel.BOARD_SIZE / BoardModel.getSmallTilesInBar()));
    private static final double OFFSET = 32.5;

    protected final TileButton tileButton = new TileButton();
    protected final TileModel model;
    protected final PionHolder badgeHolders = new PionHolder();

    public TileModel getModel(){
        return model;
    }

    protected TileView(TileModel model){
        this.model = model;
        this.model.addListener(this);
        tileButton.setOnAction(this::handleButton);
    }

    public void applyRotation(int angle){
        setTranslateX(getWidth() / 2);
        setTranslateY(getHeight() / 2);
        setRotate(angle);
        if (angle == BoardModel.TOPANGLE || angle == BoardModel.BOTTOMANGLE) {
            setTranslateX(- OFFSET);
            setTranslateY(OFFSET);
        }
    }

    protected void handleButton(ActionEvent event) {
        TileButton source = (TileButton) event.getSource();
        DisplayCardController controller = model.getController();
        controller.updateDisplayedCard((source.isSelected()) ? model.getCard() : null);
    }

    @Override
    public void invalidated(Observable observable) {
        badgeHolders.getChildren().clear();
        badgeHolders.getChildren().addAll(model.getPionnen());
    }
}