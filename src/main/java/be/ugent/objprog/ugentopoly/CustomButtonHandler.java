package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.tileCards.TemplateCard;
import be.ugent.objprog.ugentopoly.gameBoard.MiddleSection;

public class CustomButtonHandler {
    public static MiddleSection middleSection = null;

    public static void updateDisplayedCard(TemplateCard card) {
        middleSection.updateDisplayedCard(card);
    }
}