package be.ugent.objprog.ugentopoly.gameboard;

import be.ugent.objprog.ugentopoly.CustomObservable;
import be.ugent.objprog.ugentopoly.tiles.tileCards.TemplateCard;
import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;

public class BoardModel extends CustomObservable {

    public static final double MIDDLE_AREA_SIZE = 9 * TileView.SHORT_SIDE;

    public static final int TOPANGLE = 90;
    public static final int BOTTOMANGLE = 270;

    private TemplateCard displayedCard = null;

    public TemplateCard getDisplayedCard() {
        return displayedCard;
    }

    public void setDisplayedCard(TemplateCard displayedCard) {
        this.displayedCard = displayedCard;
        fireInvalidationEvent();
    }
}