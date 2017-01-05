package com.brianway.asd4j.payroll;

import java.util.Date;

/**
 * Created by brian on 16/12/27.
 */
public class WeeklySchedule implements PaymentSchedule {
    @Override
    public Date getPayPeriodStartDate(Date payDate) {
        return null;
    }

    @Override
    public boolean isPayday(Date payDate) {
        return false;
    }
}
