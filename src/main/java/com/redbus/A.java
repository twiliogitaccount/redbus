package com.redbus;
//Data hiding - Here we make the variable private so that it cannot be accessed outside the class
public class A {
    private String password;
    private String name;

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
}
