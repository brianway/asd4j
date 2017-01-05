package com.brianway.asd4j.payroll;

import static java.util.Calendar.DAY_OF_MONTH;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by brian on 16/12/27.
 */
public class MonthlySchedule implements PaymentSchedule {
    @Override
    public boolean isPayday(Date payDate) {
        return isLastDayOfMonth(payDate);
    }

    @Override
    public Date getPayPeriodStartDate(Date payDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(payDate);
        cal.set(DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    private boolean isLastDayOfMonth(final Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(DAY_OF_MONTH);
        int maxDay = cal.getActualMaximum(DAY_OF_MONTH);
        return day == maxDay;
    }

}
