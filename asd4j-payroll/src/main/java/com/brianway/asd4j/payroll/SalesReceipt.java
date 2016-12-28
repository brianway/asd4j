package com.brianway.asd4j.payroll;

/**
 * Created by brian on 16/12/28.
 */
public class SalesReceipt {
    private long date;
    private double amount;

    public SalesReceipt(long date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
