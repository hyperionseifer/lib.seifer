/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Seph
 */
public class DateTime {
    
    public enum DateInterval 
    {
        Days,
        Milliseconds,
        Months,
        Seconds,
        Weeks,
        Years
    }
    
    public final static long SECOND_MILLIS = 1000;
    public final static long MINUTE_MILLIS = SECOND_MILLIS * 60;
    public final static long HOUR_MILLIS = MINUTE_MILLIS * 60;
    public final static long DAY_MILLIS = HOUR_MILLIS * 24;
    public final static long YEAR_MILLIS = DAY_MILLIS * 365;

    public static DateFormat OUT_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public static DateFormat OUT_TIME_FORMAT = new SimpleDateFormat("H:mm:ss");
    public static DateFormat OUT_DATETIME_FORMAT = new SimpleDateFormat("d/M/yyyy H:mm:ss");
    public static DateFormat OUT_TIMESTAMP_FORMAT = new SimpleDateFormat("d/M/yy H:mm:ss.SSS");
    
    public static DateFormat IN_DATE_FORMAT = new SimpleDateFormat("d/M/yy");
    public static DateFormat IN_TIME_FORMAT = new SimpleDateFormat("H:mm:ss");
    public static DateFormat IN_DATETIME_FORMAT = new SimpleDateFormat("d/M/yy H:mm:ss");
    public static DateFormat IN_TIMESTAMP_FORMAT = new SimpleDateFormat("d/M/yy H:mm:ss.SSS");
    
    public static DateFormat DATE_TIME_FORMAT = new SimpleDateFormat( "yyyyMMddkkmmss" );  

    public static Calendar calendar = new GregorianCalendar();

    static
    {
        IN_DATE_FORMAT.setLenient(false);
        IN_TIME_FORMAT.setLenient(false);
        IN_DATETIME_FORMAT.setLenient(false);
    }
    
    /***
     * Adds the specified days into the supplied date and returns it afterwards.
     * @param value Date to be added.
     * @param days Days to be added. Negative value will deduct days from the specified date.
     * @return Result date from the additional days.
     */
    public static Date addDays(Date value, int days)
    { return addTime(value, Calendar.DATE, days); }
    
    /**
     * Adds the specified milliseconds into the supplied date and returns it afterwards.
     * @param value Date to be added.
     * @param milliseconds Milliseconds to be added. Negative value will deduct milliseconds from the specified date.
     * @return Result date from the additional milliseconds.
     */
    public static Date addMilliseconds(Date value, int milliseconds)
    { return addTime(value, Calendar.MILLISECOND, milliseconds); }
    
    /**
     * Adds the specified minutes into the supplied date and returns it afterwards.
     * @param value Date to be added.
     * @param minutes Minutes to be added. Negative value will deduct minutes from the specified date.
     * @return Result date from the additional minutes.
     */
    public static Date addMinutes(Date value, int minutes)
    { return addTime(value, Calendar.MINUTE, minutes); }
    
    /**
     * Adds the specified months into the supplied date and returns it afterwards.
     * @param value Date to be added.
     * @param months Months to be added. Negative value will deduct months from the specified date.
     * @return Result date from the additional months.
     */
    public static Date addMonths(Date value, int months)
    { return addTime(value, Calendar.MONTH, months); }
    
    /**
     * Adds the specified seconds into the supplied date and returns it afterwards.
     * @param value Date to be added.
     * @param seconds Seconds to be added. Negative value will deduct seconds from the specified date.
     * @return Result date from the additional seconds.
     */
    public static Date addSeconds(Date value, int seconds)
    { return addTime(value, Calendar.SECOND, seconds); }
    
    private static Date addTime(Date value, int unit, int additional)
    {
        GregorianCalendar _calendar = new GregorianCalendar();
        _calendar.setTime(value);
        _calendar.add(unit, additional);
        return new Date(_calendar.getTime().getTime());
    }
    
    /**
     * Adds the specified weeks into the supplied date and returns it afterwards.
     * @param value Date to be added.
     * @param weeks Weeks to be added. Negative value will deduct weeks from the specified date.
     * @return Result date from the additional weeks.
     */
    public static Date addWeeks(Date value, int weeks)
    { return addTime(value, Calendar.DATE, weeks * 7); }
    
    /**
     * Adds the specified years into the supplied date and returns it afterwards.
     * @param value Date to be added.
     * @param years Years to be added. Negative value will deduct years from the specified date.
     * @return Result date from the additional years.
     */
    public static Date addYears(Date value, int years)
    { return addTime(value, Calendar.YEAR, years); }
    
    /**
     * Determines whether the specified date is between the given range dates.
     * @param value Date to validate
     * @param fromDate Starting range
     * @param toDate Ending range
     * @return True if the specified date is within the given date ranges, otherwise false.
     */
    public static boolean between(Date value, Date fromDate, Date toDate)
    {
        return ((value.equals(fromDate) ||
                 value.equals(toDate)) ||
                (fromDate.before(value) &&
                 toDate.after(value)));
    }
    
    /**
     * Gets the current date.
     * @return Current date.
     */
    public static Date date()
    { 
        Date _date = new Date((System.currentTimeMillis() / DAY_MILLIS) * DAY_MILLIS);
        SimpleDateFormat _formatter = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date _outputDate = _date;
            _date = _formatter.parse(_formatter.format(_outputDate)); 
        }
        catch (ParseException ex) 
        { ex.toString(); }
        
        return _date;    
    }
    
    /**
     * Computes the difference of one date to the other.
     * @param interval Date and time unit
     * @param date1 First date (usually the earlier date).
     * @param date2 Second date (usually the later date).
     * @return Difference within the two dates.
     */
    public static long diff(DateInterval interval, Date date1, Date date2)
    {
        long _result = -1;
        
        if (interval == DateInterval.Days) _result = (date2.getTime() / DAY_MILLIS) - (date1.getTime() / DAY_MILLIS);
        else if (interval == DateInterval.Milliseconds) _result = date2.getTime() - date1.getTime();
        else if (interval == DateInterval.Months) _result = (date2.getTime() / (DAY_MILLIS * 30)) - (date1.getTime() / (DAY_MILLIS * 30));
        else if (interval == DateInterval.Seconds) _result = (date2.getTime() / SECOND_MILLIS) - (date1.getTime() / SECOND_MILLIS);
        else if (interval == DateInterval.Weeks) _result = (date2.getTime() / (DAY_MILLIS * 7)) - (date1.getTime() / (DAY_MILLIS * 7));
        else if (interval == DateInterval.Years) _result = (date2.getTime() / YEAR_MILLIS) - (date1.getTime() / YEAR_MILLIS);
        else { }
        
        return _result;
    }
    
    /**
     * Gets the current date and time.
     * @return Current date and time.
     */
    public static Date now()
    { return new Date((System.currentTimeMillis() / SECOND_MILLIS) * SECOND_MILLIS); }
    
    /**
     * Gets the time part of the current date and time.
     * @return Time part of the current date and time.
     */
    public static Time time()
    { return new Time(System.currentTimeMillis() % DAY_MILLIS); }
    
    /**
     * Gets the current time stamp.
     * @return Current time stamp.
     */
    public static Timestamp timeStamp()
    { return new Timestamp(System.currentTimeMillis()); }
    
}
