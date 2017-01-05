package com.brianway.asd4j.payroll;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 16/12/28.
 */
public class UnionAffiliation implements Affiliation {
    private List<ServiceCharge> serviceCharges = new ArrayList<>();
    private int memberId;
    private double dues;

    public UnionAffiliation(int memberId, double dues) {
        this.memberId = memberId;
        this.dues = dues;
    }

    @Override
    public double calculateDeductions(Paycheck pc) {
        //TODO calculateDeductions
        return 0;
    }

    public void addServiceCharge(ServiceCharge sc) {
        serviceCharges.add(sc);
    }

    public ServiceCharge getServiceCharge(long date) {
        for (ServiceCharge sc : serviceCharges) {
            if (sc.getDate() == date) {
                return sc;
            }
        }
        return null;
    }

    public int getMemberId() {
        return memberId;
    }

    public double getDues() {
        return dues;
    }
}
