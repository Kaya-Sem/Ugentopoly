package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;

public enum PropertyFactory {
    ;

    public static String getString(String id) {
        return PropertyLoader.getLabel(id);
    }
}