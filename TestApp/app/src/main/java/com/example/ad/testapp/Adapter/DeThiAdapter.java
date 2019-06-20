package com.example.ad.testapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ad.testapp.Model.DeThi;
import com.example.ad.testapp.Model.TuDien;
import com.example.ad.testapp.R;


import java.util.ArrayList;

/**
 * Created by ad on 5/18/2018.
 */

public class DeThiAdapter extends BaseAdapter{
    private ArrayList<DeThi> listDe;
    //Dung de keo mot file layout xuong thanh doi tuong view
    private LayoutInflater layoutInflater;
    public DeThiAdapter(ArrayList<DeThi> listDe, LayoutInflater
            layoutInflater) {
        this.listDe = listDe;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return listDe.size();
    }

    @Override
    public DeThi getItem(int i) {
        return listDe.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        DeThiAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.dethi_item,
                    null);
            holder = new DeThiAdapter.ViewHolder();

            holder.txtSoDe = convertView.findViewById(R.id.txtSoDe);
            holder.imgIcon = convertView.findViewById(R.id.imgIcon);
            // Lưu đối tượng holder vào trong viewItem
            convertView.setTag(holder);
        } else {
            holder = (DeThiAdapter.ViewHolder) convertView.getTag();
        }
        DeThi dt = listDe.get(position);
        holder.txtSoDe.setText(dt.getSoDe());
        return convertView;
    }


    class ViewHolder {
        public TextView txtSoDe;
         public ImageView imgIcon;
    }
}


