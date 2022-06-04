package com.edward.lab5.DAO;

import android.content.Context;

import com.edward.lab5.Helper.LiteSQL;

public class Product {
    private int id;
    private String tenSP;
    private int giaSP;
    private String hinHSP;

    public Product(int id, String tenSP, int giaSP, String hinHSP) {
        this.id = id;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.hinHSP = hinHSP;
    }

    public Product( String tenSP, int giaSP, String hinHSP) {
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.hinHSP = hinHSP;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(int giaSP) {
        this.giaSP = giaSP;
    }

    public String getHinHSP() {
        return hinHSP;
    }

    public void setHinHSP(String hinHSP) {
        this.hinHSP = hinHSP;
    }

}
