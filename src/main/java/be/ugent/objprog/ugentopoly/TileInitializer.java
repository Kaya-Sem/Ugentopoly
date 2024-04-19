package be.ugent.objprog.ugentopoly;

import java.util.Arrays;
import java.util.Map;

import be.ugent.objprog.ugentopoly.factories.TileFactory;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;

/**
 * Initializes the tiles for the game.
 * returns a list of 40 tiles and a list of 40 tileViews models, sorted by
 * position
 **/

public class TileInitializer {
    private final TileModel[] tileModelArray;
    private final Tile[] tileViewArray;
    private final XMLParser parser;
    private final TileFactory factory;

    public TileInitializer(XMLParser parser, TileFactory factory) {
        tileModelArray = new TileModel[40];
        tileViewArray = new Tile[40];

        this.parser = parser;
        this.factory = factory;
    }

    public <T extends TileModel> Map<String, Object[]> TileModelInitializer() {

        Map<String, Map<String, String>> tileData = parser.parseAllTileData();

        tileData.values().stream().map(factory::forge).forEach(tuple -> {
            TileModel model = tuple.tileModel();
            Tile view = tuple.tileView();
            int position = model.getPosition();
            tileModelArray[position] = model;
            tileViewArray[position] = view;
        });

        return Map.of(
                "models", tileModelArray,
                "left", Arrays.copyOfRange(tileViewArray, 1, 10),
                "top", Arrays.copyOfRange(tileViewArray, 11, 20),
                "right", Arrays.copyOfRange(tileViewArray, 21, 30),
                "bottom", Arrays.copyOfRange(tileViewArray, 31, 40),
                "corners", new Tile[] { tileViewArray[0], tileViewArray[10], tileViewArray[20], tileViewArray[30] }

        );
    }
}