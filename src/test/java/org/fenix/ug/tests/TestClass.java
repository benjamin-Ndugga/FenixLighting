package org.fenix.ug.tests;

import static junit.framework.Assert.assertEquals;
import static org.fenix.ug.Main.get_days_of_power;

/**
 *
 * @author Benjamin E Ndugga
 */
public class TestClass {

    public static void main(String[] args) {
        System.out.println(10000 % 1500);
    }

    public void testDaysOfPowerMethod() {
        assertEquals(get_days_of_power(0, 0, 0, 0, 0, 0, 0), 0);
        assertEquals(get_days_of_power(1000, 3, 500, 10, 1500, 7, 21000), 32);
        assertEquals(get_days_of_power(3000, 3, 500, 10, 1500, 7, 700000), 1374);
    }

}
