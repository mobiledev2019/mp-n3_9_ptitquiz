package com.example.ad.testapp.Model;

import java.io.Serializable;

public class CauHoi implements Serializable{
    private  int id;
    private  String cauhoi;
    private  String dapAnA;
    private  String dapAnB;
    private  String dapAnC;
    private  String dapAnD;
    private  String dapAnDung;
    private  int soDe;
    private String loaiDe;
    private String dapAnChon="";
    public int choiceID= -1;

    public CauHoi() {
    }

    public CauHoi(int id, String cauhoi, String dapAnA, String dapAnB,
                  String dapAnC, String dapAnD, String dapAnDung,
                  int soDe,String loaiDe,String dapAnChon) {
        this.id = id;
        this.cauhoi = cauhoi;
        this.dapAnA = dapAnA;
        this.dapAnB = dapAnB;
        this.dapAnC = dapAnC;
        this.dapAnD = dapAnD;
        this.dapAnDung = dapAnDung;
        this.soDe = soDe;
        this.loaiDe=loaiDe;
        this.dapAnChon=dapAnChon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getDapAnA() {
        return dapAnA;
    }

    public void setDapAnA(String dapAnA) {
        this.dapAnA = dapAnA;
    }

    public String getDapAnB() {
        return dapAnB;
    }

    public void setDapAnB(String dapAnB) {
        this.dapAnB = dapAnB;
    }

    public String getDapAnC() {
        return dapAnC;
    }

    public void setDapAnC(String dapAnC) {
        this.dapAnC = dapAnC;
    }

    public String getDapAnD() {
        return dapAnD;
    }

    public void setDapAnD(String dapAnD) {
        this.dapAnD = dapAnD;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public int getSoDe() {
        return soDe;
    }

    public void setSoDe(int soDe) {
        this.soDe = soDe;
    }

    public String getLoaiDe() {
        return loaiDe;
    }

    public void setLoaiDe(String loaiDe) {
        this.loaiDe = loaiDe;
    }

    public String getDapAnChon() {
        return dapAnChon;
    }

    public void setDapAnChon(String dapAnChon) {
        this.dapAnChon = dapAnChon;
    }
}
