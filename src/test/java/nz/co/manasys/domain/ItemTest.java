package nz.co.manasys.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ItemTest {

    @Test
    public void testInitializeSuccess() throws Exception {
        Item item = Item.initialize("1001", "6200", "30", "9.653");
        Item item2 = Item.initialize("2001", "7200", "50", "11.21");
        assertNotNull(item);
        assertNotNull(item2);
    }
}
