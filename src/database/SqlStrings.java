package database;

import java.sql.Timestamp;
import java.util.Date;
import text.Formatter;
import types.Converter;

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
     * Converts the specified byte array to a valid SQL text.
     * @param value Byte array to convert
     * @return Hexadecimal SQL notation of the specified byte array.
     */
    public static String toSqlValidString(byte[] value)
    {
        if (value == null) return "NULL";
        else
        {
            String _hex = Converter.toHexadecimalString(value);
            return "x'" + _hex + "'";
        }
    }
    
    /**
     * Parses the specified numeric value to a valid SQL text.
     * @param value Numeric value to convert
     * @return Numeric value in fixed format
     */
    public static String toSqlValidString(double value)
    { return toSqlValidString(value, 2); } 
    
    /**
     * Parses the specified numeric value to a valid SQL text.
     * @param value Numeric value to convert
     * @param decimals Number of decimal places to produce.
     * @return Numeric value in fixed format.
     */
    public static String toSqlValidString(double value, int decimals)
    {
        int _decimals = decimals;
        if (_decimals <= 0) _decimals = 2;
        String _format = "F" + _decimals;
        return Formatter.format(value, _format);
    }

    /**
     * Parses the specified numeric value to a valid SQL text.
     * @param value Numeric value to convert
     * @return Numeric value in fixed format
     */
    public static String toSqlValidString(float value)
    { return toSqlValidString(value, 2); }
    
    /**
     * Parses the specified numeric value to a valid SQL text.
     * @param value Numeric value to convert
     * @param decimals Number of decimal places to produce.
     * @return Numeric value in fixed format.
     */
    public static String toSqlValidString(float value, int decimals)
    { return toSqlValidString(Converter.toDouble(value), decimals); }
    
    /**
     * Parses the specified date value to a valid SQL text.
     * @param value Date value to be parsed.
     * @return SQL-qualified text representation of the specified date value.
     */
    public static String toSqlValidString(Date value)
    { return toSqlValidString(value, false); }
    
    /**
     * Parses the specified date value to a valid SQL text.
     * @param value Date value to be parsed.
     * @param datetime Determines whether to return a complete date and time string or date-part string only.
     * @return SQL-qualified text representation of the specified date value.
     */
    public static String toSqlValidString(Date value, boolean datetime)
    {
        if (datetime) return Formatter.toSqlDateTimeString(value);
        else return Formatter.toSqlDateString(value);
    } 
    
    /**
     * Parses the specified date value to a valid SQL text.
     * @param value Date value to be parsed
     * @return SQL-qualified text representation of the specified date value.
     */
    public static String toSqlValidString(java.sql.Date value)
    { return toSqlValidString(value, false); }
    
    /**
     * Parses the specified date value to a valid SQL text.
     * @param value Date value to be parsed.
     * @param datetime Determines whether to return a complete date and time string or date-part string only.
     * @return SQL-qualified text representation of the specified date value.
     */
    public static String toSqlValidString(java.sql.Date value, boolean datetime)
    {
        Date _date = Converter.toDate(value);
        return toSqlValidString(_date, datetime);
    }
    
    /**
     * Parses the specified date value to a valid SQL text.
     * @param value Date value to be parsed.
     * @return SQL-qualified text representation of the specified date value.
     */
    public static String toSqlValidString(Timestamp value)
    { return toSqlValidString(value, false); }
    
    /**
     * Parses the specified date value to a valid SQL text.
     * @param value Date value to be parsed.
     * @param datetime Determines whether to return a complete date and time string or date-part string only.
     * @return SQL-qualified text representation of the specified date value.
     */
    public static String toSqlValidString(Timestamp value, boolean datetime)
    {
        Date _date = Converter.toDate(value);
        return toSqlValidString(_date, datetime);
    }
    
    /**
     * Parses the specified string value to be a valid SQL text.
     * @param value String value to be parsed
     * @return SQL-qualified text representation of the evaluated value.
     */
    public static String toSqlValidString(String value)
    { return value.replace("'", "''").replace("\\", "\\\\"); }
    
}
