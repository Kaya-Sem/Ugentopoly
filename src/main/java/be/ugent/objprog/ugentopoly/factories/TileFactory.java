package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.tiles.tile.*;
import be.ugent.objprog.ugentopoly.tiles.tileCompanions.*;

import java.util.Map;

public class TileFactory {
    // HACK enum klasse of map/lambda
    public <U extends Tile> U forge(Map<String, String> tileData) {
        try {
            return switch (tileData.get("type")) {
                //case "START", "FREE_PARKING", "JAIL", "GO_TO_JAIL" -> (U) createCorner(tileData); // TODO fix
                case "STREET" -> (U) createStreet(tileData);
                case "CHEST" -> (U) createChest(tileData);
                case "TAX" -> (U) createTax(tileData);
                case "RAILWAY" -> (U) createRailway(tileData);
                case "CHANCE" -> (U) createChance(tileData);
                case "UTILITY" -> (U) createUtility(tileData);
                default -> (U) createStreet(tileData);
            };
        } catch (Exception e) {
            System.err.println("tile creation went wrong!");
            e.printStackTrace();
            return null;
        }
    }

    // TODO create an instance of a properties parser so we can give the tiles their proper name etc

    private ChanceTile createChance(Map<String, String> tileData) {
        Record companion = new ChanceCompanion(
                tileData.get("type"),
                tileData.get("position"),
                tileData.get("id")
        );

        return new ChanceTile( companion, tileData.get("id"));
    }

    private UtilityTile createUtility(Map<String, String> tileData) {
        UtilityCompanion companion = new UtilityCompanion(
                tileData.get("type"),
                tileData.get("position"),
                tileData.get("id"),
                tileData.get("cost")
        );

        return new UtilityTile(companion, tileData.get("id"));
    }

    /*private CornerTile createCorner(Map<String, String> tileData) {
        Record companion = new CornerCompanion(
                tileData.get("type"),
                tileData.get("position"),
                tileData.get("id")
        );

        return new CornerTile(companion, tileData.get("id"));
    }*/

    private TaxTile createTax(Map<String, String> tileData) {
        TaxCompanion companion = new TaxCompanion(
                tileData.get("type"),
                tileData.get("position"),
                tileData.get("id"),
                tileData.get("amount")
        );

        return new TaxTile(companion, tileData.get("id"));
    }

    private RailwayTile createRailway(Map<String, String> tileData) {
        RailwayCompanion companion = new RailwayCompanion(
                tileData.get("type"),
                tileData.get("position"),
                tileData.get("id"),
                tileData.get("cost"),
                tileData.get("rent")
        );

        return new RailwayTile(companion, tileData.get("id"));
    }

    private ChestTile createChest(Map<String, String> tileData) {
        Record companion = new ChestCompanion(
                tileData.get("type"),
                tileData.get("position"),
                tileData.get("id")
        );

        return new ChestTile(companion, tileData.get("id"));
    }

    private StreetTile createStreet(Map<String, String> tileData){

        StreetCompanion companion = new StreetCompanion(
                tileData.get("type"),
                tileData.get("position"),
                tileData.get("area"),
                tileData.get("id"),
                tileData.get("cost"),
                tileData.get("rent0"),
                tileData.get("rent1"),
                tileData.get("rent2"),
                tileData.get("rent3"),
                tileData.get("rent4"),
                tileData.get("rent5")
        );

        // TODO fix arguments
        return new StreetTile(companion, tileData.get("id"), null);
    }
}