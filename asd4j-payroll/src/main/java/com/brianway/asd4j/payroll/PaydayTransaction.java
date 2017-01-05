package com.brianway.asd4j.payroll;

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
                Paycheck pc = new Paycheck(payDate);
                paychecks.put(employeeId, pc);
                e.payDay(pc);
            }
        }
    }
}
