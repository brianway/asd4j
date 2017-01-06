package com.brianway.asd4j.payroll.transaction.impl;

import com.brianway.asd4j.payroll.db.PayrollDatabase;
import com.brianway.asd4j.payroll.impl.SalesReceipt;
import com.brianway.asd4j.payroll.domain.Employee;
import com.brianway.asd4j.payroll.domain.PaymentClassification;
import com.brianway.asd4j.payroll.domain.Transaction;
import com.brianway.asd4j.payroll.impl.CommissionedClassification;

import java.util.Date;

/**
 * Created by brian on 16/12/28.
 */
public class SalesReceiptTransaction implements Transaction {
    private Date date;
    private double amount;
    private int employeeId;

    public SalesReceiptTransaction(Date date, double amount, int employeeId) {
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
