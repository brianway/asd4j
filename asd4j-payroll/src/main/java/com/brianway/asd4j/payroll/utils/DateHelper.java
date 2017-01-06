package com.brianway.asd4j.payroll.utils;

import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_WEEK;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by brian on 17/1/5.
 */
public class DateHelper {
    public static int dayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(DAY_OF_WEEK);
    }

    public static Date subtractDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(DATE, -days);
        return cal.getTime();
    }

    public static boolean isBetween(Date date, Date startDate, Date endDate) {
        return !date.before(startDate) && !date.after(endDate);
    }
}
