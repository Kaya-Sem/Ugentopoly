package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.Ugentopoly;
import be.ugent.objprog.ugentopoly.gameBoard.Board;
import be.ugent.objprog.ugentopoly.gameBoard.MiddleSection;
import be.ugent.objprog.ugentopoly.tiles.PionHolder;
import be.ugent.objprog.ugentopoly.tiles.tileCards.TemplateCard;
import be.ugent.objprog.ugentopoly.tiles.TileButton;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Tile extends StackPane implements InvalidationListener{
    public final static double LONG_SIDE = ((Ugentopoly.BOARD_SIZE / MiddleSection.SMALL_TILES) * 2);
    public final static double SHORT_SIDE = ((Ugentopoly.BOARD_SIZE / MiddleSection.SMALL_TILES));
    private static final double OFFSET = 32.5;

    protected TemplateCard card;
    protected TileButton tileButton = new TileButton();
    protected final TileModel model;
    protected HBox badgeHolders = new PionHolder(); // HACK new badgeholder

    // TODO make abstract?

    public TileModel getModel(){
        return model;
    }

    public Tile(TileModel model){
        this.model = model;
        this.model.addListener(this);

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

    // HACK use MVC model for this. This is not OK
    protected void handleButton(ActionEvent event) {
        TileButton source = (TileButton) event.getSource();
        Board.middleSection.updateDisplayedCard((source.isSelected()) ? card : null);
    }

    @Override
    public void invalidated(Observable observable) {
        TileModel tileModel = (TileModel) observable;
        badgeHolders.getChildren().clear();
        badgeHolders.getChildren().addAll(getModel().getPionnen());
    }
}