/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import types.DateTime;

/**
 *
 * @author Seph
 */
public class SqlStringsTest {
    
    public SqlStringsTest() {
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
     * Test of toSqlValidString method, of class SqlStrings.
     */
    @Test
    public void testToSqlValidString_double() {
        System.out.println("-----------------------------------------------");
        System.out.println("toSqlValidString(double)");
        double value = 1000.0;
        String expResult = "1000.00";
        String result = SqlStrings.toSqlValidString(value);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong");
    }

    /**
     * Test of toSqlValidString method, of class SqlStrings.
     */
    @Test
    public void testToSqlValidString_double_int() {
        System.out.println("-----------------------------------------------");
        System.out.println("toSqlValidString(double, int)");
        double value = 1000.0;
        int decimals = 4;
        String expResult = "1000.0000";
        String result = SqlStrings.toSqlValidString(value, decimals);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong");
    }

    /**
     * Test of toSqlValidString method, of class SqlStrings.
     */
    @Test
    public void testToSqlValidString_float() {
        System.out.println("-----------------------------------------------");
        System.out.println("toSqlValidString(float)");
        float value = 1000.0F;
        String expResult = "1000.00";
        String result = SqlStrings.toSqlValidString(value);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong");
    }

    /**
     * Test of toSqlValidString method, of class SqlStrings.
     */
    @Test
    public void testToSqlValidString_float_int() {
        System.out.println("-----------------------------------------------");
        System.out.println("toSqlValidString(float, int)");
        float value = 1000.0F;
        int decimals = 4;
        String expResult = "1000.0000";
        String result = SqlStrings.toSqlValidString(value, decimals);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong");
    }

    /**
     * Test of toSqlValidString method, of class SqlStrings.
     */
    @Test
    public void testToSqlValidString_juDate() {
        System.out.println("-----------------------------------------------");
        System.out.println("toSqlValidString(Date)");
        Date value = DateTime.now();
        String expResult = DateTime.toSqlDateString(value);
        String result = SqlStrings.toSqlValidString(value);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong");
    }

    /**
     * Test of toSqlValidString method, of class SqlStrings.
     */
    @Test
    public void testToSqlValidString_juDate_boolean() {
        System.out.println("-----------------------------------------------");
        System.out.println("toSqlValidString(Date, boolean)");
        Date value = DateTime.now();
        boolean datetime = true;
        String expResult = DateTime.toSqlDateTimeString(value);
        String result = SqlStrings.toSqlValidString(value, datetime);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong");
    }

    /**
     * Test of toSqlValidString method, of class SqlStrings.
     */
    @Test
    public void testToSqlValidString_String() {
        System.out.println("-----------------------------------------------");
        System.out.println("toSqlValidString(String)");
        String value = "X-X!V''Q";
        String expResult = "X-X!V''''Q";
        String result = SqlStrings.toSqlValidString(value);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong");
    }
}