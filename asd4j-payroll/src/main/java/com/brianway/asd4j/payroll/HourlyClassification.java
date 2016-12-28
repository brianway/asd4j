package com.brianway.asd4j.payroll;

import java.util.Date;

/**
 * Created by brian on 16/12/27.
 */
public class HourlyClassification extends PaymentClassification {
    private double hourlyRate;
    private TimeCard timeCard;

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void addTimeCard(TimeCard timeCard) {
        //TODO add
        this.timeCard = timeCard;
    }

    public TimeCard getTimeCard(Date date) {
        //TODO get
        return timeCard;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
