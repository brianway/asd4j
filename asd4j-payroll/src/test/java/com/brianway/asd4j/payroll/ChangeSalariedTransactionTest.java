package com.brianway.asd4j.payroll;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by brian on 17/1/3.
 */
public class ChangeSalariedTransactionTest {

    @Test
    public void testChangeSalariedTransaction() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        double salary = 2500.0;
        ChangeSalariedTransaction cst = new ChangeSalariedTransaction(employeeId, salary);
        cst.execute();

        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        Assert.assertNotNull(e);
        PaymentClassification pc = e.getClassification();
        Assert.assertNotNull(pc);
        Assert.assertTrue(pc instanceof SalariedClassification);
        SalariedClassification sc = (SalariedClassification) pc;
        Assert.assertEquals(salary, sc.getSalary(), 0.001);

        PaymentSchedule ps = e.getSchedule();
        Assert.assertNotNull(ps);
        Assert.assertTrue(ps instanceof MonthlySchedule);
    }
}
