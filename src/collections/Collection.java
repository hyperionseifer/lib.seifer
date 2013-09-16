/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.Arrays;

/**
 *
 * @author Seph
 */
public class Collection {
    
    /**
     * Determines whether the specified value element is already present within the supplied array.
     * @param list Array to evaluate
     * @param value Value to find
     * @return True if value is existing within the array, otherwise false.
     */
    public static boolean Contains(Object[] list, Object value)
    { return Arrays.asList(list).contains(value); }
    
}
