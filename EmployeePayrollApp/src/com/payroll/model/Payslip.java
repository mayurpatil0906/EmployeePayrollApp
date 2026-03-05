package com.payroll.model;

public class Payslip implements Cloneable {

    private Employee employee;
    private SalaryComponents components;
    private String month;

    public Payslip(Employee employee, SalaryComponents components, String month) {
        this.employee = employee;
        this.components = components;
        this.month = month;
    }

    public Employee getEmployee() {
        return employee;
    }

    public SalaryComponents getComponents() {
        return components;
    }

    public String getMonth() {
        return month;
    }

    // Clone Payslip
    @Override
    public Payslip clone() {

        SalaryComponents copyComp = new SalaryComponents(
                components.basicSalary,
                components.hra,
                components.da,
                components.allowances
        );

        copyComp.pf = components.pf;
        copyComp.tax = components.tax;
        copyComp.netPay = components.netPay;

        return new Payslip(employee, copyComp, month);
    }

    // equals()
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Payslip)) return false;

        Payslip p = (Payslip) o;

        return employee.getEmpId().equals(p.employee.getEmpId())
                && month.equals(p.month);
    }

    // hashCode()
    @Override
    public int hashCode() {

        int result = 17;

        result = 31 * result + employee.getEmpId().hashCode();
        result = 31 * result + month.hashCode();

        return result;
    }

    // ===== UC3 Detailed Payslip =====
    @Override
    public String toString() {

        return "\n========== PAYSLIP ==========\n" +
                "Month : " + month + "\n\n" +

                "Employee ID : " + employee.getEmpId() + "\n" +
                "Employee Name : " + employee.getName() + "\n\n" +

                "----- Earnings -----\n" +
                "Basic Salary : " + components.basicSalary + "\n" +
                "HRA : " + components.hra + "\n" +
                "DA : " + components.da + "\n" +
                "Allowances : " + components.allowances + "\n\n" +

                "----- Deductions -----\n" +
                "PF : " + components.pf + "\n" +
                "Tax : " + components.tax + "\n\n" +

                "Net Pay : " + components.netPay + "\n" +
                "==============================";
    }

    // ===== UC4 Simple Payslip for Download =====
    public String toDownloadString() {

        return "PAYSLIP\n" +
                "Employee ID : " + employee.getEmpId() + "\n" +
                "Employee Name: " + employee.getName() + "\n" +
                "Month : " + month + "\n" +
                "Net Pay : " + components.netPay + "\n";
    }
}