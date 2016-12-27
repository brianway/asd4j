package com.brianway.asd4j.payroll;

/**
 * Created by brian on 16/12/27.
 */
public class AddSalariedEmployee extends AddEmployeeTransaction {
    private double salary;

    @Override
    PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }

    public AddSalariedEmployee(int id, String name, String address, double salary) {
        super(id, name, address);
        this.salary = salary;
    }
}
