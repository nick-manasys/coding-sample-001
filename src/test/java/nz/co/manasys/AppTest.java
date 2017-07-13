package nz.co.manasys;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import nz.co.manasys.domain.Configuration;
import nz.co.manasys.domain.Item;
import nz.co.manasys.domain.Pack;
import nz.co.manasys.domain.SortOrder;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    @Test
    public void testProcessInputs() throws Exception {
        // setUp
        Configuration configuration = Configuration.initialize("NATURAL", "40", "500.0");
        List<Item> items = new ArrayList<Item>();
        Item item = Item.initialize("1001", "6200", "30", "9.653");
        items.add(item);
        item = Item.initialize("2001", "7200", "50", "11", "21");
        items.add(item);

        // run
        List<Pack> packs = App.processInputs(configuration, items);

        // assertions
        assertEquals(2, packs.size());

        // pack 1
        assertEquals(2, packs.get(0).items.size());
        assertEquals(30, packs.get(0).items.get(0).quantity);
        assertEquals(10, packs.get(0).items.get(1).quantity);

        // pack 2
        assertEquals(1, packs.get(1).items.size());
        assertEquals(40, packs.get(1).items.get(0).quantity);
    }

    @Test
    public void testSortItemsNORMAL() throws Exception {
        List<Item> items = new ArrayList<Item>();
        Item item1 = Item.initialize("1001", "6200", "30", "9.653");
        items.add(item1);
        Item item2 = Item.initialize("2001", "7200", "50", "11", "21");
        items.add(item2);

        // run
        List<Item> sortedItems = App.sortItems(SortOrder.NATURAL, items);

        // assertions
        assertEquals(2, sortedItems.size());
        assertEquals(item1, sortedItems.get(0));
        assertEquals(item2, sortedItems.get(1));
    }

    @Test
    public void testSortItemsLONG_TO_SHORT() throws Exception {
        List<Item> items = new ArrayList<Item>();
        Item item1 = Item.initialize("1001", "6200", "30", "9.653");
        items.add(item1);
        Item item2 = Item.initialize("2001", "7200", "50", "11", "21");
        items.add(item2);

        // run
        List<Item> sortedItems = App.sortItems(SortOrder.LONG_TO_SHORT, items);

        // assertions
        assertEquals(2, sortedItems.size());
        assertEquals(item2, sortedItems.get(0));
        assertEquals(item1, sortedItems.get(1));
    }

    @Test
    public void testSortItemsSHORT_TO_LONGL() throws Exception {
        List<Item> items = new ArrayList<Item>();
        Item item1 = Item.initialize("1001", "6200", "30", "9.653");
        items.add(item1);
        Item item2 = Item.initialize("2001", "7200", "50", "11", "21");
        items.add(item2);

        // run
        List<Item> sortedItems = App.sortItems(SortOrder.SHORT_TO_LONG, items);

        // assertions
        assertEquals(2, sortedItems.size());
        assertEquals(item1, sortedItems.get(0));
        assertEquals(item2, sortedItems.get(1));
    }

}
