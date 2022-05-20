package com.edward.assignment.model;

public class Classes {
    private  String classID,className;

    public Classes(String classID, String className) {
        this.classID = classID;
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassID(){
        return classID;
    }

    public void setClassID(String classID){
        this.classID =classID;
    }

    @Override
    public String toString() {
        return getClassID() +"   :  " + getClassName();
    }
}
