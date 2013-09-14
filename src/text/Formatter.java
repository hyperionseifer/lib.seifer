/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.misc.Regexp;

/**
 *
 * @author Seph
 */
public class Formatter {
    
    public static String Format(double value, String format)
    {
        String _return = "";
        
        DecimalFormat _formatter = null;
        
        Pattern _pattern1 = Pattern.compile("(N|n)[0-9]+");
        Matcher _matcher1 = _pattern1.matcher(format);
        
        if (_matcher1.matches())
        {
        }
        else
        {
            Pattern _pattern2 = Pattern.compile("(F|f)[0-9]+");
            Matcher _matcher2 = _pattern2.matcher(format);
            
            if (_matcher2.matches())
            {
                
            }
            else
            {
                _formatter = new DecimalFormat(format);
                _return = _formatter.format(value);
            }
        }
        
        if (_formatter != null) _formatter = null;
        
        return _return;
    }
    
}
