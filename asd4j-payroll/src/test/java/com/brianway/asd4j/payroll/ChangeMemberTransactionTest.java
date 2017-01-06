package com.brianway.asd4j.payroll;

import com.brianway.asd4j.payroll.db.PayrollDatabase;
import com.brianway.asd4j.payroll.domain.Affiliation;
import com.brianway.asd4j.payroll.domain.Employee;
import com.brianway.asd4j.payroll.impl.UnionAffiliation;
import com.brianway.asd4j.payroll.transaction.impl.AddHourlyEmployee;
import com.brianway.asd4j.payroll.transaction.ChangeMemberTransaction;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by brian on 17/1/4.
 */
public class ChangeMemberTransactionTest {

    @Test
    public void testChangeMemberTransaction() {
        int employeeId = 2;
        int memberId = 7734;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        double dues = 99.42;
        ChangeMemberTransaction cmt = new ChangeMemberTransaction(employeeId, memberId, dues);
        cmt.execute();

        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        Assert.assertNotNull(e);

        Affiliation af = e.getAffiliation();
        Assert.assertTrue(af instanceof UnionAffiliation);
        UnionAffiliation uf = (UnionAffiliation) af;
        Assert.assertEquals(dues, uf.getDues(), 0.001);
        Employee member = PayrollDatabase.getPayrollDatabase().getUnionMember(memberId);
        Assert.assertNotNull(member);
        Assert.assertTrue(e == member);
    }
}
