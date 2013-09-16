/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import java.sql.Time;
import java.sql.Timestamp;
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
     * Gets the day of week name for the current date.
     * @return Day of week name for the current date
     */
    public static String getDayName()
    { return getDayName(false); }
    
    /**
     * Gets the day of week name for the current date.
     * @param abbreviate Determines whether to abbreviate returning value or not.
     * @return Day of week name for the current date
     */
    public static String getDayName(boolean abbreviate)
    { return getDayName(date(), abbreviate); }
    
    /**
     * Gets the day of week name for the specified date.
     * @param value Date to evaluate
     * @return Day of week name for the specified date
     */
    public static String getDayName(Date value)
    { return getDayName(value, false); }
    
    /**
     * Gets the day of week name for the specified date.
     * @param value Date to evaluate
     * @param abbreviate Determines whether to abbreviate returning value or not.
     * @return Day of week name for the specified date
     */
    public static String getDayName(Date value, boolean abbreviate)
    {
        String _dayName = "";
       
        _dayName = getDayName(getDayOfWeek(value), abbreviate);
        
        return _dayName;
    }
    
    /**
     * Gets the day of week name.
     * @param dayofweek Day of the week (basically 1-7; where Sunday is 1)
     * @return Day of week name
     */
    public static String getDayName(int dayofweek)
    { return getDayName(dayofweek, false); }
    
    /**
     * Gets the day of week name.
     * @param dayofweek Day of the week (basically 1-7; where Sunday is 1)
     * @param abbreviate Determines whether to abbreviate returning value or not.
     * @return Day of week name
     */
    public static String getDayName(int dayofweek, boolean abbreviate)
    {
        String _dayName = "";
        
        String[] _dayNames = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday",
                                            "Thursday", "Friday", "Saturday" };
        
        if (abbreviate) _dayName = _dayNames[dayofweek - 1].substring(0, 3);
        else _dayName =  _dayNames[dayofweek - 1];
        
        return _dayName;
    }

    /**
     * Gets the day of month for the current date.
     * @return Day of the month (basically between the first and last day of the calendar month).
     */
    public static int getDayOfMonth()
    { return getDayOfMonth(date()); }
    
    /**
     * Gets the day of month for the specified date.
     * @param value Date to evaluate
     * @return Day of the month (basically between the first and last day of the calendar month).
     */
    public static int getDayOfMonth(Date value)
    {
        int _day = 1;
        
        Calendar _calendar = Calendar.getInstance();
        _calendar.setTime(value);
        _day = _calendar.get(Calendar.DAY_OF_MONTH);
        
        return _day;
    }
    
    /**
     * Gets the week day of the current date.
     * @return Day of the week (basically 1-7 where Sunday is 1).
     */
    public static int getDayOfWeek()
    { return getDayOfWeek(date()); }
    
    /**
     * Gets the week day of the specified date.
     * @param value Date value to evaluate
     * @return Day of the week (basically 1-7 where Sunday is 1).
     */
    public static int getDayOfWeek(Date value)
    {
        int _dayOfWeek = 1;
        
        Calendar _calendar = Calendar.getInstance();
        _calendar.setTime(value);
        _dayOfWeek = _calendar.get(Calendar.DAY_OF_WEEK);
        
        return _dayOfWeek;
    }

    /**
     * Gets the current date's day in the year.
     * @return Day in the year (basically 1-365 where January 1 is 1).
     */
    public static int getDayOfYear()
    { return getDayOfYear(date()); }
    
    /**
     * Gets the specified date's day in the year.
     * @param value Date to evaluate
     * @return Day in the year (basically 1-365 where January 1 is 1).
     */
    public static int getDayOfYear(Date value)
    {
        int _day = 1;
        
        Calendar _calendar = Calendar.getInstance();
        _calendar.setTime(value);
        _day = _calendar.get(Calendar.DAY_OF_YEAR);
        
        return _day;
    }
    
    /**
     * Gets the month of the current date.
     * @return Month of the year (basically 1-12 where January is 1).
     */
    public static int getMonth()
    { return getMonth(date()); }
    
    /**
     * Gets the month of the specified date.
     * @param value Date to evaluate
     * @return Month of the year (basically 1-12 where January is 1).
     */
    public static int getMonth(Date value)
    {
        int _month = 1;
        
        Calendar _calendar = Calendar.getInstance();
        _calendar.setTime(value);
        _month = _calendar.get(Calendar.MONTH) + 1;
        
        return _month;
    }
    
    /**
     * Gets the month name of the current date.
     * @return Month name of the current date
     */
    public static String getMonthName()
    { return getMonthName(false); }
    
    /**
     * Gets the month name of the current date.
     * @param abbreviate Determines whether to return abbreviated value of the month or not.
     * @return Month name of the current date
     */
    public static String getMonthName(boolean abbreviate)
    { return getMonthName(date(), abbreviate); }
    
    /**
     * Gets the month name of the specified date.
     * @param value Date value to evaluate
     * @return Month name of the specified date
     */
    public static String getMonthName(Date value)
    { return getMonthName(value, false); }
    
    /**
     * Gets the month name of the specified date.
     * @param value Date value to evaluate
     * @param abbreviate Determines whether to return abbreviated value of the month or not.
     * @return Month name of the specified date
     */
    public static String getMonthName(Date value, boolean abbreviate)
    {
        String _monthName = "";
        
        _monthName = getMonthName(getMonth(value), abbreviate);
        
        return _monthName;
    }
    
    /**
     * Gets the month name through the given month of the year
     * @param month Month of the year (basically 1 to 12 where January is 1).
     * @return Month name
     */
    public static String getMonthName(int month)
    { return getMonthName(month, false); }
    
    /**
     * Gets the month name through the given month of the year
     * @param month Month of the year (basically 1 to 12 where January is 1).
     * @param abbreviate Determines whether to return abbreviated value of the month or not.
     * @return Month name
     */
    public static String getMonthName(int month, boolean  abbreviate)
    {
        String _monthName = "";
        
        String[] _monthNames = new String[] { "January", "February", "March", "April", "May",
                                              "June", "July", "August", "September", "October",
                                              "November", "December" };
        
        if (abbreviate) _monthName = _monthNames[month - 1].substring(0, 3);
        else _monthName = _monthNames[month - 1];
        
        return _monthName;
    }
    
    /**
     * Gets the current date's week of the month.
     * @return Week number of the month (basically 1-4 at most).
     */
    public static int getWeekOfMonth()
    { return getWeekOfMonth(date()); }
    
    /**
     * Gets the specified date's week of the month.
     * @param value Date to evaluate
     * @return Week number of the month (basically 1-4 at most).
     */
    public static int getWeekOfMonth(Date value)
    {
        int _week = 1;
        
        Calendar _calendar = Calendar.getInstance();
        _calendar.setTime(value);
        _week = _calendar.get(Calendar.WEEK_OF_MONTH);
        
        return _week;
    }
    
    /**
     * Gets the current date's week in the year.
     * @return Week number within the current year.
     */
    public static int getWeekOfYear()
    { return getWeekOfYear(date()); }
    
    /**
     * Gets the specified date's week in the year.
     * @param value Date to evaluate
     * @return Week number within the current year.
     */
    public static int getWeekOfYear(Date value)
    {
        int _week = 1;
        
        Calendar _calendar = Calendar.getInstance();
        _calendar.setTime(value);
        _week = _calendar.get(Calendar.WEEK_OF_YEAR);
        
        return _week;
    }
    
    /**
     * Gets the year of the current date.
     * @return Year of the current date
     */
    public static int getYear()
    { return getYear(date()); }
    
    /**
     * Gets the year of the specified date.
     * @param value Date value to evaluate
     * @return Year of the specified date
     */
    public static int getYear(Date value)
    {
        int _year = 1900;
        
        Calendar _calendar = Calendar.getInstance();
        _calendar.setTime(value);
        _year = _calendar.get(Calendar.YEAR);
        
        return _year;
    }
    
    /**
     * Determines whether the current date is in a leap year or not.
     * @return True if the year of the current date is leap year, otherwise false.
     */
    public static boolean isLeapYear()
    { return isLeapYear(date()); }
    
    /**
     * Determines whether the specified date is in a leap year or not.
     * @param value Date to evaluate
     * @return True if the year of the specified date is leap year, otherwise false.
     */
    public static boolean isLeapYear(Date value)
    { return isLeapYear(getYear(value)); }
    
    /**
     * Determines whether the specified year is a leap year or not.
     * @param year Year to evaluate
     * @return True if the specified year is leap year, otherwise false.
     */
    public static boolean isLeapYear(int year)
    {
        if (year % 400 == 0) return true;
        else
        {
            if (year % 4 == 0) return true;
        }
        
        return false;
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
    
    /**
     * Converts the specified date into its date and time string representation.
     * @param value date value to convert
     * @return Date and time string representation of the specified date.  
     */
    public static String toLongDateString(Date value)
    { return Converter.toLongDateString(value); }
    
    /**
     * Converts the specified date into its date and time string representation.
     * @param value date value to convert
     * @return Date and time string representation of the specified date.  
     */
    public static String toLongDateString(java.sql.Date value)
    { return Converter.toLongDateString(value); }
   
    /**
     * Converts the specified date into its date and time string representation.
     * @param value date value to convert
     * @return Date and time string representation of the specified date.  
     */
    public static String toLongDateString(Timestamp value)
    { return Converter.toLongDateString(value); }
    
    /**
     * Converts the specified date into its date string representation.
     * @param value date value to convert
     * @return Date string representation of the specified date.  
     */
    public static String toShortDateString(Date value)
    { return Converter.toShortDateString(value); }
    
    /**
     * Converts the specified date into its date string representation.
     * @param value date value to convert
     * @return Date string representation of the specified date.  
     */
    public static String toShortDateString(java.sql.Date value)
    { return Converter.toShortDateString(value); }
  
    /**
     * Converts the specified date into its date string representation.
     * @param value date value to convert
     * @return Date string representation of the specified date.  
     */
    public static String toShortDateString(Timestamp value)
    { return Converter.toShortDateString(value); }
    
    /**
     * Converts the specified date into its SQL-qualified date string representation.
     * @param value Date value to convert
     * @return SQL-qualified date string representation of the specified date. 
     */
    public static String toSqlDateString(Date value)
    { return Converter.toSqlDateString(value); }
    
    /**
     * Converts the specified date into its SQL-qualified date string representation.
     * @param value Date value to convert
     * @return SQL-qualified date string representation of the specified date. 
     */
    public static String toSqlDateString(java.sql.Date value)
    { return Converter.toSqlDateString(value); }
    
    /**
     * Converts the specified date into its SQL-qualified date string representation.
     * @param value Date value to convert
     * @return SQL-qualified date string representation of the specified date. 
     */
    public static String toSqlDateString(Timestamp value)
    { return Converter.toSqlDateString(value); }
    
    /**
     * Converts the specified date into its SQL-qualified date and time string representation.
     * @param value Date value to convert
     * @return SQL-qualified date and time string representation of the specified date.
     */
    public static String toSqlDateTimeString(Date value)
    { return Converter.toSqlDateTimeString(value); }
    /**
     * Converts the specified date into its SQL-qualified date and time string representation.
     * @param value Date value to convert
     * @return SQL-qualified date and time string representation of the specified date.
     */
    public static String toSqlDateTimeString(java.sql.Date value)
    { return Converter.toSqlDateTimeString(value); }
   
    /**
     * Converts the specified date into its SQL-qualified date and time string representation.
     * @param value Date value to convert
     * @return SQL-qualified date and time string representation of the specified date.
     */
    public static String toSqlDateTimeString(Timestamp value)
    { return Converter.toSqlDateTimeString(value); }
    
}
