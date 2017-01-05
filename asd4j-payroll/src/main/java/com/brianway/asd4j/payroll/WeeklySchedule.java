package com.brianway.asd4j.payroll;

import static java.util.Calendar.FRIDAY;

import java.util.Date;

/**
 * Created by brian on 16/12/27.
 */
public class WeeklySchedule implements PaymentSchedule {
    @Override
    public Date getPayPeriodStartDate(Date payDate) {
        return DateHelper.subtractDays(payDate, 6);
    }

    @Override
    public boolean isPayday(Date payDate) {
        return DateHelper.dayOfWeek(payDate) == FRIDAY;
    }
}
