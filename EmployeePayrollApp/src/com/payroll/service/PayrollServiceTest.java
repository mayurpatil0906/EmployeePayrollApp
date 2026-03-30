package com.payroll.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.payroll.model.Employee;
import com.payroll.model.Payslip;

class PayrollServiceTest {

    @Test
    void testGeneratePayslipCalculations() {

        PayrollService service = new PayrollService();

        Employee emp = new Employee(
                "EMP-0001",
                "Mayur",
                "mayur@gmail.com",
                "9876543210",
                null
        );

        Payslip slip = service.generatePayslip(
                emp,
                "Jan 2026",
                1000.0,
                500.0,
                200.0,
                300.0
        );

        assertEquals(120.0, slip.getComponents().pf);
        assertEquals(200.0, slip.getComponents().tax);
        assertEquals(1680.0, slip.getComponents().netPay);
        assertEquals("Jan 2026", slip.getMonth());
    }
}