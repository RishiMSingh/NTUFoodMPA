package com.example.foodcollectionntu.helperClass.dashboardAdapter;

public class UserRegistrationHelperClass {

    String name, surename, username, email, password;

    public UserRegistrationHelperClass(String name, String surename, String username, String email, String password) {
        this.name = name;
        this.surename = surename;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
