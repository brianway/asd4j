package com.brianway.asd4j.payroll;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by brian on 17/1/3.
 */
public class ChangeHourlyTransactionTest {

    @Test
    public void testChangeHourlyTransaction() {
        int employeeId = 3;
        String name = "Lance";
        String address = "Home";
        double salary = 2500.0;
        double commissionRate = 3.2;
        AddCommissionedEmployee t = new AddCommissionedEmployee(employeeId, name, address, salary, commissionRate);
        t.execute();

        double hourlyRate = 27.52;
        ChangeHourlyTransaction cht = new ChangeHourlyTransaction(employeeId, hourlyRate);
        cht.execute();

        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        Assert.assertNotNull(e);
        PaymentClassification pc = e.getClassification();
        Assert.assertNotNull(pc);
        Assert.assertTrue(pc instanceof HourlyClassification);
        HourlyClassification hc = (HourlyClassification) pc;
        Assert.assertEquals(hourlyRate, hc.getRate(), 0.001);

        PaymentSchedule ps = e.getSchedule();
        Assert.assertNotNull(ps);
        Assert.assertTrue(ps instanceof WeeklySchedule);
    }
}
