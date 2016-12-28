package com.brianway.asd4j.payroll;

/**
 * Created by brian on 16/12/28.
 */
public class ServiceCharge {
    private long date;
    private double amount;

    public ServiceCharge(long date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public long getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
