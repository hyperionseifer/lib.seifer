/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.File;
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
public class DirectoryTest {
    
    public DirectoryTest() {
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
     * Test of create method, of class Directory.
     */
    @Test
    public void testCreate() {
        System.out.println("-----------------------------------------------");
        System.out.println("create");
        String path = "C:\\Users\\user\\Desktop\\sample directory\\";
        File result = Directory.create(path);
        if (result == null) fail("Something's wrong.");
    }

    /**
     * Test of delete method, of class Directory.
     */
    @Test
    public void testDelete()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("delete");
        String path = "C:\\Users\\user\\Desktop\\to delete dir\\";
        
        if (!Directory.exists(path)) 
        {
            File _dir = Directory.create(path);
            if (_dir == null) fail("Something's wrong");
        }
        
        String filePath = path + "\\sample.txt";
        if (!io.File.exists(filePath))
        {
            File _file = io.File.write(filePath, "sample only");
            if (_file == null) fail("Something's wrong");
        }
        
        boolean result = Directory.delete(path, true);
        if (!result) fail("Something's wrong");
    }
    
    /**
     * Test of getDirectories method, of class Directory.
     */
    @Test
    public void testGetDirectories()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("getDirectories");
        String path = "C:\\";
        File[] result = Directory.getDirectories(path);
        if (result == null) fail("Something's wrong.");
        else
        {
            if (result.length > 0)
            {
                System.out.println("Directories in " + path);
                
                for (int i = 0; i < result.length; i++)
                {
                    File _file = result[i];
                    System.out.println(_file.getName());
                }
            }
        }
    }
    
    /**
     * Test of getFiles method, of class Directory.
     */
    @Test
    public void testGetFiles()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("getFiles");
        String path = "C:\\Users\\user\\Desktop";
        File[] result = Directory.getFiles(path);
        if (result == null) fail("Something's wrong");
        else
        {
            if (result.length > 0)
            {
                System.out.println("Files and Folders in " + path + ":");
                for (int i = 0; i < result.length; i++)
                {
                    File _file = result[i];
                    System.out.println((_file.isDirectory()? "[Directory]" : "") + _file.getName());
                }
            }
        }
    }
    
}