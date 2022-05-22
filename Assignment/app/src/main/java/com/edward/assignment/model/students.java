package com.edward.assignment.model;

import java.util.Date;

public class students {
    private String fullName;
    private String Dob;
    private String classes;

    public students(String fullName, String dob, String classes) {
        this.fullName = fullName;
        this.Dob = dob;
        this.classes = classes;
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

    public String getClasses() {return classes;}

    public void setClasses(String classes) {this.classes = classes;}

    @Override
    public String toString() {
        return getFullName() + "  :  " + getDob() + "  :  " + getClasses();
    }

}
