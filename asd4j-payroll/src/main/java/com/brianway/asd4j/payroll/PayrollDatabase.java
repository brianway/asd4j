package com.brianway.asd4j.payroll;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by brian on 16/12/27.
 */
public class PayrollDatabase {

    private static PayrollDatabase database = new PayrollDatabase();
    private Map<Integer, Employee> itsEmployees = new HashMap<>();

    public Employee getEmployee(int employeeId) {
        return itsEmployees.get(employeeId);
    }

    public void addEmployee(int employeeId, Employee employee) {
        itsEmployees.put(employeeId, employee);
    }

    public void clear() {
        itsEmployees.clear();
    }

    public static PayrollDatabase getPayrollDatabase() {
        return database;
    }
}
