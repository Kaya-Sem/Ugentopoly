package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import javafx.scene.image.Image;

import java.util.function.Consumer;

public class StartTileModel extends TileModel {
    private final int amount;

    public Image getStartImage() {
        return startImage;
    }

    public Image getArrowImage() {
        return arrowImage;
    }

    private final Image startImage = new CustomImage("start.png");
    private final Image arrowImage = new CustomImage("start-arrow.png");


    public StartTileModel(String id, int position, int amount, DisplayCardController controller) {
        super(id, position, controller);

        card = new BasicVerticalCard(startImage, tileName);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return ((gameModel) -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            currentPlayer.changeBalance(amount);
            gameModel.addLog(currentPlayer.getPlayerName(), "krijgt €" + amount + " zakgeld van zijn ouders"); // TODO add to custom propertie?
        });
    }
}