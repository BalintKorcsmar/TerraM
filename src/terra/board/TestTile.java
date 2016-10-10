package terra.board;

import java.util.Optional;

import org.junit.Test;

import junit.framework.TestCase;
import terra.player.PlayerAccess;
import terra.unit.Building;
import terra.unit.BuildingType;

public class TestTile extends TestCase {

    private static final Board board = Board.getInstance();
    private static final PlayerAccess plAccess = PlayerAccess.getInstance(4);

    @Test
    public void testTile() {
        Optional<Building> building = Optional.empty();
        Tile tile = new Tile(0, 0, TileType.PLAINS);
        assertEquals(tile.getType(), TileType.PLAINS);
        assertEquals(tile.getRow(), 0);
        assertEquals(tile.getColumn(), 0);
        assertEquals(tile.getBuilding(), building);

        tile = new Tile(5, 7, TileType.SWAMP);
        assertEquals(tile.getType(), TileType.SWAMP);
        assertEquals(tile.getRow(), 5);
        assertEquals(tile.getColumn(), 7);
        assertEquals(tile.getBuilding(), building);
    }

    @Test
    public void testTileInvalidParams() {
        Throwable e = null;
        try {
            @SuppressWarnings("unused")
            Tile tile = new Tile(20, 20, TileType.SWAMP);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }

    @Test
    public void testGetRow() {
        Tile tile = new Tile(3, 4, TileType.SWAMP);
        assertEquals(tile.getRow(), 3);
    }

    @Test
    public void testGetColumn() {
        Tile tile = new Tile(3, 4, TileType.SWAMP);
        assertEquals(tile.getColumn(), 4);
    }

    @Test
    public void testSetBuildingDwellingOnEmptyThenNotEmpty() {

        String color = plAccess.getPlayer().getColor();
        Throwable e = null;
        Tile desert = board.getTile(3, 2);

        assertFalse(desert.getBuilding().isPresent());

        try {
            desert.setBuilding(BuildingType.DWELLING, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(desert.getBuilding().isPresent());
        assertEquals(desert.getBuilding().get().getBuildingType(), BuildingType.DWELLING);
        assertEquals(desert.getBuilding().get().getColor(), color);
        assertEquals(e, null);

        try {
            desert.setBuilding(BuildingType.DWELLING, color);
        } catch (Throwable ex) {
            e = ex;
        }
        
        assertTrue(e instanceof TileNotEmptyException);
    }

    public void testSetBuildingDwellingOnRiver() {
        String color = plAccess.getPlayer().getColor();
        Throwable e = null;

        Tile river = board.getTile(3, 9);
        try {
            river.setBuilding(BuildingType.DWELLING, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertFalse(river.getBuilding().isPresent());
        assertTrue(e instanceof InvalidBuildException);
    }

    @Test
    public void testSetBuildingUpgradeStructure() {

        String color = plAccess.getPlayer().getColor();
        Throwable e = null;
        Tile forest = board.getTile(4, 10);
        Tile lakes = board.getTile(4, 12);
        Tile mountains = board.getTile(4, 6);

        assertFalse(forest.getBuilding().isPresent());

        /* Test Positive Case: Building a Dwelling on an empty tile. */
        try {
            forest.setBuilding(BuildingType.DWELLING, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(forest.getBuilding().isPresent());
        assertEquals(forest.getBuilding().get().getBuildingType(), BuildingType.DWELLING);
        assertEquals(forest.getBuilding().get().getColor(), color);
        assertEquals(e, null);

        /* Test Negative Case: upgrade a Dwelling to Temple. */
        try {
            forest.setBuilding(BuildingType.TEMPLE, color);
        } catch (Throwable ex) {
            e = ex;
        }
        
        assertEquals(forest.getBuilding().get().getBuildingType(), BuildingType.DWELLING);
        assertEquals(forest.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidUpgradeException);
        e = null;

        /* Test Negative Case: upgrade a Dwelling to Sanctuary. */
        try {
            forest.setBuilding(BuildingType.SANCTUARY, color);
        } catch (Throwable ex) {
            e = ex;
        }
        
        assertEquals(forest.getBuilding().get().getBuildingType(), BuildingType.DWELLING);
        assertEquals(forest.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidUpgradeException);
        e = null;

        /* Test Negative Case: upgrade a Dwelling to Stronghold. */
        try {
            forest.setBuilding(BuildingType.STRONGHOLD, color);
        } catch (Throwable ex) {
            e = ex;
        }
        
        assertEquals(forest.getBuilding().get().getBuildingType(), BuildingType.DWELLING);
        assertEquals(forest.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidUpgradeException);
        e = null;

        /* Test Positive Case: upgrade a Dwelling to a Trading House. */
        try {
            forest.setBuilding(BuildingType.TRADING_HOUSE, color);
        } catch (Throwable ex) {
            e = ex;
        }
        
        assertEquals(forest.getBuilding().get().getBuildingType(), BuildingType.TRADING_HOUSE);
        assertEquals(forest.getBuilding().get().getColor(), color);
        assertEquals(e, null);

        /* Test Negative Case: upgrade a Trading House to a Sanctuary. */
        try {
            forest.setBuilding(BuildingType.SANCTUARY, color);
        } catch (Throwable ex) {
            e = ex;
        }
        
        assertEquals(forest.getBuilding().get().getBuildingType(), BuildingType.TRADING_HOUSE);
        assertEquals(forest.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidUpgradeException);
        e = null;

        /* Test Negative Case: upgrade a Trading House to a Dwelling. */
        try {
            forest.setBuilding(BuildingType.DWELLING, color);
        } catch (Throwable ex) {
            e = ex;
        }
        
        assertEquals(forest.getBuilding().get().getBuildingType(), BuildingType.TRADING_HOUSE);
        assertEquals(forest.getBuilding().get().getColor(), color);
        assertTrue(e instanceof TileNotEmptyException);
        e = null;

        /* Test Positive Case: upgrade a Trading House to a Stronghold. */
        try {
            forest.setBuilding(BuildingType.STRONGHOLD, color);
        } catch (Throwable ex) {
            e = ex;
        }
        
        assertEquals(forest.getBuilding().get().getBuildingType(), BuildingType.STRONGHOLD);
        assertEquals(forest.getBuilding().get().getColor(), color);
        assertNull(e);

        /* Test Negative Case: upgrade a Stronghold to a Dwelling. */
        try {
            forest.setBuilding(BuildingType.DWELLING, color);
        } catch (Throwable ex) {
            e = ex;
        }
        
        assertEquals(forest.getBuilding().get().getBuildingType(), BuildingType.STRONGHOLD);
        assertEquals(forest.getBuilding().get().getColor(), color);
        assertTrue(e instanceof TileNotEmptyException);
        e = null;

        /* Test Negative Case: upgrade a Stronghold to a Trading House. */
        try {
            forest.setBuilding(BuildingType.TRADING_HOUSE, color);
        } catch (Throwable ex) {
            e = ex;
        }
        
        assertEquals(forest.getBuilding().get().getBuildingType(), BuildingType.STRONGHOLD);
        assertEquals(forest.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidUpgradeException);
        e = null;

        /* Test Negative Case: upgrade a Stronghold to a Temple. */
        try {
            forest.setBuilding(BuildingType.TEMPLE, color);
        } catch (Throwable ex) {
            e = ex;
        }
        
        assertEquals(forest.getBuilding().get().getBuildingType(), BuildingType.STRONGHOLD);
        assertEquals(forest.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidUpgradeException);
        e = null;

        /* Test Negative Case: upgrade a Stronghold to a Sanctuary. */
        try {
            forest.setBuilding(BuildingType.SANCTUARY, color);
        } catch (Throwable ex) {
            e = ex;
        }
        
        assertEquals(forest.getBuilding().get().getBuildingType(), BuildingType.STRONGHOLD);
        assertEquals(forest.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidUpgradeException);
        e = null;

        /* Test Case Setup: Build a Trading House. */
        try {
            lakes.setBuilding(BuildingType.DWELLING, color);
            lakes.setBuilding(BuildingType.TRADING_HOUSE, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(lakes.getBuilding().isPresent());
        assertEquals(lakes.getBuilding().get().getBuildingType(), BuildingType.TRADING_HOUSE);
        assertEquals(lakes.getBuilding().get().getColor(), color);
        assertEquals(e, null);

        /* Test Positive Case: Upgrade a Trading House to Temple. */
        try {
            lakes.setBuilding(BuildingType.TEMPLE, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(lakes.getBuilding().isPresent());
        assertEquals(lakes.getBuilding().get().getBuildingType(), BuildingType.TEMPLE);
        assertEquals(lakes.getBuilding().get().getColor(), color);
        assertEquals(e, null);

        /* Test Negative Case: Upgrade a Temple to Dwelling. */
        try {
            lakes.setBuilding(BuildingType.DWELLING, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(lakes.getBuilding().isPresent());
        assertEquals(lakes.getBuilding().get().getBuildingType(), BuildingType.TEMPLE);
        assertEquals(lakes.getBuilding().get().getColor(), color);
        assertTrue(e instanceof TileNotEmptyException);
        e = null;

        /* Test Negative Case: Upgrade a Temple to Trading House. */
        try {
            lakes.setBuilding(BuildingType.TRADING_HOUSE, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(lakes.getBuilding().isPresent());
        assertEquals(lakes.getBuilding().get().getBuildingType(), BuildingType.TEMPLE);
        assertEquals(lakes.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidUpgradeException);
        e = null;

        /* Test Negative Case: Upgrade a Temple to Stronghold. */
        try {
            lakes.setBuilding(BuildingType.STRONGHOLD, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(lakes.getBuilding().isPresent());
        assertEquals(lakes.getBuilding().get().getBuildingType(), BuildingType.TEMPLE);
        assertEquals(lakes.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidUpgradeException);
        e = null;

        /* Test Positive Case: Upgrade a Temple to Sanctuary. */
        try {
            lakes.setBuilding(BuildingType.SANCTUARY, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(lakes.getBuilding().isPresent());
        assertEquals(lakes.getBuilding().get().getBuildingType(), BuildingType.SANCTUARY);
        assertEquals(lakes.getBuilding().get().getColor(), color);
        assertEquals(e, null);

        /* Test Negative Case: Upgrade a Sanctuary to Dwelling. */
        try {
            lakes.setBuilding(BuildingType.DWELLING, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(lakes.getBuilding().isPresent());
        assertEquals(lakes.getBuilding().get().getBuildingType(), BuildingType.SANCTUARY);
        assertEquals(lakes.getBuilding().get().getColor(), color);
        assertTrue(e instanceof TileNotEmptyException);
        e = null;

        /* Test Negative Case: Upgrade a Sanctuary to Trading House. */
        try {
            lakes.setBuilding(BuildingType.TRADING_HOUSE, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(lakes.getBuilding().isPresent());
        assertEquals(lakes.getBuilding().get().getBuildingType(), BuildingType.SANCTUARY);
        assertEquals(lakes.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidUpgradeException);
        e = null;

        /* Test Negative Case: Upgrade a Sanctuary to Temple. */
        try {
            lakes.setBuilding(BuildingType.TEMPLE, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(lakes.getBuilding().isPresent());
        assertEquals(lakes.getBuilding().get().getBuildingType(), BuildingType.SANCTUARY);
        assertEquals(lakes.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidUpgradeException);
        e = null;

        /* Test Negative Case: Upgrade a Sanctuary to Stronghold. */
        try {
            lakes.setBuilding(BuildingType.STRONGHOLD, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(lakes.getBuilding().isPresent());
        assertEquals(lakes.getBuilding().get().getBuildingType(), BuildingType.SANCTUARY);
        assertEquals(lakes.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidUpgradeException);
        e = null;

        /* Test Case Setup: Building a Dwelling on an empty tile. */
        try {
            mountains.setBuilding(BuildingType.DWELLING, color);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(mountains.getBuilding().isPresent());
        assertEquals(mountains.getBuilding().get().getBuildingType(), BuildingType.DWELLING);
        assertEquals(mountains.getBuilding().get().getColor(), color);
        assertEquals(e, null);

        /* Test Negative Case: Upgrade a Dwelling to a Trading House of a different color. */
        plAccess.incrementCurrentPlayer();
        String newColor = plAccess.getPlayer().getColor();
        /* Test Case Setup: Building a Dwelling on an empty tile. */
        try {
            mountains.setBuilding(BuildingType.TRADING_HOUSE, newColor);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(mountains.getBuilding().isPresent());
        assertEquals(mountains.getBuilding().get().getBuildingType(), BuildingType.DWELLING);
        assertEquals(mountains.getBuilding().get().getColor(), color);
        assertTrue(e instanceof InvalidColorException);
}

    @Test
    public void testGetType() {

    Tile mountains = board.getTile(5, 0);
    Tile forest = board.getTile(5, 1);
    Tile desert = board.getTile(5, 4);
    Tile river = board.getTile(5, 8);
    Tile plains = board.getTile(5, 9);
    Tile wasteland = board.getTile(6, 5);
    Tile swamp = board.getTile(6, 10);
    Tile lakes = board.getTile(6, 11);

    assertEquals(mountains.getType(), TileType.MOUNTAINS);
    assertEquals(forest.getType(), TileType.FOREST);
    assertEquals(desert.getType(), TileType.DESERT);
    assertEquals(river.getType(), TileType.RIVER);
    assertEquals(plains.getType(), TileType.PLAINS);
    assertEquals(wasteland.getType(), TileType.WASTELAND);
    assertEquals(swamp.getType(), TileType.SWAMP);
    assertEquals(lakes.getType(), TileType.LAKES);
    }

//    @Test
//    public void testSetType() {
//        fail("Not yet implemented");
//    }

//    @Test
//    public void testGetSteps() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testTransformTile() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testIsNeighbor() {
//        fail("Not yet implemented");
//    }

}
