package be.ugent.objprog.ugentopoly.Factories;

import be.ugent.objprog.ugentopoly.TileObjects.ChanceObject;
import be.ugent.objprog.ugentopoly.TileObjects.ChestObject;
import be.ugent.objprog.ugentopoly.TileObjects.CornerObject;
import be.ugent.objprog.ugentopoly.TileObjects.RailwayObject;
import be.ugent.objprog.ugentopoly.TileObjects.StreetObject;
import be.ugent.objprog.ugentopoly.TileObjects.TaxObject;
import be.ugent.objprog.ugentopoly.TileObjects.UtilityObject;

public class TileObjectFactory implements Factory {

    public TileObjectFactory() {

    }

    public void forge(String[] args) {
        Record object = switch (args[0]) {
            case "START", "FREE_PARKING", "JAIL", "GO_TO_JAIL" -> createCornerObject();
            case "STREET" -> createStreetObject();
            case "CHEST" -> createChestObject();
            case "TAX" -> createTaxObject();
            case "RAILWAY" -> createRailwayObject();
            case "CHANCE" -> createChanceObject();
            case "UTILITY" -> createUtilityObject();
            default -> createStreetObject();
        };
    }

    private ChanceObject createChanceObject() {
        return new ChanceObject("pos", "id");
    }

    private UtilityObject createUtilityObject() {
        return new UtilityObject("pos", "id", "cost");
    }

    private CornerObject createCornerObject() {
        return new CornerObject("d", "I");
    }

    private StreetObject createStreetObject() {
        return new StreetObject(
                "f", "f", "f", "f", "f", "f", "f", "f", "f", "f");
    }

    private TaxObject createTaxObject() {
        return new TaxObject(
                "pos", "id", "amount");
    }

    private RailwayObject createRailwayObject() {
        return new RailwayObject(
                "pos",
                "id",
                "cost",
                "rent");
    }

    private ChestObject createChestObject() {
        return new ChestObject("i", "id");
    }
}
