package com.payroll.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PayslipTest {

    @Test
    void testPayslipCloneAndEquals() {

        Employee emp = new Employee(
                "EMP-9999",
                "Test",
                "",
                "",
                null
        );

        SalaryComponents comps = new SalaryComponents(1000, 200, 100, 50);

        comps.pf = 120;
        comps.tax = 200;
        comps.netPay = 830;

        Payslip original = new Payslip(emp, comps, "Dec 2026");

        Payslip cloned = original.clone();

        assertEquals(original, cloned);      // equals()
        assertNotSame(original, cloned);     // different object
        assertEquals(
                original.getComponents().netPay,
                cloned.getComponents().netPay
        );
    }
}