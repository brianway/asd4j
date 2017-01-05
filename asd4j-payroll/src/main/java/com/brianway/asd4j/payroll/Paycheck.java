package com.brianway.asd4j.payroll;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by brian on 17/1/4.
 */
public class Paycheck {
    private final Map<String, String> fields = new HashMap<String, String>();
    private final Date payPeriodStartDate;
    private final Date payPeriodEndDate;//TODO
    private double grossPay;
    private double deductions;
    private double netPay;

    public Paycheck(Date payPeriodStartDate, Date payPeriodEndDate) {
        this.payPeriodStartDate = payPeriodStartDate;
        this.payPeriodEndDate = payPeriodEndDate;
    }

    public Date getPayPeriodEndDate() {

        return payPeriodEndDate;
    }

    public Date getPayPeriodStartDate() {
        return payPeriodStartDate;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public String getField(String name) {
        return fields.get(name);
    }

    public void setField(String name, String value) {
        fields.put(name, value);
    }
}
