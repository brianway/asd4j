package com.brianway.asd4j.payroll;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by brian on 17/1/5.
 */
public class PayrollTest {
    @Test
    public void testPaySingleHourlyEmployeeNoTimeCards() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        Date payDate = new Date(2017 - 1900, 0, 6);
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();

        validatePaycheck(pt, employeeId, payDate, 0.0);

    }

    public void validatePaycheck(PaydayTransaction pt, int employeeId,
                                 final Date payDate, double pay) {
        Paycheck pc = pt.getPaycheck(employeeId);
        Assert.assertNotNull(pc);
        Assert.assertEquals(payDate, pc.getPayPeriodEndDate());
        Assert.assertEquals(pay, pc.getGrossPay(), 0.001);
        Assert.assertEquals("Hold", pc.getField("Disposition"));
        Assert.assertEquals(0.0, pc.getDeductions(), 0.001);
        Assert.assertEquals(pay, pc.getNetPay(), 0.001);
    }
}
