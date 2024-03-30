package be.ugent.objprog.ugentopoly.Parsers;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(
                    PropertyLoader.class.getResourceAsStream("/be/ugent/objprog/ugentopoly/ugentopoly.properties"));
        } catch (IOException e) {
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
