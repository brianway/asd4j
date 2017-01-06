package com.brianway.asd4j.payroll.impl;

import com.brianway.asd4j.payroll.domain.Paycheck;
import com.brianway.asd4j.payroll.domain.Affiliation;

/**
 * Created by brian on 17/1/4.
 */
public class NoAffiliation implements Affiliation {
    @Override
    public double calculateDeductions(Paycheck pc) {
        //TODO calculateDeductions
        return 0;
    }
}
