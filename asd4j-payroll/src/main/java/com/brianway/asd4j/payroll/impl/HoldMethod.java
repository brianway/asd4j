package com.brianway.asd4j.payroll.impl;

import com.brianway.asd4j.payroll.domain.Paycheck;
import com.brianway.asd4j.payroll.domain.PaymentMethod;

/**
 * Created by brian on 16/12/27.
 */
public class HoldMethod implements PaymentMethod {
    @Override
    public void pay(Paycheck pc) {
        pc.setField("Disposition", "Hold");
    }
}
//TODO MailMethod,DirectMethod