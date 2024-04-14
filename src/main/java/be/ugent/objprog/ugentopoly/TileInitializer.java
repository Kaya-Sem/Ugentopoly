package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.factories.TileFactory;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.tiles.TileTuple;
import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;

import java.util.*;

/**
 * Initializes the tiles for the game.
 * return A list of 40 tiles and a list of 40 tileViews models, sorted by position
 **/

public class TileInitializer {
    private final TileModel[] tileModelArray;
    private final Tile[] tileViewArray;
    private final XMLParser parser;
    private final TileFactory factory;

    public TileInitializer(XMLParser parser, TileFactory factory) {
        this.tileModelArray = new TileModel[40];
        this.tileViewArray = new Tile[40];

        this.parser = parser;
        this.factory = factory;
        // NEEDSLOG
    }

    public Map<String, Object[]> TileModelInitializer() {

        Map<String, Map<String, String>> tileData = parser.parseAllTileData();

        for (Map.Entry<String, Map<String, String>> entry : tileData.entrySet()) {
            TileTuple tuple = factory.forge(entry.getValue());

            TileModel model = tuple.tileModel();
            Tile view = tuple.tileView();

            try {
                int position = model.getPosition();
                tileModelArray[position] = model;
                tileViewArray[position] = view;

            } catch (NumberFormatException e) {
                System.err.println("Error parsing tileModel position as an integer! " + e.getMessage());
            }
        }

        return Map.of(
                "models", tileModelArray,
                "left", Arrays.copyOfRange(tileViewArray, 1, 10),
                "top", Arrays.copyOfRange(tileViewArray, 11, 20),
                "right", Arrays.copyOfRange(tileViewArray, 21, 30),
                "bottom", Arrays.copyOfRange(tileViewArray, 31, 40),
                "corners", new Tile[]{tileViewArray[0], tileViewArray[10], tileViewArray[20], tileViewArray[30]}

        );
    }}