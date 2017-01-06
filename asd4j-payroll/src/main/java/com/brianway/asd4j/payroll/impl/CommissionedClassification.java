package com.brianway.asd4j.payroll.impl;

import com.brianway.asd4j.payroll.domain.Paycheck;
import com.brianway.asd4j.payroll.domain.PaymentClassification;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by brian on 16/12/27.
 */
public class CommissionedClassification extends PaymentClassification {
    private double salary;
    private double commissionRate;
    private final Map<Date, SalesReceipt> salesReceipts = new HashMap<>();

    public CommissionedClassification(double salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculatePay(Paycheck pc) {
        //TODO base pay
        double sales = calculateSales(pc);
        double commissionPay = commissionRate * 0.01 * sales;
        return salary + commissionPay;
    }

    private double calculateSales(Paycheck pc) {
        //TODO Java 8
        double sales = 0.0;
        for (SalesReceipt sr : salesReceipts.values()) {
            if (isInPayPeriod(sr.getDate(), pc)) {
                sales += sr.getAmount();
            }
        }
        return sales;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceipts.put(salesReceipt.getDate(), salesReceipt);
    }

    public SalesReceipt getSalesReceipt(Date date) {
        return salesReceipts.get(date);
    }
}
