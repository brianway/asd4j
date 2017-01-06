package com.brianway.asd4j.payroll.transaction.impl;

import com.brianway.asd4j.payroll.db.PayrollDatabase;
import com.brianway.asd4j.payroll.domain.Transaction;

/**
 * Created by brian on 16/12/27.
 */
public class DeleteEmployeeTransaction implements Transaction {
    private int employeeId;

    public DeleteEmployeeTransaction(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public void execute() {
        PayrollDatabase.getPayrollDatabase().deleteEmployee(employeeId);
    }
}
