package com.brianway.asd4j.payroll;

/**
 * Created by brian on 17/1/3.
 */
public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {
    private double salary;
    private double commissionRate;

    public ChangeCommissionedTransaction(int employeeId, double salary, double commissionRate) {
        super(employeeId);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }

}
