package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileinterface.ImageTile;
import javafx.scene.image.Image;

import java.util.function.Consumer;

public class StartTileModel extends TileModel implements ImageTile {
    private final int startAmount;

    private final CustomImage startImage = new CustomImage("start.png");
    private final CustomImage arrowImage = new CustomImage("start-arrow.png");

    public StartTileModel(String tileID, int tilePosition, int startAmount) {
        super(tileID, tilePosition);
        setCard(new BasicVerticalCard(startImage, name));
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
            PlayerModel currentPlayer = gameModel.getCurrentPlayer();
            currentPlayer.changeBalance(startAmount);
            gameModel.addLog(currentPlayer.getName(), "passeert START, en krijgt €" + startAmount + " zakgeld van zijn ouders");
        });
    }

    @Override
    public CustomImage getImage() {
        return startImage;
    }
}