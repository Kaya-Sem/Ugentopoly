package be.ugent.objprog.ugentopoly.parsers;

import java.io.IOException;
import java.util.Properties;

public enum PropertyLoader {
    ;
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
}