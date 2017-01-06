package com.brianway.asd4j.payroll.transaction.impl;

import com.brianway.asd4j.payroll.domain.PaymentClassification;
import com.brianway.asd4j.payroll.domain.PaymentSchedule;
import com.brianway.asd4j.payroll.impl.HourlyClassification;
import com.brianway.asd4j.payroll.impl.WeeklySchedule;
import com.brianway.asd4j.payroll.transaction.AddEmployeeTransaction;

/**
 * Created by brian on 16/12/27.
 */
public class AddHourlyEmployee extends AddEmployeeTransaction {
    private double hourlyRate;

    public AddHourlyEmployee(int id, String name, String address, double hourlyRate) {
        super(id, name, address);
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
