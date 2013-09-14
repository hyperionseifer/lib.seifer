/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Seph
 */
public class RegExTest {
    
    public RegExTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of matches method, of class RegEx.
     */
    @Test
    public void testMatches() {
        System.out.println("RegEx.matches(pattern, value)");
        String pattern = "(N|n)[0-9]+";
        String value = "N2";
        boolean expResult = true;
        boolean result = RegEx.matches(pattern, value);
        assertEquals(expResult, result);
        if (!result) fail("Something's wrong.");
    }
}