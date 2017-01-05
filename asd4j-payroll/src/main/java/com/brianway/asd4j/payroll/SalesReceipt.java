package com.brianway.asd4j.payroll;

import java.util.Date;

/**
 * Created by brian on 16/12/28.
 */
public class SalesReceipt {
    private Date date;
    private double amount;

    public SalesReceipt(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
