package be.ugent.objprog.ugentopoly.tiles;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import be.ugent.objprog.ugentopoly.factories.TileFactory;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;

/**
 * Initializes the tiles for the game.
 * returns a list of 40 tiles and a list of 40 tileViews models, sorted by
 * position
 **/

public class TileInitializer {
    private final TileModel[] tileModelArray;
    private final TileView[] tileViewArray;
    private final XMLParser parser;
    private final TileFactory factory;

    public TileInitializer(XMLParser parser, TileFactory factory) {
        tileModelArray = new TileModel[40];
        tileViewArray = new TileView[40];

        this.parser = parser;
        this.factory = factory;
    }

    public <T extends TileModel> InitializedTilesObject TileModelInitializer() {

        Map<String, Map<String, String>> tileData = parser.parseAllTileData();

        tileData.values().stream().map(factory::forge).forEach(tuple -> {
            TileModel model = tuple.tileModel();
            TileView view = tuple.tileView();
            int position = model.getPosition();
            tileModelArray[position] = model;
            tileViewArray[position] = view;
        });

        return new InitializedTilesObject(
                tileModelArray,
                reverse(Arrays.copyOfRange(tileViewArray, 1, 10)),
                Arrays.copyOfRange(tileViewArray, 11, 20),
                reverse(Arrays.copyOfRange(tileViewArray, 21, 30)),
                reverse(Arrays.copyOfRange(tileViewArray, 31, 40)),
                new TileView[] { tileViewArray[0], tileViewArray[10], tileViewArray[20], tileViewArray[30]}
        );
    }

    private static TileView[] reverse(TileView[] array) {
        Collections.reverse(Arrays.asList(array));
        return array;
    }
}