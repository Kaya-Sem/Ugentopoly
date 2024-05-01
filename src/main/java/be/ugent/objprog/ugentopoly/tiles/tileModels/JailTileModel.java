package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;

import java.util.function.Consumer;

public class JailTileModel extends TileModel{


    private final CustomImage image = new CustomImage("jail.png");

    public JailTileModel(String tileID, int tilePosition) {
        super(tileID, tilePosition);
        setCard(new BasicVerticalCard(image, tileName));
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return gameModel -> gameModel.addLog(gameModel.getCurrentPlayerMove().getName(), " zuipt zich ladderzat");
    }

    public CustomImage getImage() {
        return image;
    }
}