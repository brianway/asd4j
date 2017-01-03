package com.brianway.asd4j.payroll;

/**
 * Created by brian on 16/12/28.
 */
public class ChangeNameTransaction extends ChangeEmployeeTransaction {
    private String name;

    public ChangeNameTransaction(int employeeId, String name) {
        super(employeeId);
        this.name = name;
    }

    @Override
    public void change(Employee e) {
        e.setName(name);
    }

}
