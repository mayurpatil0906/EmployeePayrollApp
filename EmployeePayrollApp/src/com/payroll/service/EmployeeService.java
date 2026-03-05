package com.payroll.service;

import com.payroll.model.Employee;
import com.payroll.model.UserAccount;
import com.payroll.validation.Validator;

public class EmployeeService {

    public Employee registerEmployee(String empId, String name, String email,
                                     String phone, String username, String password) throws Exception {

        Validator.validateEmpId(empId);
        Validator.validateEmail(email);
        Validator.validatePhone(phone);

        UserAccount account = new UserAccount(username, password);

        Employee employee = new Employee(empId, name, email, phone, account);

        employee.persist();

        return employee;
    }
}