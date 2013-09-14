/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Seph
 */
public class RegEx {
    
    /**
     * Gets the collection of string that matches the supplied pattern from the given text.
     * @param pattern Regular expression.
     * @param value Text to evaluate
     * @return An array of string that contains the matching phrases otherwise null if there are no matches.S
     */
    public static String[] getMatches(String pattern, String value)
    {
        String[] _matches = null;
        
        Pattern _pattern = Pattern.compile(pattern);
        Matcher _matcher = _pattern.matcher(value);

        int _matchCount = _matcher.groupCount();
        
        if (_matchCount > 0)
        {
            _matches = new String[_matchCount];

            for (int i = 0; i < _matchCount; i++) _matches[i] = _matcher.group(i);
        }
        
        return _matches;
    }
    
    /**
     * Determines whether a certain value matches the supplied regular expression.
     * @param pattern Regular expression
     * @param value String value to evaluate
     * @return True if value matches the regular expression otherwise false.
     */
    public static boolean matches(String pattern, String value)
    {
        Pattern _pattern = Pattern.compile(pattern);
        Matcher _matcher = _pattern.matcher(value);
        
        boolean _matches = _matcher.matches();
        
        _matcher = null; _pattern = null;
        
        return _matches;
    }
    
}
