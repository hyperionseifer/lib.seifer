/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Seph
 */
public class File {
    
    /**
     * Copies one file to the another
     * @param source Path of the source file
     * @param target Path of the destination file
     * @return True if file has been successfully copied, otherwise false.
     */
    public static boolean copy(String source, String target)
    { return copy(source, target, true); }
    
    /**
     * Copies one file to the another
     * @param source Path of the source file
     * @param target Path of the destination file
     * @param overwrite Determines whether the destination file if it is existing or not.
     * @return True if file has been successfully copied, otherwise false.
     */
    public static boolean copy(String source, String target, boolean overwrite)
    {
        boolean _copied = false;
        
        StandardCopyOption _option = StandardCopyOption.COPY_ATTRIBUTES;
        if (overwrite) _option = StandardCopyOption.REPLACE_EXISTING;
        
        java.io.File _source = new java.io.File(source);
        java.io.File _destination = new java.io.File(target);
      
        try
        { 
            Files.copy(_source.toPath(), _destination.toPath(), _option); 
            _copied = true; 
        }
        catch (IOException ex) 
        { ex.toString(); }
        
        return _copied;
    }
    
    /**
     * Permanently deletes the specified file.
     * @param filename Path of the file to be deleted.
     * @return True if file has been successfully deleted, otherwise false.
     */
    public static boolean delete(String filename)
    {
        java.io.File _file = new java.io.File(filename);
        if (_file.exists()) return _file.delete();
        else return true;
    }
    
    /**
     * Determines whether a file with the specified path already exists or not.
     * @param filename Path of the file to be checked
     * @return True if the file already exists, otherwise false.
     */
    public static boolean exists(String filename)
    {
        java.io.File _file = new java.io.File(filename);
        return _file.exists();
    }
    
    /**
     * Moves a file into another location.
     * @param source Path of the source file
     * @param destination Destination path
     * @return Determines whether to overwrite destination file if its already existing or not
     */
    public static boolean move(String source, String destination)
    { return move(source, destination, false); }
    
    /**
     * Moves a file into another location.
     * @param source Path of the source file
     * @param destination Destination path
     * @param overwrite Determines whether to overwrite destination file if its already existing or not
     * @return True if file has been successfully moved otherwise false,
     */
    public static boolean move(String source, String destination, boolean overwrite)
    {
        boolean _moved = false;
        
        java.io.File _source = new java.io.File(source);
        java.io.File _destination = new java.io.File(destination);
        
        StandardCopyOption _option = StandardCopyOption.ATOMIC_MOVE;
        if (overwrite) _option = StandardCopyOption.REPLACE_EXISTING;
        
        try
        { 
            Files.move(_source.toPath(), _destination.toPath(), _option); 
            _moved = true; 
        }
        catch (IOException ex) 
        {  ex.toString(); }
        
        return _moved;
    }
    
    /**
     * Reads text from the specified file.
     * @param filename Path of the file
     * @return Contents of the specified file
     */
    public static String read(String filename)
    { return read(new java.io.File(filename)); }
    
    /**
     * Reads text from the specified file.
     * @param file File to be red
     * @return Contents of the specified file
     */
    public static String read(java.io.File file)
    {
        StringBuilder _contents = new StringBuilder();
        
        if (file != null)
        {
            if (file.exists())
            {
                try
                {
                    int _read = 0;
                    int _mb = 1024 * 1024;
                    char[] _buffer = new char[_mb];
                    
                    FileReader _reader = new FileReader(file);
                    BufferedReader _buffreader = new BufferedReader(_reader);
                    
                    while (true)
                    {
                        _read = _buffreader.read(_buffer, 0, _mb);
                        _contents.append(new String(_buffer, 0, _read));
                        
                        if (_mb > _read) break;
                    }
                }
                catch (Exception ex) { ex.toString(); }
            }
        }
        
        return _contents.toString();
    }
    
    /**
     * Writes the supplied text into the specified file.
     * @param text String / text to be written
     * @param filename Path of the file
     * @return File object associating the written file, otherwise null if something went wrong while writing.
     */
    public static java.io.File write(String filename, String text)
    { return write(filename, text.getBytes()); }
    
    /**
     * Writes the supplied byte array into the specified file.
     * @param value Byte array to be written
     * @param filename Path of the file
     * @return File object associating the written file, otherwise null if something went wrong while writing.
     */
    public static java.io.File write(String filename, byte[] value)
    {
        boolean _written = false;
        java.io.File _file = new java.io.File(filename);
        FileOutputStream _stream = null;
        
        try
        {
              _stream = new FileOutputStream(_file);
        
              try
              { 
                  _stream.write(value); 
                  _stream.close(); _written = true;
              }
              catch (IOException ex) { ex.toString(); }
              finally {  }
        }
        catch (FileNotFoundException ex)
        { ex.toString(); }
        
        if (_written) 
        {
            if (_file.exists()) return _file;
            else return null;
        }
        else return null;
    }
    
}
