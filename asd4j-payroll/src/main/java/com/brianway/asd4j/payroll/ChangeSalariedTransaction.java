package com.brianway.asd4j.payroll;

/**
 * Created by brian on 17/1/3.
 */
public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
    private double salary;

    public ChangeSalariedTransaction(int employeeId, double salary) {
        super(employeeId);
        this.salary = salary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}
