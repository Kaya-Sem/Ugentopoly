package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.TileCards.TemplateCard;
import be.ugent.objprog.ugentopoly.GameBoard.MiddleSection;

public class CustomButtonHandler {
    public static MiddleSection middleSection = null;

    public static void updateDisplayedCard(TemplateCard card) {
        middleSection.updateDisplayedCard(card);
    }
}