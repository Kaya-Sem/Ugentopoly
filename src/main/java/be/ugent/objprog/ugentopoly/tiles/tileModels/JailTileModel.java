package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileinterface.ImageTile;

import java.util.function.Consumer;

public class JailTileModel extends TileModel implements ImageTile {


    private final CustomImage image = new CustomImage("jail.png");

    public JailTileModel(String tileID, int tilePosition) {
        super(tileID, tilePosition);
        setCard(new BasicVerticalCard(image, name));
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return gameModel -> gameModel.addLog(gameModel.getCurrentPlayer().getName(), " zuipt zich ladderzat");
    }

    public CustomImage getImage() {
        return image;
    }
}