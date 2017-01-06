package com.brianway.asd4j.payroll.impl;

import com.brianway.asd4j.payroll.utils.DateHelper;
import com.brianway.asd4j.payroll.domain.Paycheck;
import com.brianway.asd4j.payroll.domain.Affiliation;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by brian on 16/12/28.
 */
public class UnionAffiliation implements Affiliation {
    private Map<Date, ServiceCharge> serviceCharges = new HashMap<>();
    private int memberId;
    private double dues;

    public UnionAffiliation(int memberId, double dues) {
        this.memberId = memberId;
        this.dues = dues;
    }

    @Override
    public double calculateDeductions(Paycheck pc) {
        return calculateUnionDues(pc) + calculateServiceCharges(pc);
    }

    private double calculateUnionDues(Paycheck pc) {
        int fridays = numberOfFridays(pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate());
        return dues * fridays;
    }

    private double calculateServiceCharges(Paycheck pc) {
        double charges = 0.0;
        for (ServiceCharge sc : serviceCharges.values()) {
            if (DateHelper.isBetween(sc.getDate(), pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate())) {
                charges += sc.getAmount();
            }
        }
        return charges;
    }

    private int numberOfFridays(final Date start, final Date end) {
        int fridays = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        while (!calendar.getTime().after(end)) {
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                fridays++;
            }
            calendar.add(Calendar.DATE, 1);
        }
        return fridays;
    }

    public void addServiceCharge(ServiceCharge sc) {
        serviceCharges.put(sc.getDate(), sc);
    }

    public ServiceCharge getServiceCharge(Date date) {
        return serviceCharges.get(date);
    }

    public int getMemberId() {
        return memberId;
    }

    public double getDues() {
        return dues;
    }
}
