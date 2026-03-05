package com.payroll.dashboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.payroll.model.Employee;
import com.payroll.model.Payslip;

public class EmployeeDashboard implements Dashboard {

    public void display(ArrayList<Payslip> payslips, Employee employee) {

        System.out.println("\n=== EMPLOYEE DASHBOARD ===");

        System.out.println("Welcome, " + employee.getName());

        System.out.println("Dashboard Type: " + this.getClass().getName());


        Collections.sort(payslips, new Comparator<Payslip>() {

            public int compare(Payslip p1, Payslip p2) {
                return Double.compare(
                        p2.getComponents().netPay,
                        p1.getComponents().netPay);
            }
        });


        System.out.println("\nRecent Payslips (Top 3):");

        int count = 0;

        for (Payslip p : payslips) {

            if (count == 3)
                break;

            System.out.println(
                    p.getMonth() + " : " +
                    p.getComponents().netPay);

            count++;
        }


        double total = 0;

        for (Payslip p : payslips) {
            total += p.getComponents().netPay;
        }

        System.out.println("\nYear-To-Date Earnings: " + total);
    }
}