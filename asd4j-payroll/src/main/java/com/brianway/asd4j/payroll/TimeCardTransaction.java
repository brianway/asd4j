package com.brianway.asd4j.payroll;

import java.util.Date;

/**
 * Created by brian on 16/12/27.
 */
public class TimeCardTransaction implements Transaction {
    private int employeeId;
    private Date date;
    private double hours;

    public TimeCardTransaction(long date, double hours, int employeeId) {
        this.hours = hours;
        this.date = new Date(date);
        this.employeeId = employeeId;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        if (e == null) {
            throw new RuntimeException("No such employee");
        }

        PaymentClassification pc = e.getClassification();
        if (pc instanceof HourlyClassification) {
            HourlyClassification hc = (HourlyClassification) pc;
            hc.addTimeCard(new TimeCard(date.getTime(), hours));
        } else {
            throw new RuntimeException("Tried to add timecard to non-hourly employee");
        }

    }
}
