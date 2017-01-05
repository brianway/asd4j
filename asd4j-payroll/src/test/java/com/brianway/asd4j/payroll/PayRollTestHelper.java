package com.brianway.asd4j.payroll;

import org.junit.Assert;

import java.util.Date;

/**
 * Created by brian on 17/1/5.
 */
public class PayRollTestHelper {
    public static void validatePaycheck(PaydayTransaction pt, int employeeId,
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
