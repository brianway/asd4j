package com.brianway.asd4j.payroll;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by brian on 16/12/28.
 */
public class SalesReceiptTransactionTest {
    @Test
    public void testSalesReceiptTransaction() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double salary = 500.0;
        double commissionRate = 3.0;
        Date date = new Date(2016 - 1900, 11, 27);//TODO Deprecated Date constructor
        double amount = 100.0;
        AddCommissionedEmployee t = new AddCommissionedEmployee(employeeId, name, address, salary, commissionRate);
        t.execute();

        SalesReceiptTransaction st = new SalesReceiptTransaction(date, amount, employeeId);
        st.execute();

        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
        Assert.assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        Assert.assertTrue(pc instanceof CommissionedClassification);

        SalesReceipt sr = ((CommissionedClassification) pc).getSalesReceipt(date);
        Assert.assertNotNull(sr);
        Assert.assertEquals(amount, sr.getAmount(), 0.0);
    }
}
