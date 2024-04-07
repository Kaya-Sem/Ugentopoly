package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.factories.TileModelFactory;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;

import java.util.*;

/**
 * Initializes the tiles for the game.
 * return A list of 40 tiles and a list of 40 tile models, sorted by position
 **/

public class TileInitializer {
    private final TileModel[] tileModelArray;
    private final XMLParser parser;
    private final TileModelFactory factory;

    public TileInitializer() {
        this.tileModelArray = new TileModel[40];
        this.parser = new XMLParser();
        this.factory = new TileModelFactory(parser.areaColors());
    }

    public TileModel[] TileModelInitializer() {

        Map<String, Map<String, String>> tileData = parser.parseTileData();

        for (Map.Entry<String, Map<String, String>> entry : tileData.entrySet()) {
            Map<String, String> tileProperties = entry.getValue();
            TileModel tileModel = factory.forge(tileProperties);
            int position = 0;
            try {
                position = Integer.parseInt(tileProperties.get("position"));
            } catch (NumberFormatException e) {
                System.err.println("Error parsing position as an integer! " + e.getMessage());
            }
            tileModelArray[position] = tileModel;
        }


        // TODO return a map of already divided subparts?
        return tileModelArray;
    }}