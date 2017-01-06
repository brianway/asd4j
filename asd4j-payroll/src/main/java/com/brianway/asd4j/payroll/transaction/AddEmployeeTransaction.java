package com.brianway.asd4j.payroll.transaction;

import com.brianway.asd4j.payroll.db.PayrollDatabase;
import com.brianway.asd4j.payroll.domain.Employee;
import com.brianway.asd4j.payroll.domain.PaymentClassification;
import com.brianway.asd4j.payroll.domain.PaymentMethod;
import com.brianway.asd4j.payroll.domain.PaymentSchedule;
import com.brianway.asd4j.payroll.domain.Transaction;
import com.brianway.asd4j.payroll.impl.HoldMethod;

/**
 * Created by brian on 16/12/27.
 */
public abstract class AddEmployeeTransaction implements Transaction {
    private int id;
    private String name;
    private String address;

    public AddEmployeeTransaction(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();

    @Override
    public void execute() {
        PaymentClassification pc = getClassification();
        PaymentSchedule ps = getSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee employee = new Employee(id, name, address);
        employee.setClassification(pc);
        employee.setSchedule(ps);
        employee.setMethod(pm);
        PayrollDatabase.getPayrollDatabase().addEmployee(id, employee);
    }
}
