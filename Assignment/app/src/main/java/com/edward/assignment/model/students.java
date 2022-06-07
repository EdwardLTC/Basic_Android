package com.edward.assignment.model;

import android.content.Context;

import java.util.Date;

public class Students {
    private String fullName;
    private String Id;
    private String classes;

    public Students(String fullName, String id, String classes) {
        this.fullName = fullName;
        this.Id = id;
        this.classes = classes;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return Id;
    }

    public void setDob(String id) {
        Id = id;
    }

    public String getClasses() {return classes;}

    public void setClasses(String classes) {this.classes = classes;}

    @Override
    public String toString() {
        return getFullName() + "  :  " + getId() + "  :  " + getClasses();
    }

}
