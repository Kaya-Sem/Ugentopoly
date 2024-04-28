package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.gameBoard.BoardModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.TemplateCard;

public class DisplayCardController {
    private BoardModel boardModel;

    public DisplayCardController(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

    public void updateDisplayedCard(TemplateCard card) {
        boardModel.setDisplayedCard(card);
    }
}