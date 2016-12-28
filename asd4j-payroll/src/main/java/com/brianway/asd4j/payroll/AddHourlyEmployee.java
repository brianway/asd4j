package com.brianway.asd4j.payroll;

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
    PaymentClassification getClassification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}
