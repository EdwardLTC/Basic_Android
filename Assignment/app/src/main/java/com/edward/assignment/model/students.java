package com.edward.assignment.model;

import java.util.Date;

public class students {
    private  String fullName;
    private String Dob;

    public students( String fullName, String dob) {
        this.fullName = fullName;
        this.Dob = dob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    @Override
    public String toString() {
        return getFullName()+ "  :  " + getDob();
    }
}
