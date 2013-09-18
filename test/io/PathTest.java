/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

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
public class PathTest {
    
    public PathTest() {
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
     * Test of getDirectory method, of class Path.
     */
    @Test
    public void testGetDirectory()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("getDirectory");
        
        String path = "C:\\Users\\user\\Downloads";
        String expResult = "Downloads";
        String result = Path.getDirectory(path);
        System.out.println("Last directory occurence of " + path + " is " + result);
        assertEquals(expResult, result);
        if (!expResult.equals(result))  fail("Something's wrong.");
    }
    
    /**
     * Test of getExtension method, of class Path.
     */
    @Test
    public void testGetExtension()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("getExtension");
        
        // Absolute path
        String path = "C:\\Users\\user\\Downloads\\Joseph Lambert Reyes - Resume.pdf";
        String expResult = "pdf";
        String result = Path.getExtension(path);
        System.out.println("Extension name of " + path + " is " + result);
        assertEquals(expResult, result);
        if (!expResult.equals(result))  fail("Something's wrong.");
        
        // Relative path
        path = "Joseph Lambert Reyes - Resume.doc";
        expResult = "doc";
        result = Path.getExtension(path);
        System.out.println("Extension name of " + path + " is " + result);
        assertEquals(expResult, result);
        if (!expResult.equals(result))  fail("Something's wrong.");
    }
    
    /**
     * Test of getFileName method, of class Path.
     */
    @Test
    public void testGetFileName() {
        System.out.println("-----------------------------------------------");
        System.out.println("getFileName");
        
        String path = "C:\\Users\\user\\Downloads\\Joseph Lambert Reyes - Resume.pdf";
        String expResult = "Joseph Lambert Reyes - Resume.pdf";
        String result = Path.getFileName(path);
        System.out.println("Filename-part of " + path + " is " + result);
        assertEquals(expResult, result);
        if (!expResult.equals(result))  fail("Something's wrong.");
    }
    
    /**
     * Test of getFileNameWithoutExtension method, of class Path.
     */
    @Test
    public void testGetFileNameWithoutExtension() {
        System.out.println("-----------------------------------------------");
        System.out.println("getFileNameWithoutExtension");
        
        // Absolute path
        String path = "C:\\Users\\user\\Downloads\\Joseph Lambert Reyes - Resume.pdf";
        String expResult = "Joseph Lambert Reyes - Resume";
        String result = Path.getFileNameWithoutExtension(path);
        System.out.println("Filename-part w/o extension of " + path + " is " + result);
        assertEquals(expResult, result);
        if (!expResult.equals(result))  fail("Something's wrong.");
    
        // Relative path
        path = "Joseph Lambert Reyes - Resume.doc";
        result = Path.getFileNameWithoutExtension(path);
        System.out.println("Filename-part w/o extension of " + path + " is " + result);
        assertEquals(expResult, result);
        if (!expResult.equals(result))  fail("Something's wrong.");
    }
    
    /**
     * Test of getParentDirectory method, of class Path.
     */
    @Test
    public void testGetParentDirectory()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("getParentDirectory");
        
        // Absolute path
        String path = "C:\\Users\\user\\Downloads\\Joseph Lambert Reyes - Resume.pdf";
        String expResult = "C:\\Users\\user\\Downloads";
        String result = Path.getParentDirectory(path);
        System.out.println("Parent directory of " + path + " is " + result);
        assertEquals(expResult, result);
        if (!expResult.equals(result))  fail("Something's wrong.");
    
        // Relative path
        path = "Joseph Lambert Reyes - Resume.doc";
        expResult = "";
        result = Path.getParentDirectory(path);
        System.out.println("Parent directory of " + path + " is " + result);
        assertEquals(expResult, result);
        if (!expResult.equals(result))  fail("Something's wrong.");
        
         // Directory
        path = "C:\\Users\\user\\Downloads";
        expResult = "C:\\Users\\user";
        result = Path.getParentDirectory(path);
        System.out.println("Parent directory of " + path + " is " + result);
        assertEquals(expResult, result);
        if (!expResult.equals(result))  fail("Something's wrong.");
    }
    
    /**
     * Test of getRootDirectory method, of class Path.
     */
    @Test
    public void testGetRootDirectory()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("getRootDirectory");
        
        // File
        String path = "C:\\Users\\user\\Downloads\\Joseph Lambert Reyes - Resume.pdf";
        String expResult = "C:";
        String result = Path.getRootDirectory(path);
        System.out.println("Root directory of " + path + " is " + result);
        assertEquals(expResult, result);
        if (!expResult.equals(result))  fail("Something's wrong.");
    
        // Directory
        path = "E:\\Current Projects";
        expResult = "E:";
        result = Path.getRootDirectory(path);
        System.out.println("Root directory of " + path + " is " + result);
        assertEquals(expResult, result);
        if (!expResult.equals(result))  fail("Something's wrong.");
    
    }
    
}