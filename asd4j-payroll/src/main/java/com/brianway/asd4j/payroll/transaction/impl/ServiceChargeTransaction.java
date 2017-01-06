package com.brianway.asd4j.payroll.transaction.impl;

import com.brianway.asd4j.payroll.db.PayrollDatabase;
import com.brianway.asd4j.payroll.impl.ServiceCharge;
import com.brianway.asd4j.payroll.impl.UnionAffiliation;
import com.brianway.asd4j.payroll.domain.Affiliation;
import com.brianway.asd4j.payroll.domain.Employee;
import com.brianway.asd4j.payroll.domain.Transaction;

import java.util.Date;

/**
 * Created by brian on 16/12/28.
 */
public class ServiceChargeTransaction implements Transaction {
    private Date date;
    private double amount;
    private int memberId;

    public ServiceChargeTransaction(int memberId, Date date, double amount) {
        this.date = date;
        this.amount = amount;
        this.memberId = memberId;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getPayrollDatabase().getUnionMember(memberId);
        if (e == null) {
            throw new RuntimeException("No such employee");
        }
        Affiliation affiliation = e.getAffiliation();

        if (affiliation instanceof UnionAffiliation) {
            ServiceCharge sc = new ServiceCharge(date, amount);
            ((UnionAffiliation) affiliation).addServiceCharge(sc);
        }
    }

}
