package com.edward.lab4.model;

public class Staff {
    private String name;
    private  String address;
    private  int idImg;

    public Staff(String name, String address, int idImg) {
        this.name = name;
        this.address = address;
        this.idImg = idImg;
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
}
