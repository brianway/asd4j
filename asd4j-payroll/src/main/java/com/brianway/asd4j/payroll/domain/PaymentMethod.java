package com.brianway.asd4j.payroll.domain;

/**
 * Created by brian on 16/12/27.
 */
public interface PaymentMethod {
    void pay(Paycheck pc);
}
