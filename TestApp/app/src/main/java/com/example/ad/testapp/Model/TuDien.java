package com.example.ad.testapp.Model;

public class TuDien {
    private int id;
    private String tu,TT,nghia;

    public TuDien() {

    }

    public TuDien(int id, String tu, String TT, String nghia) {
        this.id = id;
        this.tu = tu;
        this.TT = TT;
        this.nghia = nghia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTu() {
        return tu;
    }

    public void setTu(String tu) {
        this.tu = tu;
    }

    public String getTT() {
        return TT;
    }

    public void setTT(String TT) {
        this.TT = TT;
    }

    public String getNghia() {
        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }
}
