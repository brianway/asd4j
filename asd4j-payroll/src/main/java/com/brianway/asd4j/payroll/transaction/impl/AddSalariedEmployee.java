package com.brianway.asd4j.payroll.transaction.impl;

import com.brianway.asd4j.payroll.domain.PaymentClassification;
import com.brianway.asd4j.payroll.domain.PaymentSchedule;
import com.brianway.asd4j.payroll.impl.MonthlySchedule;
import com.brianway.asd4j.payroll.impl.SalariedClassification;
import com.brianway.asd4j.payroll.transaction.AddEmployeeTransaction;

/**
 * Created by brian on 16/12/27.
 */
public class AddSalariedEmployee extends AddEmployeeTransaction {
    private double salary;

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }

    public AddSalariedEmployee(int id, String name, String address, double salary) {
        super(id, name, address);
        this.salary = salary;
    }
}
