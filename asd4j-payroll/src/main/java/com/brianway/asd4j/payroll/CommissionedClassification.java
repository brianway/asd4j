package com.brianway.asd4j.payroll;

/**
 * Created by brian on 16/12/27.
 */
public class CommissionedClassification extends PaymentClassification {
    private double salary;
    private double commissionRate;
    private SalesReceipt salesReceipt;

    public CommissionedClassification(double salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculatePay(Paycheck pc) {
        //TODO calculatePay
        return 0;
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

    public void addSalesReceipt(SalesReceipt salesReceipt){
        this.salesReceipt = salesReceipt;
    }

    public SalesReceipt getSalesReceipt() {
        return salesReceipt;
    }
}
