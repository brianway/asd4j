package com.brianway.asd4j.payroll.transaction.impl;

import com.brianway.asd4j.payroll.domain.PaymentClassification;
import com.brianway.asd4j.payroll.domain.PaymentSchedule;
import com.brianway.asd4j.payroll.impl.HourlyClassification;
import com.brianway.asd4j.payroll.impl.WeeklySchedule;
import com.brianway.asd4j.payroll.transaction.ChangeClassificationTransaction;

/**
 * Created by brian on 17/1/3.
 */
public class ChangeHourlyTransaction extends ChangeClassificationTransaction {

    private double hourlyRate;

    public ChangeHourlyTransaction(int employeeId, double hourlyRate) {
        super(employeeId);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}

