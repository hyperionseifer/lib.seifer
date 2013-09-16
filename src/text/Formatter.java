/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.text.DecimalFormat;
import types.Converter;

/**
 *
 * @author Seph
 */
public class Formatter {
    
    /**
     * Renders decimal formatting to the specified numeric value.
     * @param value Value to format
     * @param format Formatting scheme
     * @return Decimal formatted string value.
     */
    public static String Format(byte value, String format)
    {
        double _value = Converter.toDouble(value);
        return Format(_value, format);
    }
    
    /**
     * Renders decimal formatting to the specified numeric value.
     * @param value Value to format
     * @param format Formatting scheme
     * @return Decimal formatted string value.
     */
    public static String Format(double value, String format)
    {
        String _return = "";
        
        String _pattern1 = "(N|n)[0-9]+";
        String _format = "";
        boolean _decimalShown = false;
        
        if (format.matches(_pattern1))
        {
            _format = "#,###,###,###,###,###,##0.";
                
            String _match = RegEx.getMatch(format, "[0-9]+");
            int _decimals = Converter.toInt(_match);
                
            if (_decimals <= 0) _decimals = 2;
                
            for (int i = 0; i < _decimals; i++) _format += "0";
            _decimalShown = true;
        }
        else
        {
            String _pattern2 = "(F|f)[0-9]+";
            
            if (format.matches(_pattern2)) 
            {
                _format = "###################.";
                
                String _match = RegEx.getMatch(format, "[0-9]+");
                int _decimals = Converter.toInt(_match);
                
                if (_decimals <= 0) _decimals = 2;
                
                for (int i = 0; i < _decimals; i++) _format += "0";
                _decimalShown = true;
            }
            else _format = format;
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
     * @param format Formatting scheme
     * @return Decimal formatted string value. 
     */
    public static String Format(float value, String format)
    {
        double _value = Converter.toDouble(value);
        return Format(_value, format);
    }
    
    /**
     * Renders decimal formatting to the specified numeric value.
     * @param value Value to format
     * @param format Formatting scheme
     * @return Decimal formatted string value. 
     */
    public static String Format(int value, String format)
    {
        double _value = Converter.toDouble(value);
        return Format(_value, format);
    }
    
    /**
     * Renders decimal formatting to the specified numeric value.
     * @param value Value to format
     * @param format Formatting scheme
     * @return Decimal formatted string value. 
     */
    public static String Format(long value, String format)
    {
        double _value = Converter.toDouble(value);
        return Format(_value, format);
    }
    
    /**
     * Renders decimal formatting to the specified numeric value.
     * @param value Value to format
     * @param format Formatting scheme
     * @return Decimal formatted string value.
     */
    public static String Format(short value, String format)
    {
        double _value = Converter.toDouble(value);
        return Format(_value, format);
    }
    
}
