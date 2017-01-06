package com.brianway.asd4j.payroll;

import static com.brianway.asd4j.payroll.PayRollTestHelper.validatePaycheck;
import com.brianway.asd4j.payroll.domain.Paycheck;
import com.brianway.asd4j.payroll.transaction.impl.AddHourlyEmployee;
import com.brianway.asd4j.payroll.transaction.impl.PaydayTransaction;
import com.brianway.asd4j.payroll.transaction.impl.TimeCardTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by brian on 17/1/5.
 */
public class PayHourlyEmployeeTest {

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

    @Test
    public void testPaySingleHourlyEmployeeOneTimeCard() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        Date payDate = new Date(2017 - 1900, 0, 6);
        double hours = 2.0;
        double pay = hourlyRate * hours;
        TimeCardTransaction tct = new TimeCardTransaction(payDate, hours, employeeId);
        tct.execute();
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        validatePaycheck(pt, employeeId, payDate, pay);
    }

    @Test
    public void testPaySingleHourlyEmployeeOvertimeOneTimeCard() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        Date payDate = new Date(2017 - 1900, 0, 6);
        double hours = 9.0;
        double pay = 8 * hourlyRate + 1.5 * hourlyRate;
        TimeCardTransaction tct = new TimeCardTransaction(payDate, hours, employeeId);
        tct.execute();
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        validatePaycheck(pt, employeeId, payDate, pay);
    }

    @Test
    public void testPaySingleHourlyEmployeeOnWrongDate() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        Date payDate = new Date(2017 - 1900, 0, 5);//Thursday
        double hours = 9.0;
        TimeCardTransaction tct = new TimeCardTransaction(payDate, hours, employeeId);
        tct.execute();
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();

        Paycheck pc = pt.getPaycheck(employeeId);
        Assert.assertNull(pc);
    }

    @Test
    public void testPaySingleHourlyEmployeeTwoTimeCards() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        Date payDate = new Date(2017 - 1900, 0, 6);
        double hours = 2.0;
        TimeCardTransaction tct = new TimeCardTransaction(payDate, hours, employeeId);
        tct.execute();
        Date date2 = new Date(2017 - 1900, 0, 5);
        double hours2 = 5.0;
        TimeCardTransaction tct2 = new TimeCardTransaction(date2, hours2, employeeId);
        tct2.execute();

        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        double pay = (hours + hours2) * hourlyRate;
        validatePaycheck(pt, employeeId, payDate, pay);
    }

    @Test
    public void testPaySingleHourlyEmployeeWithTimeCardsSpanningTwoPayPeriods() {
        int employeeId = 2;
        String name = "Bill";
        String address = "Home";
        double hourlyRate = 15.25;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, name, address, hourlyRate);
        t.execute();

        Date payDate = new Date(2017 - 1900, 0, 6);
        double hours = 2.0;
        TimeCardTransaction tct = new TimeCardTransaction(payDate, hours, employeeId);
        tct.execute();
        Date dateInpreviousPayPeriod = new Date(2016 - 1900, 11, 29);
        double hours2 = 5.0;
        TimeCardTransaction tct2 = new TimeCardTransaction(dateInpreviousPayPeriod, hours2, employeeId);
        tct2.execute();

        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        double pay = hours * hourlyRate;
        validatePaycheck(pt, employeeId, payDate, pay);
    }
}
