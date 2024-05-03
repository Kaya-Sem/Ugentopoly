package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.tiles.DisplayCardController;
import be.ugent.objprog.ugentopoly.tiles.TileTuple;
import be.ugent.objprog.ugentopoly.tiles.tileModels.*;
import be.ugent.objprog.ugentopoly.tiles.tileViews.*;
import be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles.*;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 *
 */

public class TileFactory {
    private final Map<String, Function<Map<String, String>, TileTuple>> tileCreationMethods;
    private final DisplayCardController controller;
    private final Map<String, String> areaColors;
    private final int startAmount;

    public TileFactory(Map<String, String> areaColors, int startAmount, DisplayCardController controller) {
        this.areaColors = Objects.requireNonNull(areaColors);
        this.startAmount = startAmount;
        this.controller = controller;

        tileCreationMethods = Map.of(
                "START", this::createStartTile,
                "FREE_PARKING", TileFactory::createFreeParkingTile,
                "JAIL", TileFactory::createJailTile,
                "GO_TO_JAIL", TileFactory::createGoToJailTile,
                "STREET", this::createStreetModel,
                "CHEST", TileFactory::createChestTile,
                "TAX", TileFactory::createTaxTile,
                "RAILWAY", TileFactory::createRailway,
                "CHANCE", TileFactory::createChanceTile,
                "UTILITY", TileFactory::createUtility
        );
    }

    public TileTuple forge(Map<String, String> tileData) {
        String tileType = tileData.get("type");
        Function<Map<String, String>, TileTuple> tileCreator = tileCreationMethods.get(tileType);
        TileTuple tileTuple = tileCreator.apply(tileData);
        tileTuple.tileModel().setController(controller);
        return tileTuple;
    }

    private static TileTuple createChanceTile(Map<String, String> tileData) {
        ChanceTileModel model = new ChanceTileModel(
                tileData.get("id"), Integer.parseInt(tileData.get("position"))
        );
        return new TileTuple(model, new ChanceTileView(model));
    }

    private static TileTuple createFreeParkingTile(Map<String, String> tileData) {
        FreeParkingModel model = new FreeParkingModel(
                tileData.get("id"), Integer.parseInt(tileData.get("position"))
        );
        return new TileTuple(model, new FreeParkingCornerTileView(model));
    }

    private static TileTuple createGoToJailTile(Map<String, String> tileData) {
        GoToJailTileModel model = new GoToJailTileModel(
                tileData.get("id"), Integer.parseInt(tileData.get("position"))
        );
        return new TileTuple(model, new GoToJailCornerTileView(model));
    }

    private static TileTuple createJailTile(Map<String, String> tileData) {
        JailTileModel model = new JailTileModel(
                tileData.get("id"), Integer.parseInt(tileData.get("position"))
        );
        return new TileTuple(model, new JailCornerTileView(model));
    }

    private static TileTuple createChestTile(Map<String, String> tileData) {
        ChestTileModel model = new ChestTileModel(
                tileData.get("id"), Integer.parseInt(tileData.get("position"))
        );
        return new TileTuple(model, new ChestTileView(model));
    }

    private static TileTuple createUtility(Map<String, String> tileData) {
        UtilityTileModel model = new UtilityTileModel(
                tileData.get("id"),
                Integer.parseInt(tileData.get("position")),
                Integer.parseInt(tileData.get("cost"))
        );
        return new TileTuple(model, new UtilityTileView(model));
    }

    private static TileTuple createTaxTile(Map<String, String> tileData) {
        TaxTileModel model = new TaxTileModel(
                tileData.get("id"),
                Integer.parseInt(tileData.get("position")),
                Integer.parseInt(tileData.get("amount"))
        );
        return new TileTuple(model, new TaxTileView(model));
    }

    private TileTuple createStartTile(Map<String, String> tileData) {
        StartTileModel model = new StartTileModel(
                tileData.get("id"),
                Integer.parseInt(tileData.get("position")),
                startAmount
        );
        return new TileTuple(model, new StartCornerTileView(model));
    }

    private static TileTuple createRailway(Map<String, String> tileData) {
        RailwayTileModel model = new RailwayTileModel(
                tileData.get("id"),
                Integer.parseInt(tileData.get("position")),
                Integer.parseInt(tileData.get("cost")),
                Integer.parseInt(tileData.get("rent"))
        );
        return new TileTuple(model, new RailwayTileView(model));
    }

    private TileTuple createStreetModel(Map<String, String> tileData) {
        StreetTileModel model = new StreetTileModel(
                tileData.get("id"),
                Integer.parseInt(tileData.get("position")),
                areaColors.get(tileData.get("area")),
                tileData.get("area"),
                Integer.parseInt(tileData.get("cost")),
                tileData.get("rent0")
        );
        return new TileTuple(model, new StreetTileView(model));
    }
}