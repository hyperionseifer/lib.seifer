/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Seph
 */
public class Formatter {
    
    public static String Format(double value, String format)
    {
        String _return = "";
        
        String _pattern1 = "(N|n)[0-9]+";
        String _format = format;
        
        if (format.matches(_pattern1))
        {
        }
        else
        {
            String _pattern2 = "(F|f)[0-9]+";
            
            if (format.matches(_pattern2)) 
            {
                _format = "#############.";
                String[] _numericParts = format.split("[0-9]+");
                if (_numericParts.length > 0)
                {
                    String _numericPart = _numericParts[0];
                    int _decimals = 
                }
            }
        }
        
        DecimalFormat _formatter = new DecimalFormat(_format);
        _return = _formatter.format(value);
        _formatter = null;
        
        return _return;
    }
    
}
