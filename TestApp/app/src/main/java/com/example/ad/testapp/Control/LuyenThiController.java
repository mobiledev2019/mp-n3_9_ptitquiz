package com.example.ad.testapp.Control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

import com.example.ad.testapp.Model.CauHoi;
import com.example.ad.testapp.Model.Diem;
import com.example.ad.testapp.Model.TuDien;

import java.util.ArrayList;

public class LuyenThiController extends SQLiteDataController {

    public LuyenThiController(Context con) {
        super(con);
    }
    public ArrayList<TuDien> getAllTuDien() {
        ArrayList<TuDien> listTuDien = new ArrayList<>();
        try {
            openDataBase();
            String query = "SELECT id , tu, TT," +
                    " nghia  FROM TuDien";
            Cursor cursor = database.rawQuery(query, null);
            // Duyệt lấy ra các bản ghi
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String tu = cursor.getString(1);
                String TT = cursor.getString(2);
                String nghia = cursor.getString(3);
                TuDien tudien = new TuDien(id, tu, TT, nghia);
                listTuDien.add(tudien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return listTuDien;
    }
    public ArrayList<TuDien> searchTu(String s) {
        ArrayList<TuDien> lists = new ArrayList<>();

        try {
            openDataBase();
            String query = "SELECT id , tu, TT, nghia  " +
                    "from TuDien WHERE tu = '"+s+"' ";
            Cursor cursor = database.
                    rawQuery(query, null);

            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String tu = cursor.getString(1);
                String TT = cursor.getString(2);
                String nghia = cursor.getString(3);
                TuDien tudien = new TuDien(id, tu, TT, nghia);
                lists.add(tudien);
            }

            // database.update trả ra id của đối tượng vừa update
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return lists;
    }
    public ArrayList<CauHoi> getAllCauHoi(String so,String loai) {
        ArrayList<CauHoi> listCauHoi = new ArrayList<>();

        try {
            openDataBase();
            String query = "SELECT *FROM tracnghiem WHERE " +
                    "soDe = '"+so+"' AND loaiDe = '"+loai+"'";
            Cursor cursor = database.
                    rawQuery(query,null);

            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String cauhoi = cursor.getString(1);
                String dapAnA = cursor.getString(2);
                String dapAnB = cursor.getString(3);
                String dapAnC = cursor.getString(4);
                String dapAnD = cursor.getString(5);
                String dapAnDung = cursor.getString(6);
                int soDe = cursor.getInt(7);
                String loaiDe = cursor.getString(8);
                CauHoi ch = new CauHoi(id,cauhoi,dapAnA,dapAnB,
                        dapAnC,dapAnD,dapAnDung,soDe,loaiDe,"");
                listCauHoi.add(ch);
            }

            // database.update trả ra id của đối tượng vừa update
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return listCauHoi;
    }
    public boolean themDSDiem(Diem dt) {
        boolean result = false;
        try {
            openDataBase();
            ContentValues values = new ContentValues();
            values.put("ten", dt.getTen());
            values.put("soDe", dt.getSoDe());
            values.put("tongDiem",dt.getTongDiem());
            long rs = database.insert("Diem", null, values);
            if (rs > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result;
    }
    public ArrayList<Diem> getDSDiem() {
        ArrayList<Diem> listDiem = new ArrayList<>();
        try {
            openDataBase();
            String query = "SELECT *FROM Diem";
            Cursor cursor = database.rawQuery(query, null);
            // Duyệt lấy ra các bản ghi
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String ten = cursor.getString(1);
                String soDe = cursor.getString(2);
                double tongDiem = cursor.getDouble(3);
                Diem dt = new Diem(id,ten,soDe,tongDiem);
                listDiem.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return listDiem;
    }
}
