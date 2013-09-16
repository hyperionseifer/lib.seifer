/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import types.Converter;

/**
 *
 * @author Seph
 */
public class Formatter {
    
    /**
     * Renders decimal formatting to the specified numeric value.
     * @param value Value to format
     * @param pattern Formatting scheme
     * @return Decimal formatted string value.
     */
    public static String format(byte value, String pattern)
    {
        double _value = Converter.toDouble(value);
        return format(_value, pattern);
    }
   
    /**
     * Renders formatting to the specified date using the supplied formatting pattern.
     * @param value Date value to format
     * @param pattern Formatting pattern.
     * @return Formatted date string based on the supplied pattern.
     */
    public static String format(Date value, String pattern)
    {
        String _formatted = "";
        String _format = "";
        
        if (pattern.matches("(?i)shortdate(?-i)") ||
            pattern.matches("(?i)short date(?-i)") ||
            pattern.matches("(?i)short(?-i)")) _format = "MM/dd/yyyy";
        else
        {
            if (pattern.matches("(?i)longdate(?-i)") ||
                pattern.matches("(?i)long date(?-i)") ||
                pattern.matches("(?i)long(?-i)") ||
                pattern.matches("(?i)datetime(?-i)") ||
                pattern.matches("(?i)date time(?-i)") ||
                pattern.matches("(?i)dateandtime(?-i)") ||
                pattern.matches("(?i)date and time(?-i)")) _format = "MM/dd/yyyy hh:mm:ss a";
            else
            {
                if (pattern.matches("(?i)sqldatetime(?-i)") ||
                    pattern.matches("(?i)sql datetime(?-i)") ||
                    pattern.matches("(?i)sql date time(?-i)") ||
                    pattern.matches("(?i)sqldateandtime(?-i)") ||
                    pattern.matches("(?i)sql dateandtime(?-i)") ||
                    pattern.matches("(?i)sql date and time(?-i)")) _format = "yyyy-MM-dd HH:mm:ss";
                else
                {
                    if (pattern.matches("(?i)sqldate(?-i)") ||
                        pattern.matches("(?i)sql date(?-i)") ||
                        (pattern.trim().toLowerCase().equals("sql"))) _format = "yyyy-MM-dd";
                    else
                    {
                        if (pattern.matches("(?i)shorttime(?-i)") ||
                            pattern.matches("(?i)short time(?-i)") ||
                            (pattern.trim().toLowerCase().equals("time"))) _format = "hh:mm a";
                        else
                        {
                            if (pattern.matches("(?i)longtime(?-i)") ||
                                pattern.matches("(?i)long time(?-i)")) _format = "hh:mm:ss a";
                            else
                            {
                                if (pattern.matches("(?i)militarytime(?-i)") ||
                                    pattern.matches("(?i)military time(?-i)") ||
                                    pattern.trim().toLowerCase().equals("military")) _format = "HH:mm:ss";
                                else
                                {
                                    if (pattern.trim().contains("tt")) _format = pattern.replace("tt", "a");
                                    else _format = pattern;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        SimpleDateFormat _formatter = new SimpleDateFormat(_format);
       _formatted = _formatter.format(value);
       _formatter = null; 
       
        return _formatted;
    }
    
    /**
     * Renders formatting to the specified date using the supplied formatting pattern.
     * @param value Date value to format
     * @param pattern Formatting pattern.
     * @return Formatted date string based on the supplied pattern.
     */
    public static String format(java.sql.Date value, String pattern)
    {
        Date _date = Converter.toDate(value);
        return format(_date, pattern);
    }
    
    /**
     * Renders decimal formatting to the specified numeric value.
     * @param value Value to format
     * @param pattern Formatting scheme
     * @return Decimal formatted string value.
     */
    public static String format(double value, String pattern)
    {
        String _return = "";
        
        String _pattern1 = "(N|n)[0-9]+";
        String _format = "";
        boolean _decimalShown = false;
        
        if (pattern.matches(_pattern1))
        {
            _format = "#,###,###,###,###,###,##0.";
                
            String _match = RegEx.getMatch(pattern, "[0-9]+");
            int _decimals = Converter.toInt(_match);
                
            if (_decimals <= 0) _decimals = 2;
                
            for (int i = 0; i < _decimals; i++) _format += "0";
            _decimalShown = true;
        }
        else
        {
            String _pattern2 = "(F|f)[0-9]+";
            
            if (pattern.matches(_pattern2)) 
            {
                _format = "###################.";
                
                String _match = RegEx.getMatch(pattern, "[0-9]+");
                int _decimals = Converter.toInt(_match);
                
                if (_decimals <= 0) _decimals = 2;
                
                for (int i = 0; i < _decimals; i++) _format += "0";
                _decimalShown = true;
            }
            else _format = pattern;
        }
        
        DecimalFormat _formatter = new DecimalFormat(_format);
        if (_decimalShown) _formatter.setDecimalSeparatorAlwaysShown(true);
       
        _return = _formatter.format(value);
        _formatter = null;
        
        return _return;
    }
    
    /**
     * Renders decimal formatting to the specified numeric value.
     * @param value Value to format
     * @param pattern Formatting scheme
     * @return Decimal formatted string value. 
     */
    public static String format(float value, String pattern)
    {
        double _value = Converter.toDouble(value);
        return format(_value, pattern);
    }
    
    /**
     * Renders decimal formatting to the specified numeric value.
     * @param value Value to format
     * @param pattern Formatting scheme
     * @return Decimal formatted string value. 
     */
    public static String format(int value, String pattern)
    {
        double _value = Converter.toDouble(value);
        return format(_value, pattern);
    }
    
    /**
     * Renders decimal formatting to the specified numeric value.
     * @param value Value to format
     * @param pattern Formatting scheme
     * @return Decimal formatted string value. 
     */
    public static String format(long value, String pattern)
    {
        double _value = Converter.toDouble(value);
        return format(_value, pattern);
    }
    
    /**
     * Renders decimal formatting to the specified numeric value.
     * @param value Value to format
     * @param pattern Formatting scheme
     * @return Decimal formatted string value.
     */
    public static String format(short value, String pattern)
    {
        double _value = Converter.toDouble(value);
        return format(_value, pattern);
    }
    
    /**
     * Renders formatting to the specified time using the supplied formatting pattern.
     * @param value Time value to format
     * @param pattern Formatting pattern.
     * @return Formatted time string based on the supplied pattern.
     */
    public static String format(Time value, String pattern)
    {
        Date _date = Converter.toDate(value);
        return format(_date, pattern);
    }
    
    /**
     * Renders formatting to the specified date using the supplied formatting pattern.
     * @param value Date value to format
     * @param pattern Formatting pattern.
     * @return Formatted date string based on the supplied pattern.
     */
    public static String format(Timestamp value, String pattern)
    {
        Date _date = Converter.toDate(value);
        return format(_date, pattern);
    }
}
