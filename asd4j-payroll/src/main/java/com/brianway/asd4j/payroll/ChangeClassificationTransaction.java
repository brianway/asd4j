package com.brianway.asd4j.payroll;

/**
 * Created by brian on 17/1/3.
 */
public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {
    public ChangeClassificationTransaction(int employeeId) {
        super(employeeId);
    }

    @Override
    public void change(Employee employee) {
        employee.setClassification(getClassification());
        employee.setSchedule(getSchedule());
    }

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();
}
