package com.brianway.asd4j.payroll;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by brian on 17/1/6.
 */
public class UnionMemberServiceChargeTest {
    @Test
    public void testHourlyUnionMemberServiceCharge() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.24;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        int memberId = 7734;
        double dues = 9.42;
        ChangeMemberTransaction cmt = new ChangeMemberTransaction(employeeId, memberId, dues);
        cmt.execute();

        Date payDate = new Date(2017 - 1900, 0, 6);
        double amount = 19.42;
        ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, payDate, amount);
        sct.execute();

        double hours = 8.0;
        TimeCardTransaction tct = new TimeCardTransaction(payDate, hours, employeeId);
        tct.execute();

        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        Paycheck pc = pt.getPaycheck(employeeId);
        Assert.assertNotNull(pc);
        Assert.assertEquals(payDate, pc.getPayPeriodEndDate());
        Assert.assertEquals(hours * hourlyRate, pc.getGrossPay(), 0.001);
        Assert.assertEquals("Hold", pc.getField("Disposition"));
        Assert.assertEquals(dues + amount, pc.getDeductions(), 0.001);
        Assert.assertEquals(hours * hourlyRate - (dues + amount), pc.getNetPay(), 0.001);

    }

    @Test
    public void testServiceChargeSpanningMultiplePayPeriods() {
        int employeeId = 1;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.24;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        int memberId = 7734;
        double dues = 9.42;
        ChangeMemberTransaction cmt = new ChangeMemberTransaction(employeeId, memberId, dues);
        cmt.execute();

        Date earlyDate = new Date(2016 - 1900, Calendar.DECEMBER, 30);//previous Friday
        double earlyAmount = 100.0;
        Date payDate = new Date(2017 - 1900, Calendar.JANUARY, 6);
        double amount = 19.42;
        Date lateDate = new Date(2016 - 1900, Calendar.JANUARY, 13);//previous Friday
        double lateAmount = 200.0;
        ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, earlyDate, earlyAmount);
        sct.execute();
        ServiceChargeTransaction sct2 = new ServiceChargeTransaction(memberId, payDate, amount);
        sct2.execute();
        ServiceChargeTransaction sct3 = new ServiceChargeTransaction(memberId, lateDate, lateAmount);
        sct3.execute();

        double hours = 8.0;
        TimeCardTransaction tct = new TimeCardTransaction(payDate, hours, employeeId);
        tct.execute();

        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        Paycheck pc = pt.getPaycheck(employeeId);
        Assert.assertNotNull(pc);
        Assert.assertEquals(payDate, pc.getPayPeriodEndDate());
        Assert.assertEquals(hours * hourlyRate, pc.getGrossPay(), 0.001);
        Assert.assertEquals("Hold", pc.getField("Disposition"));
        Assert.assertEquals(dues + amount, pc.getDeductions(), 0.001);
        Assert.assertEquals(hours * hourlyRate - (dues + amount), pc.getNetPay(), 0.001);
    }
}
