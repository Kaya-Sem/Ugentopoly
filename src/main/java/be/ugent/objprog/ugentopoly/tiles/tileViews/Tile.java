package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.Ugentopoly;
import be.ugent.objprog.ugentopoly.gameBoard.Board;
import be.ugent.objprog.ugentopoly.tiles.tileCards.TemplateCard;
import be.ugent.objprog.ugentopoly.tiles.TileButton;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

public class Tile extends StackPane implements InvalidationListener{
    public final static double LONG_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES) * 2);
    public final static double SHORT_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES));
    private static final double OFFSET = 32.5;

    protected TemplateCard card;
    protected TileButton tileButton = new TileButton();
    protected TileModel model;

    public TileModel getModel(){
        return model;
    }

    public Tile(TileModel model){
        assert (model != null): "given model for tile " + this + " is null";


        tileButton.setOnAction(this::handleButton);
    }

    protected void setup() {}

    public void applyRotation(double angle){
        setTranslateX(getWidth() / 2);
        setTranslateY(getHeight() / 2);
        setRotate(angle);
        if (angle == 90 || angle == 270) {
            setTranslateX(- OFFSET);
            setTranslateY(OFFSET);
        }
    }

    protected void handleButton(ActionEvent event) {
        TileButton source = (TileButton) event.getSource();
        Board.middleSection.updateDisplayedCard((source.isSelected()) ? card : null);
    }

    @Override
    public void invalidated(Observable observable) {

    }
}