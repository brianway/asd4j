package com.brianway.asd4j.payroll;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by brian on 16/12/27.
 */
public class TimeCardTransactionTest {
    @Test
    public void testTimeCardTransaction() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        double hours = 8.0;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        //TODO Deprecated Date constructor
        Date date = new Date(2016 - 1900, 11, 27);
        TimeCardTransaction tct = new TimeCardTransaction(date, hours, employeeId);
        tct.execute();

        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        Assert.assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        Assert.assertTrue(pc instanceof HourlyClassification);

        TimeCard tc = ((HourlyClassification) pc).getTimeCard(date);
        Assert.assertNotNull(tc);
        Assert.assertEquals(hours, tc.getHours(), 0.0);
    }
}
