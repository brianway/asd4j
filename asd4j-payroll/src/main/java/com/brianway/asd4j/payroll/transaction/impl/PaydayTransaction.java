package com.brianway.asd4j.payroll.transaction.impl;

import com.brianway.asd4j.payroll.domain.Paycheck;
import com.brianway.asd4j.payroll.db.PayrollDatabase;
import com.brianway.asd4j.payroll.domain.Employee;
import com.brianway.asd4j.payroll.domain.Transaction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brian on 17/1/4.
 */
public class PaydayTransaction implements Transaction {
    private final Map<Integer, Paycheck> paychecks = new HashMap<Integer, Paycheck>();
    private final Date payDate;

    public PaydayTransaction(Date payDate) {
        this.payDate = payDate;
    }

    @Override
    public void execute() {
        List<Integer> employeeIds = PayrollDatabase.getPayrollDatabase().getEmployeeIds();
        for (int employeeId : employeeIds) {
            Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
            if (e.isPayday(payDate)) {
                Paycheck pc = new Paycheck(e.getPayPeriodStartDate(payDate), payDate);
                paychecks.put(employeeId, pc);
                e.payDay(pc);
            }
        }
    }

    public Paycheck getPaycheck(int employeeId) {
        return paychecks.get(employeeId);
    }
}
