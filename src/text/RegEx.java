/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Seph
 */
public class RegEx {

    /**
     * Gets the first matching block of the used regular expression from the evaluated text.
     * @param value Text value to evaluate
     * @param pattern Regular expression
     * @return Matching block from the used regular expression, otherwise a black string if no matches has been found.
     */
    public static String getMatch(String value, String pattern)
    {
        String[] _matches = getMatches(value, pattern);
        String _match = "";
        
        if (_matches != null) 
        {
            if (_matches.length > 0)
            {
                 if (_matches[0] != null) _match = _matches[0];
            }
        }
        
        return _match;
    }
    
    /**
     * Gets the matching blocks using the supplied regular expression within the evaluated text value.
     * @param value Text value to evaluate
     * @param pattern Regular expression.
     * @return Array of string that matches the regular expression.
     */
    public static String[] getMatches(String value, String pattern)
    {
        Pattern _pattern = Pattern.compile(pattern);
        Matcher _matcher = _pattern.matcher(value);
        
        int _count = 0;
        while (_matcher.find())
        { _count += 1; }
        
        if (_count > 0)
        {
            String[] _matches = new String[_count];
            int _current = 0; _matcher.reset();
            
            while (_matcher.find())
            {
                String _value = value.substring(_matcher.start(), _matcher.end());
                _matches[_current] = _value;
                _current += 1;
            }
            
            return _matches;
        }
        else return new String[] {};
    }
    
    /**
     * Determines whether the specified regular expression matches the current text value.
     * @param value Text value to evaluate.
     * @param pattern Regular expression.
     * @return True if the current text value have matching blocks from the supplied regular expression, otherwise false.
     */
    public static boolean matches(String value, String pattern)
    { return value.matches(pattern); }
    
}
