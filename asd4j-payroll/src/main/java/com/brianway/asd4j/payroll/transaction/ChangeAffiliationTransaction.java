package com.brianway.asd4j.payroll.transaction;

import com.brianway.asd4j.payroll.domain.Affiliation;
import com.brianway.asd4j.payroll.domain.Employee;

/**
 * Created by brian on 17/1/4.
 */
public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {
    public ChangeAffiliationTransaction(int employeeId) {
        super(employeeId);
    }

    @Override
    public void change(Employee e) {
        recordMembership(e);
        e.setAffiliation(getAffiliation());
    }

    public abstract Affiliation getAffiliation();

    public abstract void recordMembership(Employee e);

}
