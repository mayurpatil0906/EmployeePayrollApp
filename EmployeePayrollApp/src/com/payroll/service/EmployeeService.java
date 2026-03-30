package com.payroll.service;

import com.payroll.model.Employee;
import com.payroll.model.UserAccount;
import com.payroll.validation.Validator;

public class EmployeeService {

    public Employee registerEmployee(String empId, String name, String email,
                                     String phone, String username, String password) throws Exception {

        Validator.validateEmployeeId(empId);
        Validator.validateEmail(email);
        Validator.validatePhone(phone);
        Validator.validatePassword(password); 
        String hashedPassword = Validator.hashPassword(password);
        UserAccount account = new UserAccount(username, hashedPassword);

        Employee employee = new Employee(empId, name, email, phone, account);

        employee.persist();

        return employee;
    }
}