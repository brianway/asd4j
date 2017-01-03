package com.brianway.asd4j.payroll;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by brian on 17/1/3.
 */
public class ChangeNameTransactionTest {
    @Test
    public void testChangeNameTransaction() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        ChangeNameTransaction cnt = new ChangeNameTransaction(employeeId, "Bob");
        cnt.execute();
        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        Assert.assertNotNull(e);
        Assert.assertEquals("Bob", e.getName());
    }
}
