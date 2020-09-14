package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;

        year = getTime(new TimeDate(0,4,2000, 2012, "Year"));

        month = getTime(new TimeDate(5,7,1, 12, "Month"));

        date = getTime(new TimeDate(8,10,1, 31, "Date"));

        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
            minute = 0;
        } else {
            hour = getTime(new TimeDate(11, 13, 0, 23, "Hour"));

            minute = getTime(new TimeDate(14, 16, 0, 59, "Minute"));

        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private int getTime(TimeDate timeDate) {
        int year;
        try {
            String yearString = dateAndTimeString.substring(timeDate.getStart(), timeDate.getEnd());
            year = Integer.parseInt(yearString);
        } catch (StringIndexOutOfBoundsException e) {
            String StringIndexOutOfBoundsException = timeDate.getType() + " string is less than " + (timeDate.getEnd()-timeDate.getStart()) + " characters";
            throw new IllegalArgumentException(StringIndexOutOfBoundsException);
        } catch (NumberFormatException e) {
            String NumberFormatException = timeDate.getType() + " is not an integer";
            throw new IllegalArgumentException(NumberFormatException);
        }
        if (year < timeDate.getMin() || year > timeDate.getMax())
            throw new IllegalArgumentException(timeDate.getType() + " cannot be less than " + timeDate.getMin() + " or more than " + timeDate.getMax());
        return year;
    }
}
