package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import javafx.scene.image.Image;

import java.util.function.Consumer;

public class FreeParkingModel extends TileModel{

    private final Image image = new CustomImage("free_parking.png");

    public FreeParkingModel(String tileID, int tilePosition) {
        super(tileID, tilePosition);
        setCard(new BasicVerticalCard(image, tileName));
    }

    public Image getImage() {
        return image;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return gameModel -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayer();
            int amount = gameModel.getBonusPot();
            gameModel.setBonusPot(0);
            currentPlayer.changeBalance(amount);

            gameModel.addLog(currentPlayer.getName(), (0 == amount) ?
                    "krijgt niets, want de bonuspot is leeg..." : "krijgt " + amount + "€ uit de bonuspot!"
                    );
        };
    }
}