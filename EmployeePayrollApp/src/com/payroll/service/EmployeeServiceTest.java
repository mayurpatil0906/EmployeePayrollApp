package com.payroll.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.payroll.model.Employee;

class EmployeeServiceTest {

    @Test
    void testRegisterEmployeeSuccess() throws Exception {

        EmployeeService service = new EmployeeService();

        Employee emp = service.registerEmployee(
                "EMP-1234",
                "Mayur",
                "mayur@gmail.com",
                "9876543210",
                "mayur",
                "password123"
        );

        assertNotNull(emp);
        assertEquals("EMP-1234", emp.getEmpId());
        assertEquals("Mayur", emp.getName());
    }

    @Test
    void testInvalidEmail() {

        EmployeeService service = new EmployeeService();

        Exception ex = assertThrows(Exception.class, () -> {

            service.registerEmployee(
                    "EMP-1234",
                    "Mayur",
                    "invalid-email",
                    "9876543210",
                    "mayur",
                    "password123"
            );
        });

        assertTrue(ex.getMessage().contains("Invalid Email"));
    }

    @Test
    void testInvalidPhone() {

        EmployeeService service = new EmployeeService();

        Exception ex = assertThrows(Exception.class, () -> {

            service.registerEmployee(
                    "EMP-1234",
                    "Mayur",
                    "mayur@gmail.com",
                    "123",
                    "mayur",
                    "password123"
            );
        });

        assertTrue(ex.getMessage().contains("Phone"));
    }

    @Test
    void testInvalidEmployeeId() {

        EmployeeService service = new EmployeeService();

        Exception ex = assertThrows(Exception.class, () -> {

            service.registerEmployee(
                    "EMP1234",
                    "Mayur",
                    "mayur@gmail.com",
                    "9876543210",
                    "mayur",
                    "password123"
            );
        });

        assertTrue(ex.getMessage().contains("EMP-XXXX"));
    }
}