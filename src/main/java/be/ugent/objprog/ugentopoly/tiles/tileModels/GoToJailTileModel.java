package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.players.Pion;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import javafx.scene.image.Image;

import java.util.function.Consumer;

public class GoToJailTileModel extends TileModel{

    private final CustomImage image = new CustomImage("go_to_jail.png");

    public GoToJailTileModel(String tileID, int tilePosition, DisplayCardController controller) {
        super(tileID, tilePosition, controller);
        card = new BasicVerticalCard(image, tileName); // HACK
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return gameModel -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            Pion pion = currentPlayer.getPion();
            TileModel[] tileModelList = gameModel.getTileModels();

            tileModelList[pion.getPosition()].removePion(pion);
            tileModelList[10].addPion(pion);

            currentPlayer.setInJail(true);

            gameModel.addLog(currentPlayer.getPlayerName(), "moet een nachtje in de Overpoort spenderen");
        };
    }

    public CustomImage getImage() {
        return image;
    }
}