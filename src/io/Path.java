/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import text.RegEx;

/**
 *
 * @author Seph
 */
public class Path {
    
    /**
     * Gets the directory name of the specified path.
     * @param path Directory path to evaluate
     * @return The last instance of the directory name in the specified path, if supplied path is a filename, this will work like getFileName method.
     */
    public static String getDirectory(String path)
    { return getFileName(path); }
    
    /**
     * Gets the extension name of the specified file path.
     * @param path Path of the file to evaluate
     * @return Extension name of the file
     */
    public static String getExtension(String path)
    {
        if (path.trim().equals("")) return "";
        else
        {
            String _filename = getFileName(path);
            String[] _matches = RegEx.getMatches(_filename, ".[A-Za-z0-9]+");
            if (_matches.length > 0) return _matches[_matches.length - 1].replace(".", "");
            else return "";
        }
    }
    
    /**
     * Gets the filename part (with extension) of the specified file path.
     * @param path Path of the file to evaluate
     * @return Filename part of the specified file path.
     */
    public static String getFileName(String path)
    {
        if (path.trim().equals("")) return "";
        else
        {
            java.io.File _file = new java.io.File(path);
            return _file.getName();
        }
    }
    
    /**
     * Gets the filename part of the specified file path but without the extension name.
     * @param path Path of the file to evaluate
     * @return Filename-part of the file without extension name.
     */
    public static String getFileNameWithoutExtension(String path)
    {
        if (path.trim().equals("")) return "";
        else
        {
            String _filename = getFileName(path);
            String _extension = getExtension(path);
            return _filename.replace("." + _extension, "");
        }
    }
    
    /**
     * Gets the root directory of the specified file or directory path.
     * @param path Directory or file path to evaluate
     * @return Parent directory of the specified path, otherwise a blank string if path is non-absolute.
     */
    public static String getParentDirectory(String path)
    {
       if (path.trim().equals("")) return "";
       else
       {
           java.io.File _file = new java.io.File(path);
           String _parent = "";
           if (_file.getParentFile() != null) _parent = _file.getParentFile().toString();
           return _parent;
       }
    }
    
    /**
     * Gets the root directory of the specified directory or file path
     * @param path Directory or file path to evaluate
     * @return Root directory of the specified directory or file path , otherwise a blank string if path doe snot have a root directory
     */
    public static String getRootDirectory(String path)
    {
        if (path.trim().equals("")) return "";
        else
        {
            java.io.File _file = new java.io.File(path);
            java.nio.file.Path _path = _file.toPath();
            String _root = "";
            if (_path.getRoot() != null) _root = _path.getRoot().toString().replace("\\", "").replace("/", "");
            return _root;
        }
    }
    
}
