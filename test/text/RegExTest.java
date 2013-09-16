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
     * Test of getMatch method, of class RegEx.
     */
    @Test
    public void testGetMatch() {
        System.out.println("-----------------------------------------------");
        System.out.println("getMatch");
        
        String value = "8/13/1985";
        String pattern = "[0-9]{2}/[0-9]{2}/[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)";
        String expResult = "";
        
        String result = RegEx.getMatch(value, pattern);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong");
        
        pattern = "[0-9]/[0-9]{2}/[0-9]{4}";
        expResult = value;
        
        result = RegEx.getMatch(value, pattern);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong");
    }

    /**
     * Test of getMatches method, of class RegEx.
     */
    @Test
    public void testGetMatches() {
        System.out.println("-----------------------------------------------");
        System.out.println("getMatches");
        
        String value = "8/13/1985";
        String pattern = "[0-9]{2}/[0-9]{2}/[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)";
        
        String[] expResult = new String[] {};
        String[] result = RegEx.getMatches(value, pattern);
        assertArrayEquals(expResult, result);
        if (result.length !=  expResult.length) fail("Something's wrong.");
    
        pattern = "[0-9]/[0-9]{2}/[0-9]{4}";
        expResult = new String[] { value };
        result = RegEx.getMatches(value, pattern);
        assertArrayEquals(expResult, result);
        if (result.length !=  expResult.length) fail("Something's wrong.");
    }

    /**
     * Test of matches method, of class RegEx.
     */
    @Test
    public void testMatches() {
        System.out.println("-----------------------------------------------");
        System.out.println("matches");
        
        String value = "8/13/1985";
        String pattern = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
     
        boolean expResult = false;
        boolean result = RegEx.matches(value, pattern);
        assertEquals(expResult, result);
        if (result != expResult) fail("Something's wrong.");
        
        pattern = "[0-9]/[0-9]{2}/[0-9]{4}";
        expResult = true;
        result = RegEx.matches(value, pattern);
        assertEquals(expResult, result);
        if (result != expResult) fail("Something's wrong.");
    }
}