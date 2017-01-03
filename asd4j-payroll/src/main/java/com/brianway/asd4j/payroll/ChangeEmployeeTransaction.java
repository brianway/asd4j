package com.brianway.asd4j.payroll;

/**
 * Created by brian on 16/12/28.
 */
public abstract class ChangeEmployeeTransaction implements Transaction {
    private int employeeId;

    public ChangeEmployeeTransaction(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        if (e != null) {
            change(e);
        }
    }

    public abstract void change(Employee e);

}
