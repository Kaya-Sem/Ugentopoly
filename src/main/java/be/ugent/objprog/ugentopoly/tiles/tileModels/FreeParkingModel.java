package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileinterface.ImageTile;

import java.util.function.Consumer;

public class FreeParkingModel extends TileModel implements ImageTile {

    private final CustomImage image = new CustomImage("free_parking.png");

    public FreeParkingModel(String tileID, int tilePosition) {
        super(tileID, tilePosition);
        setCard(new BasicVerticalCard(image, name));
    }

    public CustomImage getImage() {
        return image;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return gameModel -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayer();
            int amount = gameModel.getBonusPot();
            gameModel.setBonusPot(0);
            currentPlayer.changeBalance(amount);

            gameModel.addLog(currentPlayer.getName(), (amount == 0) ?
                    "krijgt niets, want de bonuspot is leeg..." : "krijgt " + amount + "€ uit de bonuspot!"
                    );
        };
    }
}