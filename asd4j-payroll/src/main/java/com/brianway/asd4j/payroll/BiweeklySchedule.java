package com.brianway.asd4j.payroll;

import java.util.Date;

/**
 * Created by brian on 16/12/27.
 */
public class BiweeklySchedule implements PaymentSchedule {
    @Override
    public boolean isPayday(Date payDate) {
        return false;
    }

    @Override
    public Date getPayPeriodStartDate(Date payDate) {
        return null;
    }
}
