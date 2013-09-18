/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 *
 * @author Seph
 */
public class Directory {
    
    /**
     * Creates the specified directory if it does not exists and returns the file object that associates the directory.
     * @param path Directory path to create
     * @return File object that associates the specified directory, otherwise null if path is not a directory or something went wrong while 
     * attempting to create the directory.
     */
    public static java.io.File create(String path)
    {
        java.io.File _file = new java.io.File(path);
        
        if (_file.exists()) return _file;
        else
        {
            try
            {
                java.nio.file.Path _path = java.nio.file.Files.createDirectory(_file.toPath());
                return _path.toFile();
            }
            catch (IOException ex)
            { 
                ex.getMessage(); return null; 
            }
        }
    }

    /**
     * Deletes the specified directory.
     * @param path Directory path to delete
     * @return True if directory has been successfully deleted, otherwise false  (note that method will fail if the specified directory is not empty).
     */
    public static boolean delete(String path)
    { return delete(path, false); }
    
    /**
     * Deletes the specified directory.
     * @param path Directory path to delete
     * @param recursive If set to true, this will ensure deletion of the directory by attempting to delete
     * directories and sub-directories under it, otherwise deletion will fail if the specified directory is 
     * not empty.
     * @return True if directory has been successfully deleted, otherwise false.
     */
    public static boolean delete(String path, boolean recursive)
    {
        boolean _deleted = true;
        
        java.io.File _file = new java.io.File(path);
        if (_file.isDirectory())
        {
            if (recursive)
            {
                java.io.File[] _files = getFiles(path);
                if (_files != null)
                {
                    for (int i = 0; i < _files.length; i++)
                    {
                        java.io.File _current = _files[i];
                        
                        if (_current.isDirectory()) _deleted =  delete(_current.toString(), true);
                        else _deleted = _current.delete();

                        if (!_deleted) break;
                    }
                }
            }
            
            if (_deleted) _deleted = _file.delete();
        }
        
        return _deleted;
    }
    
    /**
     * Determines whether a directory with the specified path already exists or not.
     * @param path Directory path to evaluate
     * @return True if the directory already exists, otherwise false if not.
     */
    public static boolean exists(String path)
    {
        boolean _exists = false;
        
        if (!path.trim().equals(""))
        {
            java.io.File _file = new java.io.File(path);
            if (_file.isDirectory()) _exists = _file.exists();
        }
        
        return _exists;
    }
    
    /**
     * Gets each of the directories within the specified directory path.
     * @param path Directory path to evaluate
     * @return Array of file object associating each of the directories inside the specified directory path, otherwise null
     * if directory does not exists or the supplied path is not a directory.
     */
    public static java.io.File[] getDirectories(String path)
    {
        if (path.trim().equals("")) return null;
        else
        {
            java.io.File _file = new java.io.File(path);
            if (!_file.exists()) return null;
            else
            {
                if (!_file.isDirectory()) return null;
                else return _file.listFiles(new FileFilter() {

                    @Override
                    public boolean accept(File file) {
                        return file.isDirectory();
                    }
                });
            }
        }
    }
    
    /**
     * Gets the files within the specified directory
     * @param path Directory path
     * @return Array of File objects that denotes each of the existing files inside the directory, otherwise null if directory
     * does not exists or no file is currently present in the specified directory.
     */
    public static java.io.File[] getFiles(String path)
    { return getFiles(path, false); }
    
    /**
     * Gets the files and folders within the specified directory
     * @param path Directory path
     * @param includedirectories Determines whether to include directories in the returned list or not
     * @return Array of File objects that denotes each of the existing files inside the directory, otherwise null if directory
     * does not exists or no file is currently present in the specified directory.
     */
    public static java.io.File[] getFiles(String path, boolean includedirectories)
    {
        java.io.File _file = new java.io.File(path);
        if (!_file.exists()) return null;
        else
        {
            if (!_file.isDirectory()) return null;
            else 
            {
                if (includedirectories) return _file.listFiles();
                else
                {
                    return _file.listFiles(new FileFilter() {

                        @Override
                        public boolean accept(File file) {
                            return !file.isDirectory();
                        }
                    });
                }
            }
        }
    }
    
}
