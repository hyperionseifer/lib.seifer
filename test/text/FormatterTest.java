/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import types.Converter;

/**
 *
 * @author user
 */
public class FormatterTest {
    
    public FormatterTest() {
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
     * Test of Format method, of class Formatter.
     */
    @Test
    public void testFormat_byte_String() {
        System.out.println("-----------------------------------------------");
        System.out.println("Format(byte, String)");
        
        byte value = 10;
        
        String format = "N4";
        String expResult = "10.0000";
        String result = Formatter.format(value, format);
        
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
    }

    /**
     * Test of Format method, of class Formatter.
     */
    @Test
    public void testFormat_date_String() {
        System.out.println("-----------------------------------------------");
        System.out.println("Format(Date, String)");
        
        Date value = Converter.toDate("8/13/1985");
        
        String format = "sql";
        String expResult = "1985-08-13";
        String result = Formatter.format(value, format);
        
        System.out.println(format + " : " + result);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
        
        format = "sqldatetime";
        expResult = "1985-08-13 00:00:00";
        result = Formatter.format(value, format);
        
        System.out.println(format + " : " + result);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
        
        format = "short";
        expResult = "08/13/1985";
        result = Formatter.format(value, format);
        
        System.out.println(format + " : " + result);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
        
        format = "long";
        expResult = "08/13/1985 12:00:00 AM";
        result = Formatter.format(value, format);
        
        System.out.println(format + " : " + result);
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
    }
    
    /**
     * Test of Format method, of class Formatter.
     */
    @Test
    public void testFormat_double_String() {
        System.out.println("-----------------------------------------------");
        System.out.println("Format(double, String)");
        
        double value = 1000.00;
        
        String format = "N4";
        String expResult = "1,000.0000";
        String result = Formatter.format(value, format);
        
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
    
        format = "F4";
        expResult = "1000.0000";
        result = Formatter.format(value, format);
        
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
    }

    /**
     * Test of Format method, of class Formatter.
     */
    @Test
    public void testFormat_float_String() {
        System.out.println("-----------------------------------------------");
        System.out.println("Format(float, String)");
        
        float value = 1000.0F;
       
        String format = "N4";
        String expResult = "1,000.0000";
        String result = Formatter.format(value, format);
        
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
    
        format = "F4";
        expResult = "1000.0000";
        result = Formatter.format(value, format);
        
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
    }

    /**
     * Test of Format method, of class Formatter.
     */
    @Test
    public void testFormat_int_String() {
        System.out.println("-----------------------------------------------");
        System.out.println("Format(int, String)");
        
        int value = 1000;
        
        String format = "N4";
        String expResult = "1,000.0000";
        String result = Formatter.format(value, format);
        
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
    
        format = "F4";
        expResult = "1000.0000";
        result = Formatter.format(value, format);
        
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
    }

    /**
     * Test of Format method, of class Formatter.
     */
    @Test
    public void testFormat_long_String() {
        System.out.println("-----------------------------------------------");
        System.out.println("Format(long, String)");
        
        long value = 1000L;
        
        String format = "N4";
        String expResult = "1,000.0000";
        String result = Formatter.format(value, format);
        
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
    
        format = "F4";
        expResult = "1000.0000";
        result = Formatter.format(value, format);
        
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
    }

    /**
     * Test of Format method, of class Formatter.
     */
    @Test
    public void testFormat_short_String() {
        System.out.println("-----------------------------------------------");
        System.out.println("Format(short, String)");
        
        short value = 1000;
        
        String format = "N4";
        String expResult = "1,000.0000";
        String result = Formatter.format(value, format);
        
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
    
        format = "F4";
        expResult = "1000.0000";
        result = Formatter.format(value, format);
        
        assertEquals(expResult, result);
        if (!result.equals(expResult)) fail("Something's wrong.");
    }
}