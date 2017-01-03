package com.brianway.asd4j.payroll;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by brian on 17/1/3.
 */
public class ChangeCommissionedTransactionTest {

    @Test
    public void testChangeCommisionedTransaction() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        double salary = 200.0;
        double commissionRate = 2.0;
        ChangeCommissionedTransaction cct = new ChangeCommissionedTransaction(employeeId, salary, commissionRate);
        cct.execute();

        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        Assert.assertNotNull(e);
        PaymentClassification pc = e.getClassification();
        Assert.assertNotNull(pc);
        Assert.assertTrue(pc instanceof CommissionedClassification);
        CommissionedClassification cc = (CommissionedClassification) pc;
        Assert.assertEquals(salary, cc.getSalary(), 0.001);
        Assert.assertEquals(commissionRate, cc.getCommissionRate(), 0.001);

        PaymentSchedule ps = e.getSchedule();
        Assert.assertNotNull(ps);
        Assert.assertTrue(ps instanceof BiweeklySchedule);
    }
}
