package com.payroll.main;

import com.payroll.auth.*;

public class LoginApp {

    public static void main(String[] args) {

        System.out.println("=== USE CASE 2: LOGIN ===");

        AuthenticationService auth = new AuthenticationService();

        Session session = auth.login();

        if (session != null) {

            System.out.println(session);

            if (!session.isExpired()) {

                System.out.println("Session active and valid.");
            }
        }
    }
}