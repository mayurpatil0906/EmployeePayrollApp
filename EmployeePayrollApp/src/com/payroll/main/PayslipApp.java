package com.payroll.main;

import java.util.Scanner;

import com.payroll.model.Employee;
import com.payroll.model.Payslip;
import com.payroll.service.PayrollService;
import com.payroll.security.DownloadToken;
import com.payroll.service.FileService;

public class PayslipApp {


public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("=== USE CASE 3: PAYSLIP GENERATION ===");

    System.out.print("Enter Employee ID: ");
    String empId = sc.nextLine();

    System.out.print("Enter Employee Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Month (e.g., January 2026): ");
    String month = sc.nextLine();

    System.out.print("Enter Basic Salary: ");
    double basic = sc.nextDouble();

    System.out.print("Enter HRA: ");
    double hra = sc.nextDouble();

    System.out.print("Enter DA: ");
    double da = sc.nextDouble();

    System.out.print("Enter Allowances: ");
    double allowances = sc.nextDouble();

    Employee emp = new Employee(empId, name, "", "", null);

    PayrollService payrollService = new PayrollService();

    Payslip payslip = payrollService.generatePayslip(
            emp, month, basic, hra, da, allowances
    );

    System.out.println(payslip);

    System.out.println("\n=== USE CASE 4: PAYSLIP PRINT / DOWNLOAD ===");

    try {

        System.out.println("\nOriginal Payslip:");
        System.out.println(payslip);

        // Clone Payslip
        Payslip copy = payslip.clone();

        if (payslip.equals(copy)) {
            System.out.println("Verified: Download copy is equal to original.");
        }

        System.out.println("Original hashcode: " + payslip.hashCode());
        System.out.println("Cloned hashcode: " + copy.hashCode());

        DownloadToken token = new DownloadToken();

        if (!token.isExpired()) {

            FileService fs = new FileService();

            String textFile = fs.savePayslipAsText(copy);
            String pdfFile = fs.savePayslipAsPdf(copy);

            System.out.println("\nPayslip Download Successful.");
            System.out.println("Saved as text file: " + textFile);
            System.out.println("Saved as PDF file: " + pdfFile);

            System.out.println("\nPrinted Payslip");
            System.out.println(copy);

        } else {

            System.out.println("Download token expired.");
        }

    } catch (Exception e) {

        System.out.println("Error during payslip download.");
    }
}


}
