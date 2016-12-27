package com.brianway.asd4j.payroll;

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

    abstract PaymentClassification getClassification();

    abstract PaymentSchedule getSchedule();

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
