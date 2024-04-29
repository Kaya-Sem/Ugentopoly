package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;

public enum TileNameFactory {
    ;

    public static String getTileName(String id) {
        return PropertyLoader.getLabel(id);
    }
}