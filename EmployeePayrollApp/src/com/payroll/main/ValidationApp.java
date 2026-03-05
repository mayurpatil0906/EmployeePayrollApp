package com.payroll.main;

import java.util.Scanner;

import com.payroll.validation.Validator;
import com.payroll.exception.ValidationException;

public class ValidationApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 6: INPUT VALIDATION ===");

        try {

            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();

            System.out.print("Create Password: ");
            String password = sc.nextLine();


            Validator.validateEmployeeId(empId);
            Validator.validateEmail(email);
            Validator.validatePhone(phone);
            Validator.validatePassword(password);


            System.out.println("\nAll inputs are VALID. Registration/Login can proceed.");

        }

        catch (ValidationException ex) {

            System.out.println("\nValidation Failed:");
            System.out.println(ex.getMessage());
        }
    }
}