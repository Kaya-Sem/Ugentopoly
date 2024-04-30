package be.ugent.objprog.ugentopoly.gameBoard;

import be.ugent.objprog.ugentopoly.CustomObservable;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import be.ugent.objprog.ugentopoly.tiles.tileCards.TemplateCard;
import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;

public class BoardModel extends CustomObservable {
    public static final int TOTALTILES = 40;
    public static final int SMALL_TILES_IN_BAR = 9;
    public static final int SMALL_SLOTS = 13;

    public static final double BOARD_SIZE = 845.0;
    public static final double MIDDLE_AREA_SIZE = 9 * TileView.SHORT_SIDE;

    public static final int TOPANGLE = 90;
    public static final int RIGHTANGLE = 180;
    public static final int BOTTOMANGLE = 270;

    private TemplateCard displayedCard;

    public static int getSmallTilesInBar() {
        return SMALL_TILES_IN_BAR;
    }

    public TemplateCard getDisplayedCard() {
        return displayedCard;
    }

    public void setDisplayedCard(TemplateCard displayedCard) {
        this.displayedCard = displayedCard;
        fireInvalidationEvent();
    }
}