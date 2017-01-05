package com.brianway.asd4j.payroll;

import java.util.Date;

/**
 * Created by brian on 16/12/27.
 */
public abstract class PaymentClassification {
    public abstract double calculatePay(Paycheck pc);

    protected boolean isInPayPeriod(Date date, Paycheck pc) {
        //TODO
        return false;
    }
}
