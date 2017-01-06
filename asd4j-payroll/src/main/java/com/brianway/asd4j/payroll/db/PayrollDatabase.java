package com.brianway.asd4j.payroll.db;

import com.brianway.asd4j.payroll.domain.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brian on 16/12/27.
 */
public class PayrollDatabase {

    private static PayrollDatabase database = new PayrollDatabase();
    private Map<Integer, Employee> itsEmployees = new HashMap<>();
    private Map<Integer, Employee> relations = new HashMap<>();

    public Employee getEmployee(int employeeId) {
        return itsEmployees.get(employeeId);
    }

    public void addEmployee(int employeeId, Employee employee) {
        itsEmployees.put(employeeId, employee);
    }

    public void deleteEmployee(int employeeId) {
        itsEmployees.remove(employeeId);
    }

    public void clear() {
        itsEmployees.clear();
    }

    public List<Integer> getEmployeeIds() {
        List<Integer> ids = new ArrayList<>();
        ids.addAll(itsEmployees.keySet());
        return ids;
    }

    public Employee getUnionMember(int memberId) {
        return relations.get(memberId);
    }

    public void addUnionMember(int memberId, Employee e) {
        relations.put(memberId, e);
    }

    public void removeUnionMember(int memberId) {
        relations.remove(memberId);
    }

    public static PayrollDatabase getPayrollDatabase() {
        return database;
    }

    public static void main(String[] args) {

    }
}
