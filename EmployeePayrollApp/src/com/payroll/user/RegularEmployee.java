package com.payroll.user;

import com.payroll.util.PasswordUtil;

public class RegularEmployee extends User {

    public RegularEmployee(String username, String passwordHash) {
        super(username, passwordHash, "EMPLOYEE");
    }

    @Override
    public boolean authenticate(String username, String password) {

        return this.username.equals(username)
                && this.passwordHash.equals(PasswordUtil.hash(password));
    }
}