package com.payroll.auth;

import java.io.File;
import java.security.MessageDigest;
import java.util.Scanner;

public class AuthenticationService {

    public Session login() {

        Scanner sc = new Scanner(System.in);

        try {

            File file = new File("employee_data.txt");

            if (!file.exists()) {

                System.out.println("No employee data found.");
                return null;
            }

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            String hashedInput = hashPassword(password);

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();

                String[] data = line.split(",");

                if (data.length < 6) {
                    continue; 
                }

                String fileUsername = data[4];
                String filePassword = data[5];

                if (username.equals(fileUsername) &&
                        hashedInput.equals(filePassword)) {

                    fileScanner.close();
                    return new Session(username);
                }
            }

            fileScanner.close();

            System.out.println("Invalid Credentials");

        } catch (Exception e) {

            System.out.println("Login error: " + e.getMessage());
        }

        return null;
    }

    private String hashPassword(String password) {

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hash = md.digest(password.getBytes());

            StringBuilder hex = new StringBuilder();

            for (byte b : hash) {

                hex.append(String.format("%02x", b));
            }

            return hex.toString();

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}