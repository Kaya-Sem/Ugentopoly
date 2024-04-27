package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.GameModel;

import java.util.function.Consumer;

public class JailTileModel extends TileModel{

    public JailTileModel(String id, int position) {
        super(id, position);
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return gameModel -> {
            gameModel.addLog(gameModel.getCurrentPlayerMove().getPlayerName(), "landed on Overpoort, but couldn't stay");
        };
    }

}