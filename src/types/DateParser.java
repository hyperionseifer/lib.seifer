/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

/**
 *
 * @author Seph
 */
public class DateParser {
    
    /**
     * Creates a new instance of DateParser.
     * @param regex Regular expression that supports that current parser's date formatting.
     * @param format Date formatting applicable to current parser.
     */
    public DateParser(String regex, String format)
    { _regex = regex; _dateformat =  format; }
    
    private String _dateformat = "";
    
    /**
     * Gets  the current parser's date format string.
     * @return 
     */
    public String getDateFormat()
    { return _dateformat; }
    
    /**
     * Sets the date format supported by the current parser.
     * @param format 
     */
    public void setDateFormat(String format)
    { _dateformat = format; }
    
    private String _regex = "";
    
    /**
     * Gets the regular expression pattern that supports the current format of the parser.
     * @return 
     */
    public String getRegEx()
    { return _regex; }
    
    /**
     * Sets the regular expression pattern to associate with the supplied date formatting in the parser.
     * @param regex 
     */
    public void setRegEx(String regex)
    { _regex = regex; }
    
}
