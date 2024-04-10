package com.myapp.userapp.model;

import java.time.LocalDate;

public class User {
    private int userId;
    private String name;
    private String email;
    private LocalDate dob;

    public User(int userId, String name, String email, LocalDate dob) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
