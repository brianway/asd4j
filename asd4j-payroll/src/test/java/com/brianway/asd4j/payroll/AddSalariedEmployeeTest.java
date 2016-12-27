package com.brianway.asd4j.payroll;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by brian on 16/12/27.
 */
public class AddSalariedEmployeeTest {
    @Test
    public void testAddSalariedEmployee() {
        int employeeId = 1;
        String name = "Bob";
        String address = "Home";
        double salary = 1000.00;
        AddSalariedEmployee t = new AddSalariedEmployee(employeeId, name, address, salary);
        t.execute();

        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        Assert.assertEquals("Bob", e.getName());

        PaymentClassification pc = e.getClassification();
        Assert.assertTrue(pc instanceof SalariedClassification);
        SalariedClassification sc = (SalariedClassification) pc;
        Assert.assertEquals(salary, sc.getSalary(), 0.0);

        PaymentSchedule ps = e.getSchedule();
        Assert.assertTrue(ps instanceof MonthlySchedule);

        PaymentMethod pm = e.getMethod();
        Assert.assertTrue(pm instanceof HoldMethod);
    }
}
