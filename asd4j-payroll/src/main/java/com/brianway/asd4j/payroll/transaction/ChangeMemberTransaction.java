package com.brianway.asd4j.payroll.transaction;

import com.brianway.asd4j.payroll.db.PayrollDatabase;
import com.brianway.asd4j.payroll.impl.UnionAffiliation;
import com.brianway.asd4j.payroll.domain.Affiliation;
import com.brianway.asd4j.payroll.domain.Employee;

/**
 * Created by brian on 17/1/4.
 */
public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
    private int memberId;
    private double dues;

    public ChangeMemberTransaction(int employeeId, int memberId, double dues) {
        super(employeeId);
        this.memberId = memberId;
        this.dues = dues;
    }

    @Override
    public Affiliation getAffiliation() {
        return new UnionAffiliation(memberId, dues);
    }

    @Override
    public void recordMembership(Employee e) {
        PayrollDatabase.getPayrollDatabase().addUnionMember(memberId, e);
    }
}
