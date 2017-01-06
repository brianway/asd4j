package com.brianway.asd4j.payroll.transaction.impl;

import com.brianway.asd4j.payroll.domain.PaymentClassification;
import com.brianway.asd4j.payroll.domain.PaymentSchedule;
import com.brianway.asd4j.payroll.impl.BiweeklySchedule;
import com.brianway.asd4j.payroll.impl.CommissionedClassification;
import com.brianway.asd4j.payroll.transaction.ChangeClassificationTransaction;

/**
 * Created by brian on 17/1/3.
 */
public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {
    private double salary;
    private double commissionRate;

    public ChangeCommissionedTransaction(int employeeId, double salary, double commissionRate) {
        super(employeeId);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }

}
