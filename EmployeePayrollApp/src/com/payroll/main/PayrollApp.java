package com.payroll.main;

import java.util.Scanner;

import com.payroll.model.Employee;
import com.payroll.service.EmployeeService;

public class PayrollApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        try {

            System.out.println("=== USE CASE 1: EMPLOYEE REGISTRATION ===");

            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();

            System.out.print("Create Username: ");
            String username = sc.nextLine();

            System.out.print("Create Password: ");
            String password = sc.nextLine();

            Employee emp = service.registerEmployee(empId, name, email, phone, username, password);

            System.out.println("\nEmployee Registered Successfully");

            System.out.println(emp);

            System.out.println("\nData persisted in file: employee_data.txt");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        
    }
}