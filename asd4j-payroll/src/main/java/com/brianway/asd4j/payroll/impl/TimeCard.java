package com.brianway.asd4j.payroll.impl;

import java.util.Date;

/**
 * Created by brian on 16/12/27.
 */
public class TimeCard {
    private Date date;
    double hours;

    public TimeCard(long date, double hours) {
        this.date = new Date(date);
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public double getHours() {
        return hours;
    }
}
