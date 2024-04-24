
import static org.junit.Assert.*;

import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;

public class XMLParserTest {

    protected static final int TILES = 40;
    protected static final int STARTAMOUNT = 200;
    private XMLParser parser;

    @Before
    public void setUp() {
        parser = new XMLParser();
    }

    @Test
    public void testGetChanceCardsSize() {
        Map<String, Map<String, String>> chanceCards = parser.getChanceCards();
        assertNotNull("Chance cards should not be null", chanceCards);
        assertFalse("Chance cards list should not be empty", chanceCards.isEmpty());
        assertEquals("Number of chance cards should match expected", 8, chanceCards.size());
    }

    @Test
    public void testGetChestCardsSize() {
        Map<String, Map<String, String>> chestCards = parser.getChestCards();
        assertNotNull("Chest cards should not be null", chestCards);
        assertFalse("Chest cards list should not be empty", chestCards.isEmpty());
        assertEquals("Number of chest cards should match expected", 7, chestCards.size());
    }

    @Test
    public void testParseAllTileDataSize() {
        Map<String, Map<String, String>> tiles = parser.parseAllTileData();
        assertNotNull("Tiles data should not be null", tiles);
        assertFalse("Tiles data should not be empty", tiles.isEmpty());
        assertEquals("Number of tiles should match expected", TILES, tiles.size());
    }

    @Test
    public void testGetStartingBalance() {
        String balance = parser.getStartingBalance();
        assertNotNull("Starting balance should not be null", balance);
        assertEquals("Starting balance should match expected", "1500", balance);
    }

    @Test
    public void testGetStartAmount() {
        int startAmount = parser.getStartAmount();
        assertEquals("Start amount should be " + STARTAMOUNT, STARTAMOUNT, startAmount);
    }

    @Test
    public void testChanceCardsContainsSpecificKeys() {
        Map<String, Map<String, String>> chanceCards = parser.getChanceCards();
        assertNotNull("Chance cards should not be null", chanceCards);
        String[] expectedKeys = {
                "card.chance.01", "card.chance.02", "card.chance.03", "card.chance.04",
                "card.chance.05", "card.chance.06", "card.chance.07", "card.chance.08"
        };
        for (String key : expectedKeys) {
            assertTrue("Chance cards map should contain key: " + key, chanceCards.containsKey(key));
        }
    }

    @Test
    public void testChestCardsContainsSpecificKeys() {
        Map<String, Map<String, String>> chestCards = parser.getChestCards();
        assertNotNull("Chest cards should not be null", chestCards);
        String[] expectedKeys = {
                "card.chest.01", "card.chest.02", "card.chest.03", "card.chest.04",
                "card.chest.05", "card.chest.06", "card.chest.07"
        };
        for (String key : expectedKeys) {
            assertTrue("Chest cards map should contain key: " + key, chestCards.containsKey(key));
        }
    }
}