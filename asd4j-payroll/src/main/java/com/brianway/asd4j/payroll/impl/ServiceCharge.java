package com.brianway.asd4j.payroll.impl;

import java.util.Date;

/**
 * Created by brian on 16/12/28.
 */
public class ServiceCharge {
    private Date date;
    private double amount;

    public ServiceCharge(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
