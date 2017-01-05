package com.brianway.asd4j.payroll;

/**
 * Created by brian on 16/12/27.
 */
public class SalariedClassification extends PaymentClassification {
    private double salary;

    public SalariedClassification(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double calculatePay(Paycheck pc) {
        //TODO calculatePay
        return 0;
    }
}
