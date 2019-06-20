package com.example.ad.testapp.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.ad.testapp.Model.Diem;
import com.example.ad.testapp.R;
import java.util.ArrayList;

public class DiemAdapter extends BaseAdapter {

    private ArrayList<Diem> listDiem;
    //Dung de keo mot file layout xuong thanh doi tuong view
    private LayoutInflater layoutInflater;
    public DiemAdapter(ArrayList<Diem> listDiem, LayoutInflater
            layoutInflater) {
        this.listDiem = listDiem;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return listDiem.size();
    }

    @Override
    public Diem getItem(int i) {
        return listDiem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        DiemAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.dsdiem_item,
                    null);
            holder = new DiemAdapter.ViewHolder();
            holder.txtdiemBaiThi=convertView.findViewById(R.id.txtdiemBaiThi);
            holder.txtTenHS = convertView.findViewById(R.id.txtTenHS);
            holder.txtsoDeThi = convertView.findViewById(R.id.txtsoDeThi);
            // Lưu đối tượng holder vào trong viewItem
            convertView.setTag(holder);
        } else {
            holder = (DiemAdapter.ViewHolder) convertView.getTag();
        }
        Diem dt = listDiem.get(position);
        holder.txtTenHS.setText(dt.getTen());
        holder.txtsoDeThi.setText(String.valueOf(dt.getSoDe()));
        holder.txtdiemBaiThi.setText(String.valueOf(dt.getTongDiem()));
        return convertView;
    }


    class ViewHolder {
        public TextView txtTenHS,txtsoDeThi,txtdiemBaiThi;
    }
}
