package com.payroll.auth;

public class Session {

    private String username;
    private long loginTime;
    private long timeout = 300000;

    public Session(String username) {

        this.username = username;
        this.loginTime = System.currentTimeMillis();
    }

    public boolean isExpired() {

        long now = System.currentTimeMillis();

        return (now - loginTime) > timeout;
    }

    public String toString() {

        return "Session active for user: " + username;
    }
}