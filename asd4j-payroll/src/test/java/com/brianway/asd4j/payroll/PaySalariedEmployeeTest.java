package com.brianway.asd4j.payroll;

import static com.brianway.asd4j.payroll.PayRollTestHelper.validatePaycheck;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by brian on 17/1/5.
 */
public class PaySalariedEmployeeTest {
    @Test
    public void testPaySingleSalariedEmployeeOnLastDayOfMonth() {
        int employeeId = 1;
        String name = "Bob";
        String address = "Home";
        double salary = 1000.00;
        AddSalariedEmployee t = new AddSalariedEmployee(employeeId, name, address, salary);
        t.execute();

        Date payDate = new Date(2017 - 1900, 0, 31);
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        validatePaycheck(pt, employeeId, payDate, salary);
    }

    @Test
    public void testPaySingleSalariedEmployeeOnWrongDate() {
        int employeeId = 1;
        String name = "Bob";
        String address = "Home";
        double salary = 1000.00;
        AddSalariedEmployee t = new AddSalariedEmployee(employeeId, name, address, salary);
        t.execute();

        Date payDate = new Date(2017 - 1900, 0, 5);
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        Assert.assertNull(pt.getPaycheck(employeeId));
    }
}
