package be.ugent.objprog.ugentopoly.parsers;

import java.util.Properties;

public class PropertyLoader {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(
                    PropertyLoader.class.getResourceAsStream("/be/ugent/objprog/ugentopoly/ugentopoly.properties"));
        } catch (Exception e) {
            System.err.println("Property file could not be loaded!");
            e.printStackTrace();
        }
    }

    public static String getLabel(String tileId) {
        return properties.getProperty(tileId);
    }

    private static void test() {
        System.out.println(getLabel("tile.street01"));
    }

    public static void main(String[] args) {
        test();
    }
}
