package com.payroll.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.payroll.dashboard.Dashboard;
import com.payroll.dashboard.DashboardFactory;
import com.payroll.model.Employee;
import com.payroll.model.Payslip;
import com.payroll.model.SalaryComponents;

public class DashboardApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 5: DASHBOARD DISPLAY ===");

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Role (EMPLOYEE/MANAGER): ");
        String role = sc.nextLine();

        Employee emp = new Employee(id, name, "", "", null);


        ArrayList<Payslip> payslips = new ArrayList<>();

        SalaryComponents c1 = new SalaryComponents(30000,5000,2000,1000);
        c1.netPay = 31000;

        SalaryComponents c2 = new SalaryComponents(31000,5000,2000,1000);
        c2.netPay = 32000;

        SalaryComponents c3 = new SalaryComponents(29000,5000,2000,1000);
        c3.netPay = 30000;

        SalaryComponents c4 = new SalaryComponents(32000,5000,2000,1000);
        c4.netPay = 33000;

        SalaryComponents c5 = new SalaryComponents(33000,5000,2000,1000);
        c5.netPay = 34000;

        payslips.add(new Payslip(emp,c1,"Jan"));
        payslips.add(new Payslip(emp,c2,"Feb"));
        payslips.add(new Payslip(emp,c3,"Mar"));
        payslips.add(new Payslip(emp,c4,"Apr"));
        payslips.add(new Payslip(emp,c5,"May"));


        Dashboard dashboard = DashboardFactory.getDashboard(role);

        if (dashboard != null) {
            dashboard.display(payslips, emp);
        } else {
            System.out.println("Invalid Role Entered.");
        }
    }
}