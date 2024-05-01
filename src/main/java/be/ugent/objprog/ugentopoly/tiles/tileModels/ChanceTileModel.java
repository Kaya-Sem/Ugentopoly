package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.gamecards.GameCard;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import javafx.scene.image.Image;

import java.util.function.Consumer;

public class ChanceTileModel extends TileModel{
    private final Image image = new CustomImage("chance.png");

    public ChanceTileModel(String tileID, int tilePosition) {
        super(tileID, tilePosition);
        setCard(new BasicVerticalCard(image, tileName));
    }

    public Image getImage() {
        return image;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return (((gameModel) -> {
            gameModel.addLog(gameModel.getCurrentPlayer().getName(), "trekt een kanskaart!");
            GameCard gameCard = (GameCard) gameModel.getChanceCardDeck().getNextCard();
            gameCard.performAction(gameModel);
        }));
    }
}