package nz.co.manasys.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ConfigurationTest {

    @Test
    public void testInitializeSuccess() throws Exception {
        Configuration configuration = Configuration.initialize("NATURAL", "3", "1.00");

        assertNotNull(configuration);
    }

    @Test
    public void testInitializeFailure() throws Exception {
        try {
            Configuration configuration = Configuration.initialize("NATURAL", "a", "1.00");
            fail();
        } catch (Exception e) {
            // SUCCESS
        }
    }
}
