package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.tiles.TileTuple;
import be.ugent.objprog.ugentopoly.tiles.tileModels.*;
import be.ugent.objprog.ugentopoly.tiles.tileViews.*;
import be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles.*;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

// Can be split into subfactories to make everything cleaner. Would create loads more classes however
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
                "FREE_PARKING", this::createFreeParkingTile,
                "JAIL", this::createJailTile,
                "GO_TO_JAIL", this::createGoToJailTile,
                "STREET", this::createStreetModel,
                "CHEST", this::createChestTile,
                "TAX", this::createTaxTile,
                "RAILWAY", this::createRailway,
                "CHANCE", this::createChanceTile,
                "UTILITY", this::createUtility
        );
    }

    public TileTuple forge(Map<String, String> tileData) {
        String tileType = tileData.get("type");
        Function<Map<String, String>, TileTuple> tileCreator = tileCreationMethods.get(tileType);
        return tileCreator.apply(tileData);
    }

    private TileTuple createChanceTile(Map<String, String> tileData) {
        ChanceTileModel model = new ChanceTileModel(
                tileData.get("id"), Integer.parseInt(tileData.get("position")), controller
        );
        return new TileTuple(model, new ChanceTileView(model));
    }

    private TileTuple createFreeParkingTile(Map<String, String> tileData) {
        FreeParkingModel model = new FreeParkingModel(
                tileData.get("id"), Integer.parseInt(tileData.get("position")), controller
        );
        return new TileTuple(model, new FreeParkingCornerTileView(model));
    }

    private TileTuple createGoToJailTile(Map<String, String> tileData) {
        GoToJailTileModel model = new GoToJailTileModel(
                tileData.get("id"), Integer.parseInt(tileData.get("position")), controller
        );
        return new TileTuple(model, new GoToJailCornerTileView(model));
    }

    private TileTuple createJailTile(Map<String, String> tileData) {
        JailTileModel model = new JailTileModel(
                tileData.get("id"), Integer.parseInt(tileData.get("position")), controller
        );
        return new TileTuple(model, new JailCornerTileView(model));
    }

    private TileTuple createChestTile(Map<String, String> tileData) {
        ChestTileModel model = new ChestTileModel(
                tileData.get("id"), Integer.parseInt(tileData.get("position")), controller
        );
        return new TileTuple(model, new ChestTileView(model));
    }

    private TileTuple createUtility(Map<String, String> tileData) {
        UtilityTileModel model = new UtilityTileModel(
                tileData.get("id"),
                Integer.parseInt(tileData.get("position")),
                Integer.parseInt(tileData.get("cost")), controller
        );
        return new TileTuple(model, new UtilityTileView(model));
    }

    private TileTuple createTaxTile(Map<String, String> tileData) {
        TaxTileModel model = new TaxTileModel(
                tileData.get("id"),
                Integer.parseInt(tileData.get("position")),
                Integer.parseInt(tileData.get("amount")), controller
        );
        return new TileTuple(model, new TaxTileView(model));
    }

    private TileTuple createStartTile(Map<String, String> tileData) {
        StartTileModel model = new StartTileModel(
                tileData.get("id"),
                Integer.parseInt(tileData.get("position")),
                startAmount, controller
        );
        return new TileTuple(model, new StartCornerTileView(model));
    }

    private TileTuple createRailway(Map<String, String> tileData) {
        RailwayTileModel model = new RailwayTileModel(
                tileData.get("id"),
                Integer.parseInt(tileData.get("position")),
                Integer.parseInt(tileData.get("cost")),
                Integer.parseInt(tileData.get("rent")),
                controller
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
                tileData.get("rent0"),
                controller
        );
        return new TileTuple(model, new StreetTileView(model));
    }
}