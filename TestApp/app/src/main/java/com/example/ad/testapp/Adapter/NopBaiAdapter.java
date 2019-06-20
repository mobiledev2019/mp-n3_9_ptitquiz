package com.example.ad.testapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ad.testapp.Model.CauHoi;
import com.example.ad.testapp.R;

import java.util.ArrayList;

/**
 * Created by ad on 5/20/2018.
 */

public class NopBaiAdapter extends BaseAdapter{

    private ArrayList<CauHoi> listTraLoi;
    //Dung de keo mot file layout xuong thanh doi tuong view
    private LayoutInflater layoutInflater;
    public NopBaiAdapter(ArrayList<CauHoi> listTraLoi,
                         LayoutInflater
            layoutInflater) {
        this.listTraLoi = listTraLoi;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return listTraLoi.size();
    }

    @Override
    public CauHoi getItem(int i) {
        return listTraLoi.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        NopBaiAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.traloi_item,
                    null);
            holder = new NopBaiAdapter.ViewHolder();

            holder.txtNumAns = convertView.findViewById(R.id.txtNumAns);
            holder.txtTraLoi = convertView.findViewById(R.id.txtTraLoi);
            // Lưu đối tượng holder vào trong viewItem
            convertView.setTag(holder);
        } else {
            holder = (NopBaiAdapter.ViewHolder) convertView.getTag();
        }
        CauHoi tl = listTraLoi.get(position);
        holder.txtNumAns.setText("Câu "+(position+1)+": ");
        holder.txtTraLoi.setText(tl.getDapAnChon());
        return convertView;
    }


    class ViewHolder {
        public TextView txtNumAns,txtTraLoi;
    }

}
