package com.brianway.asd4j.payroll.impl;

import com.brianway.asd4j.payroll.utils.DateHelper;
import com.brianway.asd4j.payroll.domain.PaymentSchedule;
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
