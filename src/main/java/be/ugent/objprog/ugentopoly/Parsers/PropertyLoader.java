package be.ugent.objprog.ugentopoly.Parsers;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(
                    PropertyLoader.class.getResourceAsStream("/be/ugent/objprog/ugentopoly/ugentopoly.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTileText(String tileName) {
        return properties.getProperty(tileName);
    }

    private static void test() {
        System.out.println(getTileText("tile.street01"));

    }

    public static void main(String[] args) {
        test();
    }
}
