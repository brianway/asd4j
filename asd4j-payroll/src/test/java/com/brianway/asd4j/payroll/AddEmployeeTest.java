package com.brianway.asd4j.payroll;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by brian on 17/1/6.
 */
public class AddEmployeeTest {

    @Test
    public void testAddSalariedEmployee() {
        int employeeId = 1;
        String name = "Bob";
        String address = "Home";
        double salary = 1000.00;
        AddSalariedEmployee t = new AddSalariedEmployee(employeeId, name, address, salary);
        t.execute();

        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        Assert.assertEquals(name, e.getName());

        PaymentClassification pc = e.getClassification();
        Assert.assertTrue(pc instanceof SalariedClassification);
        SalariedClassification sc = (SalariedClassification) pc;
        Assert.assertEquals(salary, sc.getSalary(), 0.001);

        PaymentSchedule ps = e.getSchedule();
        Assert.assertTrue(ps instanceof MonthlySchedule);

        PaymentMethod pm = e.getMethod();
        Assert.assertTrue(pm instanceof HoldMethod);
    }

    @Test
    public void testAddHourlyEmployee() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        Assert.assertEquals(name, e.getName());

        PaymentClassification pc = e.getClassification();
        Assert.assertTrue(pc instanceof HourlyClassification);
        HourlyClassification hc = (HourlyClassification) pc;
        Assert.assertEquals(hourlyRate, hc.getRate(), 0.001);

        PaymentSchedule ps = e.getSchedule();
        Assert.assertTrue(ps instanceof WeeklySchedule);

        PaymentMethod pm = e.getMethod();
        Assert.assertTrue(pm instanceof HoldMethod);

    }

    @Test
    public void testAddCommissionedEmployee() {
        int employeeId = 3;
        String name = "Lance";
        String address = "Home";
        double salary = 2500;
        double commissionRate = 3.2;
        AddCommissionedEmployee t = new AddCommissionedEmployee(employeeId, name, address, salary, commissionRate);
        t.execute();

        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        Assert.assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        Assert.assertTrue(pc instanceof CommissionedClassification);
        CommissionedClassification cc = (CommissionedClassification) pc;
        Assert.assertEquals(salary, cc.getSalary(), 0.001);
        Assert.assertEquals(commissionRate, cc.getCommissionRate(), 0.001);

        PaymentSchedule ps = e.getSchedule();
        Assert.assertTrue(ps instanceof BiweeklySchedule);

        PaymentMethod pm = e.getMethod();
        Assert.assertTrue(pm instanceof HoldMethod);

    }
}
