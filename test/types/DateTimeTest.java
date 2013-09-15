/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import java.io.Console;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class DateTimeTest {
    
    public DateTimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDays method, of class DateTime.
     */
    @Test
    public void testAddDays()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("addDays()");
        Date _currentDate = DateTime.now();
        Date _twoMonthsAfter = DateTime.addDays(_currentDate, 60);
        Date _twoMonthsBefore = DateTime.addDays(_currentDate, -60);
        System.out.println(_twoMonthsBefore.toString() + "\n" + _twoMonthsAfter.toString()); 
    }
    
    /**
     * Test of addMilliseconds method, of class DateTime.
     */
    @Test
    public void testAddMilliSeconds()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("addMilliseconds()");
        Date _currentDate = DateTime.now();
        Date _tenMinutesAfter = DateTime.addMilliseconds(_currentDate, (10 * (60 * 1000)));
        Date _tenMinutesBefore = DateTime.addMilliseconds(_currentDate, (-10 * (60 * 1000)));
        System.out.println(_tenMinutesBefore.toString() + "\n" + _tenMinutesAfter.toString()); 
    }
    
    /**
     * Test of addMinutes method, of class DateTime.
     */
    @Test
    public void testAddMinutes()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("addMinutes()");
        Date _currentDate = DateTime.now();
        Date _tenMinutesAfter = DateTime.addMinutes(_currentDate, 10);
        Date _tenMinutesBefore = DateTime.addMinutes(_currentDate, -10);
        System.out.println(_tenMinutesBefore.toString() + "\n" + _tenMinutesAfter.toString()); 
    }
    
    /**
     * Test of addMonths method, of class DateTime.
     */
    @Test
    public void testAddMonths()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("addMonths()");
        Date _currentDate = DateTime.now();
        Date _twoMonthsAfter = DateTime.addMonths(_currentDate, 2);
        Date _twoMonthsBefore = DateTime.addMonths(_currentDate, -2);
        System.out.println(_twoMonthsBefore.toString() + "\n" + _twoMonthsAfter.toString()); 
    }
    
    /**
     * Test of addSeconds method, of class DateTime.
     */
    @Test
    public void testAddSeconds()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("addSeconds()");
        Date _currentDate = DateTime.now();
        Date _twoMinutesAfter = DateTime.addSeconds(_currentDate, 120);
        Date _twoMinutesBefore = DateTime.addSeconds(_currentDate, -120);
        System.out.println(_twoMinutesBefore.toString() + "\n" + _twoMinutesAfter.toString()); 
    }
    
    /**
     * Test of addWeeks method, of class DateTime.
     */
    @Test
    public void testAddWeeks()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("addWeeks()");
        Date _currentDate = DateTime.now();
        Date _twoWeeksAfter = DateTime.addWeeks(_currentDate, 2);
        Date _twoWeeksBefore = DateTime.addWeeks(_currentDate, -2);
        System.out.println(_twoWeeksBefore.toString() + "\n" + _twoWeeksAfter.toString());
    }
    
    /**
     * Test of addYears method, of class DateTime.
     */
    @Test
    public void testAddYears()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("addYears()");
        Date _currentDate = DateTime.now();
        Date _twoYearsAfter = DateTime.addYears(_currentDate, 2);
        Date _twoYearsBefore = DateTime.addYears(_currentDate, -2);
        System.out.println(_twoYearsBefore.toString() + "\n" + _twoYearsAfter.toString());
    }
    
    /**
     * Test of between method, of class DateTime.
     */
    @Test
    public void testBetween()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("between()");
        Date _current = DateTime.date();
        Date _range1 = DateTime.addYears(_current, -1);
        Date _range2 = DateTime.addYears(_current, 1);
        boolean result = DateTime.between(_current, _range1, _range2);
        if (!result) fail("Something's wrong");
    }
    
    /**
     * Test of date method, of class DateTime.
     */
    @Test
    public void testDate()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("date()");
        Date result = DateTime.date();
        System.out.println(result.toString());
    }
    
    /**
     * Test of diff method, of class DateTime.
     */
    @Test
    public void TestDiffDays()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("diff(DateInterval.Days)");
        long expectedResult = 5;
        
        Date _date1 = DateTime.date();
        Date _date2 = DateTime.addDays(_date1, Converter.toInt(expectedResult));
        
        long result = DateTime.diff(DateTime.DateInterval.Days, _date1, _date2);
        
        if (result != expectedResult) fail("Something's wrong.");
    }
    
    /**
     * Test of diff method, of class DateTime.
     */
    @Test
    public void TestDiffMilliseconds()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("diff(DateInterval.Milliseconds)");
        long expectedResult = 3000;
        
        Date _date1 = DateTime.date();
        Date _date2 = DateTime.addMilliseconds(_date1, Converter.toInt(expectedResult));
        
        long result = DateTime.diff(DateTime.DateInterval.Milliseconds, _date1, _date2);
        
        if (result != expectedResult) fail("Something's wrong");
    }
    
    /**
     * Test of diff method, of class DateTime.
     */
    @Test
    public void TestDiffMonths()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("diff(DateInterval.Months)");
        long expectedResult = 6;
        
        Date _date1 = DateTime.date();
        Date _date2 = DateTime.addMonths(_date1, Converter.toInt(expectedResult));
        
        long result = DateTime.diff(DateTime.DateInterval.Months, _date1, _date2);
        
        if (result != expectedResult) fail("Something's wrong");
    }
    
    /**
     * Test of diff method, of class DateTime.
     */
    @Test
    public void TestDiffSeconds()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("diff(DateInterval.Seconds)");
        long expectedResult = 180;
        
        Date _date1 = DateTime.date();
        Date _date2 = DateTime.addSeconds(_date1, Converter.toInt(expectedResult));
        
        long result = DateTime.diff(DateTime.DateInterval.Seconds, _date1, _date2);
        
        if (result != expectedResult) fail("Something's wrong");
    }
    
    /**
     * Test of diff method, of class DateTime.
     */
    @Test
    public void TestDiffWeeks()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("diff(DateInterval.Weeks)");
        long expectedResult = 7;
        
        Date _date1 = DateTime.date();
        Date _date2 = DateTime.addWeeks(_date1, Converter.toInt(expectedResult));
        
        long result = DateTime.diff(DateTime.DateInterval.Weeks, _date1, _date2);
        
        if (result != expectedResult) fail("Something's wrong");
    }
    
    /**
     * Test of diff method, of class DateTime.
     */
    @Test
    public void TestDiffYears()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("diff(DateInterval.Years)");
        long expectedResult = 10;
        
        Date _date1 = DateTime.date();
        Date _date2 = DateTime.addYears(_date1, Converter.toInt(expectedResult));
        
        long result = DateTime.diff(DateTime.DateInterval.Years, _date1, _date2);
        
        if (result != expectedResult) fail("Something's wrong");
    }
    
    /**
     * Test of now method, of class DateTime.
     */
    @Test
    public void testNow() {
        System.out.println("-----------------------------------------------");
        System.out.println("now()");
        Date result = DateTime.now();
        System.out.println(result.toString());
    }
    
    /**
     * Test of time method, of class DateTime.
     */
    @Test
    public void testTime() {
        System.out.println("-----------------------------------------------");
        System.out.println("time()");
        Time result = DateTime.time();
        System.out.println(result.toString());
    }
    
    /**
     * Test of timeStamp method, of class DateTime.
     */
    @Test
    public void testTimeStamp() {
        System.out.println("-----------------------------------------------");
        System.out.println("timeStamp()");
        Timestamp result = DateTime.timeStamp();
        System.out.println(result.toString());
    }
          
}