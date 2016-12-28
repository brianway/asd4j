package com.brianway.asd4j.payroll;

/**
 * Created by brian on 16/12/27.
 */
public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private double salary;
    private double commissionRate;

    public AddCommissionedEmployee(int id, String name, String address, double salary, double commissionRate) {
        super(id, name, address);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    PaymentClassification getClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }

    @Override
    PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }
}
