package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.gamecards.GameCard;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import javafx.scene.image.Image;

import java.util.function.Consumer;

public class ChanceTileModel extends TileModel{
    private final Image image = new CustomImage("chance.png");

    public ChanceTileModel(String tileID, int tilePosition, DisplayCardController controller) {
        super(tileID, tilePosition, controller);
        setCard(new BasicVerticalCard(image, tileName));
    }

    public Image getImage() {
        return image;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return (((gameModel) -> {
            gameModel.addLog(gameModel.getCurrentPlayerMove().getName(), "trekt een kanskaart!");
            GameCard gameCard = (GameCard) gameModel.getChanceCardDeck().getNextCard();
            gameCard.performAction(gameModel);
        }));
    }
}