/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class ConverterTest {
    
    public ConverterTest() {
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
     * Test of isDate method, of class Converter.
     */
    @Test
    public void testIsDate() {
        System.out.println("-----------------------------------------------");
        System.out.println("isDate");
        Object value = "1/1/1900";
        boolean expResult = true;
        boolean result = Converter.isDate(value);
        assertEquals(expResult, result);
        if (expResult != result) fail("Something's wrong.");
    }

    /**
     * Test of isNumeric method, of class Converter.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("-----------------------------------------------");
        System.out.println("isNumeric");
        Object value = "100.547";
        boolean expResult = true;
        boolean result = Converter.isNumeric(value);
        assertEquals(expResult, result);
        if (expResult != result) fail("Something's wrong.");
    }

    /**
     * Test of toBoolean method, of class Converter.
     */
    @Test
    public void testToBoolean() {
        System.out.println("-----------------------------------------------");
        System.out.println("toBoolean");
        Object value = "1";
        boolean expResult = true;
        boolean result = Converter.toBoolean(value);
        assertEquals(expResult, result);
        if (expResult != result) fail("Something's wrong.");
    }

    /**
     * Test of toByte method, of class Converter.
     */
    @Test
    public void testToByte() {
        System.out.println("-----------------------------------------------");
        System.out.println("toByte");
        Object value = "1";
        byte expResult = 1;
        byte result = Converter.toByte(value);
        assertEquals(expResult, result);
        if (expResult != result) fail("Something's wrong.");
    }

    /**
     * Test of toDate method, of class Converter.
     */
    @Test
    public void testToDate() {
        System.out.println("-----------------------------------------------");
        System.out.println("toDate");
        Object value = "8/13/1985";
        Calendar _calendar = Calendar.getInstance();
        _calendar.set(1985, 7, 13, 0, 0, 0);
        
        Date expResult = _calendar.getTime();
        Date result = Converter.toDate(value);
     
        if (expResult.compareTo(result) != 1) fail("Something's wrong.");
    }

    /**
     * Test of toInt method, of class Converter.
     */
    @Test
    public void testToInt() {
        System.out.println("-----------------------------------------------");
        System.out.println("toInt");
        Object value = "100";
        int expResult = 100;
        int result = Converter.toInt(value);
        assertEquals(expResult, result);
        if (expResult != result) fail("Something's wrong.");
    }

    /**
     * Test of toLong method, of class Converter.
     */
    @Test
    public void testToLong() {
        System.out.println("-----------------------------------------------");
        System.out.println("toLong");
        Object value = "200000";
        long expResult = 200000L;
        long result = Converter.toLong(value);
        assertEquals(expResult, result);
        if (expResult != result) fail("Something's wrong.");
    }
}