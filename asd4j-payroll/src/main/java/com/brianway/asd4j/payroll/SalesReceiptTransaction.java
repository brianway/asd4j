package com.brianway.asd4j.payroll;

/**
 * Created by brian on 16/12/28.
 */
public class SalesReceiptTransaction implements Transaction {
    private long date;
    private double amount;
    private int employeeId;

    public SalesReceiptTransaction(long date, double amount, int employeeId) {
        this.date = date;
        this.amount = amount;
        this.employeeId = employeeId;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        if (e == null) {
            throw new RuntimeException("No such employee");
        }

        PaymentClassification pc = e.getClassification();
        if (pc instanceof CommissionedClassification) {
            CommissionedClassification cc = (CommissionedClassification) pc;
            cc.addSalesReceipt(new SalesReceipt(date, amount));
        } else {
            throw new RuntimeException("Tried to add salesReceipt to non-commissioned employee");
        }

    }
}
