package com.example.ad.testapp.Model;

/**
 * Created by ad on 5/20/2018.
 */

public class Diem {
    private int id;
    private String ten;
    private String soDe;
    private double tongDiem;

    public Diem() {

    }

    public Diem(String ten, String soDe, double tongDiem) {
        this.ten = ten;
        this.soDe = soDe;
        this.tongDiem = tongDiem;

    }

    public Diem(int id, String ten, String soDe, double tongDiem) {
        this.id = id;
        this.ten = ten;
        this.soDe = soDe;
        this.tongDiem = tongDiem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDe() {
        return soDe;
    }

    public void setSoDe(String soDe) {
        this.soDe = soDe;
    }


    public double getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(double tongDiem) {
        this.tongDiem = tongDiem;
    }
}
