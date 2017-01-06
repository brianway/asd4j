package com.brianway.asd4j.payroll.impl;

import com.brianway.asd4j.payroll.domain.Paycheck;
import com.brianway.asd4j.payroll.domain.PaymentClassification;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by brian on 16/12/27.
 */
public class HourlyClassification extends PaymentClassification {
    private double hourlyRate;
    private final Map<Date, TimeCard> timeCards = new HashMap<Date, TimeCard>();

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void addTimeCard(TimeCard timeCard) {
        timeCards.put(timeCard.getDate(), timeCard);
    }

    public TimeCard getTimeCard(Date date) {
        return timeCards.get(date);
    }

    public double getRate() {
        return hourlyRate;
    }

    public void setRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePay(Paycheck pc) {
        double totalPay = 0.0;
        for (TimeCard tc : timeCards.values()) {
            if (isInPayPeriod(tc.getDate(), pc)) {
                totalPay += calculatePayForTimeCard(tc);
            }
        }
        return totalPay;
    }

    private double calculatePayForTimeCard(TimeCard tc) {
        double hours = tc.getHours();
        double overtime = hours > 8 ? hours - 8 : 0;
        double baseTime = hours - overtime;
        return baseTime * hourlyRate + overtime * hourlyRate * 1.5;
    }

}
