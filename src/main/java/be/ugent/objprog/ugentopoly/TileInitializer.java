package be.ugent.objprog.ugentopoly;

import java.util.Arrays;
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

    public <T extends TileModel> Map<String, Object[]> TileModelInitializer() {

        Map<String, Map<String, String>> tileData = parser.parseAllTileData();

        tileData.values().stream().map(factory::forge).forEach(tuple -> {
            TileModel model = tuple.tileModel();
            TileView view = tuple.tileView();
            int position = model.getPosition();
            tileModelArray[position] = model;
            tileViewArray[position] = view;
        });

        // HACK return a record with the correct types to minimize casting
        return Map.of(
                "models", tileModelArray,
                "left", reverse(Arrays.copyOfRange(tileViewArray, 1, 10)),
                "top", Arrays.copyOfRange(tileViewArray, 11, 20),
                "right", Arrays.copyOfRange(tileViewArray, 21, 30),
                "bottom", reverse(Arrays.copyOfRange(tileViewArray, 31, 40)),
                "corners", new TileView[] { tileViewArray[0], tileViewArray[10], tileViewArray[20], tileViewArray[30] }
        );
    }

    private static TileView[] reverse(TileView[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            TileView temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}