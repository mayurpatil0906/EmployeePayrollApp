package com.payroll.validation;

import com.payroll.exception.ValidationException;

public class Validator {

    // Validate Email
    public static void validateEmail(String email) throws ValidationException {

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new ValidationException("Invalid Email Format");
        }
    }

    // Validate Phone
    public static void validatePhone(String phone) throws ValidationException {

        if (!phone.matches("[6-9][0-9]{9}")) {
            throw new ValidationException("Invalid Phone Number");
        }
    }

    // Validate Employee ID
    public static void validateEmpId(String empId) throws ValidationException {

        if (!empId.matches("EMP-[0-9]{4}")) {
            throw new ValidationException("Invalid Employee ID Format");
        }
    }
}