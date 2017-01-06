package com.brianway.asd4j.payroll.transaction.impl;

import com.brianway.asd4j.payroll.impl.NoAffiliation;
import com.brianway.asd4j.payroll.db.PayrollDatabase;
import com.brianway.asd4j.payroll.impl.UnionAffiliation;
import com.brianway.asd4j.payroll.domain.Affiliation;
import com.brianway.asd4j.payroll.domain.Employee;
import com.brianway.asd4j.payroll.transaction.ChangeAffiliationTransaction;

/**
 * Created by brian on 17/1/4.
 */
public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {
    public ChangeUnaffiliatedTransaction(int employeeId) {
        super(employeeId);
    }

    @Override
    public Affiliation getAffiliation() {
        return new NoAffiliation();
    }

    @Override
    public void recordMembership(Employee e) {
        Affiliation af = e.getAffiliation();
        //TODO P207,轻微违反 OCP
        if (af instanceof UnionAffiliation) {
            UnionAffiliation uf = (UnionAffiliation) af;
            int memberId = uf.getMemberId();
            PayrollDatabase.getPayrollDatabase().removeUnionMember(memberId);
        }
    }
}
