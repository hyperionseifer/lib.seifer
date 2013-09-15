/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.text.NumberFormat;

/**
 *
 * @author user
 */
public class Converter {
    
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
            NumberFormat _formatter = NumberFormat.getInstance();
            try
            {
                _formatter.parse(value.toString()); 
                return true;
            }
            catch (NumberFormatException ex) 
            { return false; }
        }
    }
    
    public static byte ToByte(Object value)
    {
        
    }
    
}
