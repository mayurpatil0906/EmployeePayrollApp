package com.payroll.validation;

import com.payroll.exception.*;
import java.security.MessageDigest;

public class Validator {

    private static String sanitize(String input) {

        if (input == null) {
            return "";
        }

        return input.trim();
    }

    // Employee ID Validation
    public static void validateEmployeeId(String empId)
            throws EmployeeIdValidationException {

        empId = sanitize(empId);

        if (!empId.matches("EMP-\\d{4}")) {

            throw new EmployeeIdValidationException(
                    "Employee ID must follow format EMP-XXXX"
            );
        }
    }

    // Email Validation
    public static void validateEmail(String email)
            throws EmailValidationException {

        email = sanitize(email);

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {

            throw new EmailValidationException(
                    "Invalid Email Format"
            );
        }
    }

    // Phone Validation
    public static void validatePhone(String phone)
            throws PhoneValidationException {

        phone = sanitize(phone);

        if (!phone.matches("\\d{10}")) {

            throw new PhoneValidationException(
                    "Phone number must contain exactly 10 digits"
            );
        }
    }

    // Password Validation
    public static void validatePassword(String password)
            throws PasswordValidationException {

        password = sanitize(password);

        if (password.length() < 6) {

            throw new PasswordValidationException(
                    "Password must be at least 6 characters"
            );
        }
    }
 // Password Hashing (SHA-256)
    public static String hashPassword(String password) {

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hash = md.digest(password.getBytes());

            StringBuilder hex = new StringBuilder();

            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }

            return hex.toString();

        } catch (Exception e) {
            throw new RuntimeException("Error hashing password");
        }
    }
}