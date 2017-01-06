package com.brianway.asd4j.payroll;

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
