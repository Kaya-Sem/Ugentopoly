package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.tileCards.StreetTileModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.RailwayTileModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TaxTileModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.UtilityTileModel;

import java.util.Map;
import java.util.function.Supplier;

public class TileModelFactory {
    private final Map<String, String> areaColors;
    private Map<String, String> data;

    private final Map<String, Object> tileTypes = Map.of(
            "START", createBasicTileModel(),
            "FREE_PARKING", createBasicTileModel(),
            "JAIL", createBasicTileModel(),
            "GO_TO_JAIL", createBasicTileModel(),
            "STREET", createStreetModel(),
            "CHEST", createBasicTileModel(),
            "TAX", createTax(),
            "RAILWAY", createRailway(),
            "CHANCE", createBasicTileModel(),
            "UTILITY", createUtility());

    public TileModelFactory(Map<String, String> areaColors) {
        this.areaColors = areaColors;
    }

    public <T extends TileModel> T forge(Map<String, String> tileData) {
        this.data = tileData;
        Supplier<T> supplier = (Supplier<T>) tileTypes.get(tileData.get("id"));
        return supplier.get();
    }

    private TileModel createBasicTileModel() {
        return new TileModel(data.get("id"), Integer.parseInt(data.get("position")));
    }

    private UtilityTileModel createUtility() {
        return new UtilityTileModel(
                data.get("id"),
                Integer.parseInt(data.get("position")),
                Integer.parseInt(data.get("cost")));
    }

    private TaxTileModel createTax() {
        return new TaxTileModel(
                data.get("id"),
                Integer.parseInt(data.get("position")),
                Integer.parseInt(data.get("amount")));
    }

    private RailwayTileModel createRailway() {
        return new RailwayTileModel(
                data.get("id"),
                Integer.parseInt(data.get("position")),
                Integer.parseInt(data.get("cost")),
                Integer.parseInt(data.get("rent")));
    }

    private StreetTileModel createStreetModel() {
        return new StreetTileModel(
                data.get("id"),
                Integer.parseInt(data.get("position")),
                areaColors.get(data.get("id")),
                data.get("area"),
                data.get("cost"),
                data.get("rent0"),
                data.get("rent1"),
                data.get("rent2"),
                data.get("rent3"),
                data.get("rent4"),
                data.get("rent5"));
    }
}
