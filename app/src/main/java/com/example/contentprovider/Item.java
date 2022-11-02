package com.example.contentprovider;

public class Item {
    private String ten, soDT;

    public Item(String ten, String soDT) {
        this.ten = ten;
        this.soDT = soDT;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
}
