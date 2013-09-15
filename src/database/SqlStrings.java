package database;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Seph
 */
public class SqlStrings {
    
    /**
     * Parses the specified string value to be a valid SQL text.
     * @param value String value to be parsed
     * @return SQL-qualified text representation of the evaluated value.
     */
    public static String ToSqlValidString(String value)
    { return value.replace("'", "''").replace("\\", "\\\\"); }
    
}
