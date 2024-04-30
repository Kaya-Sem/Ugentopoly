package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import javafx.scene.image.Image;

import java.util.function.Consumer;

public class StartTileModel extends TileModel {
    private final int startAmount;

    private final Image startImage = new CustomImage("start.png");
    private final Image arrowImage = new CustomImage("start-arrow.png");

    public StartTileModel(String tileID, int tilePosition, int startAmount, DisplayCardController controller) {
        super(tileID, tilePosition, controller);
        setCard(new BasicVerticalCard(startImage, tileName));
        this.startAmount = startAmount;
    }

    public int getStartAmount() {
        return startAmount;
    }

    public Image getStartImage() {
        return startImage;
    }
    public Image getArrowImage() {
        return arrowImage;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return ((gameModel) -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            currentPlayer.changeBalance(startAmount);
            gameModel.addLog(currentPlayer.getName(), "krijgt €" + startAmount + " zakgeld van zijn ouders"); // TODO add to custom propertie?
        });
    }
}