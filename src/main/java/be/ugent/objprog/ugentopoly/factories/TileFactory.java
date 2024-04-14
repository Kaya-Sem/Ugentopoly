package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.tiles.TileTuple;
import be.ugent.objprog.ugentopoly.tiles.tileModels.StreetTileModel;
import be.ugent.objprog.ugentopoly.tiles.tileViews.*;
import be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles.FreeParkingCornerTile;
import be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles.GoToJailCornerTile;
import be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles.JailCornerTile;
import be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles.StartCornerTile;
import be.ugent.objprog.ugentopoly.tiles.tileModels.RailwayTileModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TaxTileModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.UtilityTileModel;

import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/*
NON-URGENT add documentation
*/

// TODO split into subfactories?
public class TileFactory {
    private final Map<String, String> areaColors;
    protected Map<String, String> data;

    private final Map<String, Supplier<TileTuple>> tileMethods = Map.of(
            "START", this::createBasicTileModel,
            "FREE_PARKING", this::createBasicTileModel,
            "JAIL", this::createBasicTileModel,
            "GO_TO_JAIL", this::createBasicTileModel,
            "STREET", this::createStreetModel,
            "CHEST", this::createBasicTileModel,
            "TAX", this::createTax,
            "RAILWAY", this::createRailway,
            "CHANCE", this::createBasicTileModel,
            "UTILITY", this::createUtility);


    public TileFactory(Map<String, String> areaColors) {
        this.areaColors = Objects.requireNonNull(areaColors);
        // NEEDSLOG
    }

    public TileTuple forge(Map<String, String> tileData) {
        data = tileData;
        return tileMethods.get(data.get("type")).get();
    }

    public TileTuple createBasicTileModel() {

        // HACK
        TileModel model = new TileModel(this.data.get("id"), Integer.parseInt(this.data.get("position")));
        Tile view = switch (this.data.get("type")) {
            case "START" -> new StartCornerTile(model);
            case "JAIL" -> new JailCornerTile(model);
            case "GO_TO_JAIL" -> new GoToJailCornerTile(model);
            case "FREE_PARKING" -> new FreeParkingCornerTile(model);
            case "CHEST" -> new ChestTile(model);
            case "CHANCE" -> new ChanceTile(model);
            default -> throw new IllegalStateException("Unexpected type: " + this.data.get("type"));
        };

        return new TileTuple(model, view);
    }

    private TileTuple createUtility() {
       UtilityTileModel model = new UtilityTileModel(
                data.get("id"),
                Integer.parseInt(data.get("position")),
                Integer.parseInt(data.get("cost")));

        UtilityTile view = new UtilityTile(model);
        return new TileTuple(model, view);
    }

    private TileTuple createTax() {
        TaxTileModel model = new TaxTileModel(
                data.get("id"),
                Integer.parseInt(data.get("position")),
                Integer.parseInt(data.get("amount")));

        TaxTile view = new TaxTile(model);

        return new TileTuple(model, view);
    }

    private TileTuple createRailway() {
        RailwayTileModel model = new RailwayTileModel(
                data.get("id"),
                Integer.parseInt(data.get("position")),
                Integer.parseInt(data.get("cost")),
                Integer.parseInt(data.get("rent")));

        RailwayTile view = new RailwayTile(model);

        return new TileTuple(model, view);
    }

    private TileTuple createStreetModel() {
        StreetTileModel model = new StreetTileModel(
                data.get("id"),
                Integer.parseInt(data.get("position")),
                areaColors.get(data.get("area")),
                data.get("area"),
                data.get("cost"),
                data.get("rent0"),
                data.get("rent1"),
                data.get("rent2"),
                data.get("rent3"),
                data.get("rent4"),
                data.get("rent5"));

        StreetTileView view = new StreetTileView(model);

        return new TileTuple(model, view);
    }
}