package com.brianway.asd4j.payroll;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by brian on 16/12/28.
 */
public class AddServiceChargeTest {
    @Test
    public void addServiceCharge() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        Assert.assertNotNull(e);

        int memberId = 86;
        double due = 12.5;
        UnionAffiliation af = new UnionAffiliation(memberId, due);
        e.setAffiliation(af);

        Date date = new Date(2016-1900, 11, 27);//TODO
        double amount = 12.95;
        PayrollDatabase.getPayrollDatabase().addUnionMember(memberId, e);
        ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, date, amount);
        sct.execute();

        ServiceCharge sc = af.getServiceCharge(date);
        Assert.assertNotNull(sc);
        Assert.assertEquals(amount, sc.getAmount(), 0.001);
    }
}
