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

    private final CustomImage image = new CustomImage("start.png");
    private final CustomImage arrowImage = new CustomImage("start-arrow.png");

    public StartTileModel(String tileID, int tilePosition, int startAmount) {
        super(tileID, tilePosition);
        this.startAmount = startAmount;
        setCard(new BasicVerticalCard(image, name));
    }

    public int getStartAmount() {
        return startAmount;
    }

    public Image getImage() {return image;}

    public Image getArrowImage() {
        return arrowImage;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return ((gameModel) -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayer();
            boolean landedOnStart = currentPlayer.getPosition() == position;
            int calculatedAmount = (landedOnStart) ? startAmount * 2 : startAmount;

            currentPlayer.changeBalance(calculatedAmount);
            gameModel.addLog(currentPlayer.getName(), landedOnStart ?
                    "land op START en krijgt dus\ndubbel. + " + calculatedAmount + " van zijn ouders!" :
                    "passeert START, en krijgt €" + calculatedAmount + " zakgeld van zijn ouders"
                    );
        });
    }
}