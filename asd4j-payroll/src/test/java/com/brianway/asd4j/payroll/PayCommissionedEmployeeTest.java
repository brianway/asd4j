package com.brianway.asd4j.payroll;

import static com.brianway.asd4j.payroll.PayRollTestHelper.validatePaycheck;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by brian on 17/1/6.
 */
public class PayCommissionedEmployeeTest {
    @Test
    public void testPaySingleCommissionedEmployee() {
        int employeeId = 3;
        String name = "Lance";
        String address = "Home";
        double salary = 2500;
        double commissionRate = 3.2;
        AddCommissionedEmployee t = new AddCommissionedEmployee(employeeId, name, address, salary, commissionRate);
        t.execute();

        Date payDate = new Date(2017 - 1900, 0, 6);
        double amount = 200;
        SalesReceiptTransaction srt = new SalesReceiptTransaction(payDate, amount, employeeId);
        srt.execute();

        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        double pay = salary + commissionRate * 0.01 * amount;
        validatePaycheck(pt, employeeId, payDate, pay);
    }

    @Test
    public void testPaySingleCommissionedEmployeeOnWrongDate() {
        int employeeId = 3;
        String name = "Lance";
        String address = "Home";
        double salary = 2500;
        double commissionRate = 3.2;
        AddCommissionedEmployee t = new AddCommissionedEmployee(employeeId, name, address, salary, commissionRate);
        t.execute();

        Date payDate = new Date(2017 - 1900, 0, 13);//Also Friday,but not pay day.
        double amount = 200;
        SalesReceiptTransaction srt = new SalesReceiptTransaction(payDate, amount, employeeId);
        srt.execute();

        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        Assert.assertNull(pt.getPaycheck(employeeId));
    }

}
