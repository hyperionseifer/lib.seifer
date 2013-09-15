/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author user
 */
public class Converter {
    
    /**
     * Determines whether the specified object is a date value or not.
     * @param value Value to evaluate.
     * @return True if the value if a date value otherwise false.
     */
    public static boolean  isDate(Object value)
    {
        if (value == null) return false;
        else
        {
            if (value instanceof Date ||
                value instanceof Timestamp ||
                value instanceof Time) return true;
            else
            {
                DateFormat _formatter = DateFormat.getInstance();
                try
                {
                    _formatter.parse(value.toString());
                    return true;
                }
                catch (ParseException ex)
                { ex.toString(); return false; }   
            }
        }
    }
    
    /**
     * Determines whether the specified object is a numeric value or not.
     * @param value Value to evaluate.
     * @return True if the value is a numeric value otherwise false.
     */
    public static boolean isNumeric(Object value)
    {
        if (value == null) return false;
        else
        {
            if (value instanceof Byte ||
                value instanceof Integer ||
                value instanceof Long ||
                value instanceof Double ||
                value instanceof Float) return true;
            else
            {
                NumberFormat _formatter = NumberFormat.getInstance();
                try
                {
                    _formatter.parse(value.toString()); 
                    return true;
                }
                catch (ParseException ex) 
                {
                    ex.toString(); return false; 
                }
            }
        }
    }
    
    /**
     * Converts the specified value to boolean-typed object.
     * @param value Value to convert.
     * @return Boolean-typed value of the specified object (for null values, returns false; for numeric values return true if value is greater than zero).
     */
    public static boolean  toBoolean(Object value)
    {
        if (isNumeric(value))
        {
            long _value = toLong(value);
            return (_value > 0);
        }
        else
        {
            if (value == null) return false;
            else 
            {
                String _toString = value.toString();
                if (_toString.toLowerCase().trim().equals("true")) return true;
                else return false;
            }
        }
    }
    
    /**
     * Converts the specified value to byte-typed object.
     * @param value Value to convert.
     * @return Byte-typed value of the specified object if it is numeric, otherwise zero.
     */
    public static byte toByte(Object value)
    {
        if (!isNumeric(value)) return 0;
        else return Byte.parseByte(value.toString());
    }
    
    public static Date toDate(Object value)
    {
        if (!isDate(value)) 
        {
           Calendar _calendar = Calendar.getInstance();
           _calendar.set(1900, 1, 1);
           return _calendar.getTime();
        }
        else
        {
            Calendar _calendar = Calendar.getInstance();
            return _calendar.getTime();
        }
    }
    
    /**
     * Converts the specified value to integer-typed object.
     * @param value Value to convert
     * @return Integer-typed value of the specified object if it is numeric, otherwise zero.
     */
    public static int toInt(Object value)
    {
        if (!isNumeric(value)) return 0;
        else return Integer.parseInt(value.toString());
    }
    
    /**
     * Converts the specified value to long-typed object.
     * @param value Value to convert
     * @return Long-typed value of the specified object if it is numeric, otherwise zero.
     */
    public static long toLong(Object value)
    {
        if (!isNumeric(value)) return 0;
        else return Long.parseLong(value.toString());
    }
    
}
