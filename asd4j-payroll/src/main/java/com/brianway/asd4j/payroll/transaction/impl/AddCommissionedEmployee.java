package com.brianway.asd4j.payroll.transaction.impl;

import com.brianway.asd4j.payroll.domain.PaymentClassification;
import com.brianway.asd4j.payroll.domain.PaymentSchedule;
import com.brianway.asd4j.payroll.impl.BiweeklySchedule;
import com.brianway.asd4j.payroll.impl.CommissionedClassification;
import com.brianway.asd4j.payroll.transaction.AddEmployeeTransaction;

/**
 * Created by brian on 16/12/27.
 */
public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private double salary;
    private double commissionRate;

    public AddCommissionedEmployee(int id, String name, String address, double salary, double commissionRate) {
        super(id, name, address);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }
}
