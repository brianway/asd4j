package com.brianway.asd4j.payroll;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by brian on 16/12/27.
 */
public class DeleteEmployeeTest {
    @Test
    public void testDeleteEmployee() {
        int employeeId = 3;
        String name = "Lance";
        String address = "Home";
        double salary = 2500;
        double commissionRate = 3.2;
        AddCommissionedEmployee t = new AddCommissionedEmployee(employeeId, name, address, salary, commissionRate);
        t.execute();
        {
            Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
            Assert.assertNotNull(e);
        }
        DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(employeeId);
        dt.execute();
        {
            Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(employeeId);
            Assert.assertNull(e);
        }
    }
}
