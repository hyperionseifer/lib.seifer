/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import text.Formatter;
import text.RegEx;

/**
 *
 * @author user
 */
public class Converter {
    
    private static DateParser[] supportedDateFormats = new DateParser[] {  new DateParser("[0-9]{2}/[0-9]{2}/[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "MM/dd/yyyy hh:mm:ss a"), 
                                                                           new DateParser("[0-9]{2}\\-[0-9]{2}\\-[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "MM-dd-yyyy hh:mm:ss a"),
                                                                           new DateParser("[0-9]/[0-9]/[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "M/d/yyyy hh:mm:ss a"),
                                                                           new DateParser("[0-9]\\-[0-9]\\-[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "M-d-yyyy hh:mm:ss a"),
                                                                           new DateParser("[0-9]{4}/[0-9]{2}/[0-9]{2} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "yyyy/MM/dd hh:mm:ss a"), 
                                                                           new DateParser("[0-9]{4}\\-[0-9]{2}\\-[0-9]{2} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "yyyy-MM-dd hh:mm:ss a"), 
                                                                           new DateParser("[0-9]{2}/[0-9]{2}/[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2}", "MM/dd/yyyy HH:mm:ss"),
                                                                           new DateParser("[0-9]{2}\\-[0-9]{2}\\-[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2}", "MM-dd-yyyy HH:mm:ss"),
                                                                           new DateParser("[0-9]/[0-9]/[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2}", "M/d/yyyy HH:mm:ss"),
                                                                           new DateParser("[0-9]\\-[0-9]\\-[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2}", "M-d-yyyy HH:mm:ss"),
                                                                           new DateParser("[0-9]{4}/[0-9]{2}/[0-9]{2} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2}", "yyyy/MM/dd HH:mm:ss"),
                                                                           new DateParser("[0-9]{4}\\-[0-9]{2}\\-[0-9]{2} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2}", "yyyy-MM-dd HH:mm:ss"),
                                                                           new DateParser("[0-9]{2}/[0-9]{2}/[0-9]{4} [0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "MM/dd/yyyy hh:mm a"), 
                                                                           new DateParser("[0-9]{2}\\-[0-9]{2}\\-[0-9]{4} [0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "MM-dd-yyyy hh:mm a"),
                                                                           new DateParser("[0-9]/[0-9]/[0-9]{4} [0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "M/d/yyyy hh:mm a"),
                                                                           new DateParser("[0-9]\\-[0-9]\\-[0-9]{4} [0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "M-d-yyyy hh:mm a"),
                                                                           new DateParser("[0-9]{4}/[0-9]{2}/[0-9]{2} [0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "yyyy/MM/dd hh:mm a"), 
                                                                           new DateParser("[0-9]{4}\\-[0-9]{2}\\-[0-9]{2} [0-9]{2}\\:[0-9]{2}\\ (?i)(AM|PM)(?-i)", "yyyy-MM-dd hh:mm a"), 
                                                                           new DateParser("[0-9]{2}/[0-9]{2}/[0-9]{4} [0-9]{2}\\:[0-9]{2}", "MM/dd/yyyy HH:mm"),
                                                                           new DateParser("[0-9]{2}\\-[0-9]{2}\\-[0-9]{4} [0-9]{2}\\:[0-9]{2}", "MM-dd-yyyy HH:mm"),
                                                                           new DateParser("[0-9]/[0-9]/[0-9]{4} [0-9]{2}\\:[0-9]{2}", "M/d/yyyy HH:mm"),
                                                                           new DateParser("[0-9]\\-[0-9]\\-[0-9]{4} [0-9]{2}\\:[0-9]{2}", "M-d-yyyy HH:mm"),
                                                                           new DateParser("[0-9]{4}/[0-9]{2}/[0-9]{2} [0-9]{2}\\:[0-9]{2}", "yyyy/MM/dd HH:mm"),
                                                                           new DateParser("[0-9]{4}\\-[0-9]{2}\\-[0-9]{2} [0-9]{2}\\:[0-9]{2}", "yyyy-MM-dd HH:mm"), 
                                                                                
                                                                           new DateParser("(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)/[0-9]{2}/[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "MMM/dd/yyyy hh:mm:ss a"), 
                                                                           new DateParser("(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)\\-[0-9]{2}\\-[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "MMM-dd-yyyy hh:mm:ss a"),
                                                                           new DateParser("[0-9]{4}/(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)/[0-9]{2} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "yyyy/MMM/dd hh:mm:ss a"), 
                                                                           new DateParser("[0-9]{4}\\-(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)\\-[0-9]{2} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "yyyy-MMM-dd hh:mm:ss a"), 
                                                                           new DateParser("(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)/[0-9]{2}/[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2}", "MMM/dd/yyyy HH:mm:ss"),
                                                                           new DateParser("(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)\\-[0-9]{2}\\-[0-9]{4} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2}", "MMM-dd-yyyy HH:mm:ss"),
                                                                           new DateParser("[0-9]{4}/(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)/[0-9]{2} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2}", "yyyy/MMM/dd HH:mm:ss"),
                                                                           new DateParser("[0-9]{4}\\-(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)\\-[0-9]{2} [0-9]{2}\\:[0-9]{2}\\:[0-9]{2}", "yyyy-MMM-dd HH:mm:ss"),
                                                                           new DateParser("(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)/[0-9]{2}/[0-9]{4} [0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "MMM/dd/yyyy hh:mm a"), 
                                                                           new DateParser("(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)\\-[0-9]{2}\\-[0-9]{4} [0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "MMM-dd-yyyy hh:mm a"),
                                                                           new DateParser("[0-9]{4}/(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)/[0-9]{2} [0-9]{2}\\:[0-9]{2} (?i)(AM|PM)(?-i)", "yyyy/MMM/dd hh:mm a"), 
                                                                           new DateParser("[0-9]{4}\\-(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)\\-[0-9]{2} [0-9]{2}\\:[0-9]{2}\\ (?i)(AM|PM)(?-i)", "yyyy-MMM-dd hh:mm a"), 
                                                                           new DateParser("(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)/[0-9]{2}/[0-9]{4} [0-9]{2}\\:[0-9]{2}", "MMM/dd/yyyy HH:mm"),
                                                                           new DateParser("(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)\\-[0-9]{2}\\-[0-9]{4} [0-9]{2}\\:[0-9]{2}", "MMM-dd-yyyy HH:mm"),
                                                                           new DateParser("[0-9]{4}/(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)/[0-9]{2} [0-9]{2}\\:[0-9]{2}", "yyyy/MMM/dd HH:mm"),
                                                                           new DateParser("[0-9]{4}\\-(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)\\-[0-9]{2} [0-9]{2}\\:[0-9]{2}", "yyyy-MMM-dd HH:mm"),
    
                                                                           new DateParser("[0-9]{2}/[0-9]{2}/[0-9]{4}", "MM/dd/yyyy"),
                                                                           new DateParser("[0-9]/[0-9]/[0-9]{4}", "M/d/yyyy"),
                                                                           new DateParser("[0-9]/[0-9]{2}/[0-9]{4}", "M/dd/yyyy"),
                                                                           new DateParser("[0-9]{2}\\-[0-9]{2}\\-[0-9]{4}", "MM-dd-yyyy"),
                                                                           new DateParser("[0-9]\\-[0-9]\\-[0-9]{4}", "M-d-yyyy"),
                                                                           new DateParser("[0-9]\\-[0-9]{2}\\-[0-9]{4}", "M-dd-yyyy"),
                                                                           new DateParser("[0-9]{4}/[0-9]{2}/[0-9]{2}", "yyyy/MM/dd"),
                                                                           new DateParser("[0-9]{4}/[0-9]/[0-9]{2}", "yyyy/M/dd"),
                                                                           new DateParser("[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}", "yyyy-MM-dd"),
                                                                           new DateParser("[0-9]{4}\\-[0-9]\\-[0-9]{2}", "yyyy-M-dd"),
                                                                           new DateParser("[0-9]{4}/[0-9]{2}/[0-9]", "yyyy/MM/d"),
                                                                           new DateParser("[0-9]{4}\\-[0-9]\\-[0-9]{2}", "yyyy-M-dd"),
                                                                           
                                                                           new DateParser("(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)/[0-9]{2}/[0-9]{4}", "MMM/dd/yyyy"),
                                                                           new DateParser("(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)\\-[0-9]{2}\\-[0-9]{4}", "MMM-dd-yyyy"),
                                                                           new DateParser("[0-9]{4}/(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)/[0-9]{2}", "yyyy/MMM/dd"),
                                                                           new DateParser("[0-9]{4}\\-(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)\\-[0-9]{2}", "yyyy-MMM-dd"),
                                                                           new DateParser("(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)/[0-9]/[0-9]{4}", "MMM/d/yyyy"),
                                                                           new DateParser("(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)\\-[0-9]\\-[0-9]{4}", "MMM-d-yyyy"),
                                                                           new DateParser("[0-9]{4}/(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)/[0-9]", "yyyy/MMM/d"),
                                                                           new DateParser("[0-9]{4}\\-(?i)(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(?-i)\\-[0-9]", "yyyy-MMM-d"),
                                                                           
                                                                           };
    
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
                value instanceof Time ||
                value instanceof java.sql.Date) return true;
            else
            {
                String _toString = value.toString();
                
                for (int i = 0; i < supportedDateFormats.length; i++)
                {
                    DateParser _parser = supportedDateFormats[i];
                    String _match = RegEx.getMatch(_toString, _parser.getRegEx());
                    if (_match.equals(_toString)) return true;
                }
                
                return false;
            }
        }
    }
    
    /**
     * Determines whether the specified object is equal to null or not.
     * @param value Value to evaluate
     * @return True if value is null, otherwise false.
     */
    public static boolean  isNull(Object value)
    { return (value == null); }
    
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
                value instanceof Float ||
                value instanceof Short) return true;
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
    
    /**
     * Converts the specified value to char-typed object.
     * @param value Value to convert.
     * @return Char-typed value of the specified object if it is numeric, otherwise zero.
     */
    public static char toChar(Object value)
    {
        if (value == null) return '\0';
        else 
        {
            String _toString = "";
            
            if (value instanceof String) _toString = (String)value;
            else _toString = value.toString();
            
            if (_toString.length() <= 0) return '\0';
            else return _toString.charAt(0);
        }
    }
    
    /**
     * Converts the specified value to date-typed object.
     * @param value Value to convert.
     * @return Date-typed value of the specified object if it is a date, otherwise 1900-01-01.
     */
    public static Date toDate(Object value)
    {
        if (!isDate(value)) 
        {
           Calendar _calendar = Calendar.getInstance();
           _calendar.set(1900, 0, 1, 0, 0, 0);
           return _calendar.getTime();
        }
        else
        {
           if (value instanceof Date) return (Date)value;
           else if (value instanceof java.sql.Date)
           {
               java.sql.Date _date = (java.sql.Date)value;
               return new Date(_date.getTime());
           }
           else if (value instanceof Timestamp)
           {
               Timestamp _date = (Timestamp)value;
               return new Date(_date.getTime());
           }
           else if (value instanceof Time)
           {
               Time _time = (Time)value;
               return new Date(_time.getTime());
           }
           else
           {
               String _toString = "";
                   
               if (value instanceof String) _toString = (String)value;
               else _toString = value.toString();
               
               if (_toString.equals(""))
               {
                   Calendar _calendar = Calendar.getInstance();
                   _calendar.set(1900, 0, 1, 0, 0, 0);
                   return _calendar.getTime();
               }
               else
               {
                   String _format = "";
                   
                   for (int i = 0; i < supportedDateFormats.length; i++)
                   {
                       DateParser _parser = supportedDateFormats[i];
                       String _match = RegEx.getMatch(_toString, _parser.getRegEx());
                           
                       if (_match.equals(_toString))
                       { _format = _parser.getDateFormat(); break; }
                   }
                   
                   if (_format.equals(""))
                   {
                       Calendar _calendar = Calendar.getInstance();
                       _calendar.set(1900, 0, 1, 0, 0, 0);
                       return _calendar.getTime();
                   }
                   else
                   {
                        SimpleDateFormat _formatter = new SimpleDateFormat(_format);
                      
                        try
                        {
                            Date _date =  _formatter.parse(_toString);
                            return _date;
                        }
                        catch (ParseException ex)
                        {
                            ex.toString();
                            Calendar _calendar = Calendar.getInstance();
                            _calendar.set(1900, 0, 1, 0, 0, 0);
                            return _calendar.getTime();            
                        }
                   }
               }
           }
        }
    }
    
    /**
     * Converts the specified value to double-typed object.
     * @param value Value to convert
     * @return Double-typed value of the specified object if it is numeric, otherwise zero.
     */
    public static double toDouble(Object value)
    {
        if (!isNumeric(value)) return 0;
        else return Double.parseDouble(value.toString());
    }
    
    /**
     * Converts the specified value to float-typed object.
     * @param value Value to convert
     * @return Float-typed value of the specified object if it is numeric, otherwise zero.
     */
    public static float toFloat(Object value)
    {
        if (!isNumeric(value)) return 0;
        else return Float.parseFloat(value.toString());
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
    
      /**
     * Converts the specified date into its date and time string representation.
     * @param value date value to convert
     * @return Date and time string representation of the specified date. 
     */
    public static String toLongDateString(Date value)
    { return Formatter.toLongDateString(value); }
 
    /**
     * Converts the specified date into its date and time string representation.
     * @param value date value to convert
     * @return Date and time string representation of the specified date. 
     */
    public static String toLongDateString(java.sql.Date value)
    { return Formatter.toLongDateString(value); }
    
    /**
     * Converts the specified date into its date and time string representation.
     * @param value date value to convert
     * @return Date and time string representation of the specified date. 
     */
    public static String toLongDateString(Timestamp value)
    { return Formatter.toLongDateString(value); }
  
    /**
     * Converts the specified value to short-typed object.
     * @param value Value to convert
     * @return Short-typed value of the specified object if it is numeric, otherwise zero.
     */
    public static short toShort(Object value)
    {
        if (!isNumeric(value)) return 0;
        else return Short.parseShort(value.toString());
    }
    
    /**
     * Converts the specified date into its short date string representation.
     * @param value Date value to convert.
     * @return Short date string representation of the specified date. 
     */
    public static String toShortDateString(Date value)
    { return Formatter.toShortDateString(value); }
 
    /**
     * Converts the specified date into its short date string representation.
     * @param value Date value to convert.
     * @return Short date string representation of the specified date. 
     */
    public static String toShortDateString(java.sql.Date value)
    { return Formatter.toShortDateString(value);  }
    
    /**
     * Converts the specified date into its short date string representation.
     * @param value Date value to convert
     * @return Short date string representation of the specified date. 
     */
    public static String toShortDateString(Timestamp value)
    { return Formatter.toShortDateString(value);  }
    
    /**
     * Converts the specified date into its SQL-qualified date string representation.
     * @param value Date value to convert
     * @return SQL-qualified date string representation of the specified date. 
     */
    public static String toSqlDateString(Date value)
    { return Formatter.toSqlDateString(value); }
    
    /**
     * Converts the specified date into its SQL-qualified date string representation.
     * @param value Date value to convert
     * @return SQL-qualified date string representation of the specified date. 
     */
    public static String toSqlDateString(java.sql.Date value)
    { return Formatter.toSqlDateString(value); }
    
    
    /**
     * Converts the specified date into its SQL-qualified date string representation.
     * @param value Date value to convert
     * @return SQL-qualified date string representation of the specified date. 
     */
    public static String toSqlDateString(Timestamp value)
    { return Formatter.toSqlDateString(value); }
  
     /**
     * Converts the specified date into its SQL-qualified date and time string representation.
     * @param value Date value to convert
     * @return SQL-qualified date and time string representation of the specified date. 
     */
    public static String toSqlDateTimeString(Date value)
    { return Formatter.toSqlDateString(value); }
  
    /**
     * Converts the specified date into its SQL-qualified date and time string representation.
     * @param value Date value to convert
     * @return SQL-qualified date and time string representation of the specified date. 
     */
    public static String toSqlDateTimeString(java.sql.Date value)
    { return Formatter.toSqlDateTimeString(value); }
    
    /**
     * Converts the specified date into its SQL-qualified date and time string representation.
     * @param value Date value to convert
     * @return SQL-qualified date and time string representation of the specified date. 
     */
    public static String toSqlDateTimeString(Timestamp value)
    { return Formatter.toSqlDateTimeString(value); }
    
}
