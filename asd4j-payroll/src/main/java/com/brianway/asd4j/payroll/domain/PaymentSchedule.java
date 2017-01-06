package com.brianway.asd4j.payroll.domain;

import java.util.Date;

/**
 * Created by brian on 16/12/27.
 */
public interface PaymentSchedule {
    boolean isPayday(Date payDate);
    Date getPayPeriodStartDate(Date payDate);
}
