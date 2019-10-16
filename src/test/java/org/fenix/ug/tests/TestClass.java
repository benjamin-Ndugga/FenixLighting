package org.fenix.ug.tests;

import static junit.framework.Assert.assertEquals;
import static org.fenix.ug.Main.get_days_of_power;

/**
 * Test-Casses
 *
 * @author Benjamin E Ndugga
 */
public class TestClass {

    
    public void testDaysOfPowerMethod() {
        assertEquals(get_days_of_power(0, 0, 0, 0, 0, 0, 0), 0);
        assertEquals(get_days_of_power(1000, 3, 500, 10, 1500, 7, 21000), 10);
        assertEquals(get_days_of_power(3000, 3, 500, 10, 1500, 7, 700000), 141);
    }

}
