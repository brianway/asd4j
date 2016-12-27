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
        String name = "Bob";
        String address = "Home";
        double salary = 1000.00;
        AddSalariedEmployee t = new AddSalariedEmployee(employeeId, name, address, salary);
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
