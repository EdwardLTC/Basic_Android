package com.edward.lab4.model;

public class Staff {
    private String name;
    private  String address;
    private  int idImg;
    private int sex;

    public Staff(String name, String address, int idImg, int sex) {
        this.name = name;
        this.address = address;
        this.idImg = idImg;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
