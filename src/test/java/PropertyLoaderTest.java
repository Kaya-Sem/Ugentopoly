
import static org.junit.Assert.*;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;

public class PropertyLoaderTest {

    @Test
    public void testGetLabelForStartTile() {
        assertEquals("Student Kick-off", PropertyLoader.getLabel("tile.start"));
    }

    @Test
    public void testGetLabelForJailTile() {
        assertEquals("De Overpoort", PropertyLoader.getLabel("tile.jail"));
    }

    @Test
    public void testGetLabelForFreeParkingTile() {
        assertEquals("Academisch kwartiertje", PropertyLoader.getLabel("tile.freeparking"));
    }

    @Test
    public void testGetLabelForGoToJailTile() {
        assertEquals("Ga direct naar\nDe Overpoort", PropertyLoader.getLabel("tile.gotojail"));
    }

    @Test
    public void testGetLabelForChanceTile() {
        assertEquals("Kans", PropertyLoader.getLabel("tile.chance"));
    }

    @Test
    public void testGetLabelForChestTile() {
        assertEquals("Algemeen Fonds", PropertyLoader.getLabel("tile.chest"));
    }

    @Test
    public void testGetLabelForFirstTaxTile() {
        assertEquals("GAS-boete wildplassen", PropertyLoader.getLabel("tile.tax1"));
    }

    @Test
    public void testGetLabelForSecondTaxTile() {
        assertEquals("GAS-boete overlast", PropertyLoader.getLabel("tile.tax2"));
    }

    @Test
    public void testGetLabelForFirstRailwayTile() {
        assertEquals("Resto De Brug", PropertyLoader.getLabel("tile.railway1"));
    }

    @Test
    public void testGetLabelForSecondRailwayTile() {
        assertEquals("Resto Campus Sterre", PropertyLoader.getLabel("tile.railway2"));
    }

    @Test
    public void testGetLabelForThirdRailwayTile() {
        assertEquals("Resto Ardoyen", PropertyLoader.getLabel("tile.railway3"));
    }

    @Test
    public void testGetLabelForFourthRailwayTile() {
        assertEquals("Resto Campus Dunant", PropertyLoader.getLabel("tile.railway4"));
    }

    @Test
    public void testGetLabelForFirstUtilityTile() {
        assertEquals("Schamper", PropertyLoader.getLabel("tile.utility1"));
    }

    @Test
    public void testGetLabelForSecondUtilityTile() {
        assertEquals("Urgent.fm", PropertyLoader.getLabel("tile.utility2"));
    }

    @Test
    public void testGetLabelForStreetTile01() {
        assertEquals("S22", PropertyLoader.getLabel("tile.street01"));
    }

    @Test
    public void testGetLabelForChanceCard01() {
        assertEquals("Verlaat De Overpoort zonder te betalen.", PropertyLoader.getLabel("card.chance.01"));
    }

    @Test
    public void testGetLabelForChestCard01() {
        assertEquals("Verlaat De Overpoort zonder te betalen.", PropertyLoader.getLabel("card.chest.01"));
    }


}