package com.example.ad.testapp.Adapter;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ad.testapp.Model.TuDien;
import com.example.ad.testapp.R;
import com.example.ad.testapp.View.TuDienFragment;

import java.util.ArrayList;
import java.util.Locale;

public class TuDienAdapter extends BaseAdapter {
    //cái này để nói text
    Context context;
    private ArrayList<TuDien> listTuDien;

    //hàm khởi tạo, truyền context vs list từ điển ở bên ngoài vào
    public TuDienAdapter(Context context, ArrayList<TuDien> listTuDien) {
        this.context = context;
        this.listTuDien = listTuDien;
    }

    //get số lượng list
    @Override
    public int getCount() {
        return listTuDien.size();
    }

    //lấy từ điển ở vị trí nào
    @Override
    public TuDien getItem(int position) {
        return listTuDien.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //ánh xạ view và set sự kiện, data cho view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.tu_item,
                    null);
            holder = new ViewHolder();

            holder.txtTu = convertView.findViewById(R.id.txtTu);
            holder.txtNghia = convertView.findViewById(R.id.txtNghia);
            holder.txtTT = convertView.findViewById(R.id.txtTT);
            // holder.icLoa=convertView.findViewById(R.id.icLoa);
            // Lưu đối tượng holder vào trong viewItem
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

//        set data cho các view
        final TuDien tu = listTuDien.get(position);
        holder.txtTu.setText(tu.getTu());
        holder.txtTT.setText(tu.getTT());
        holder.txtNghia.setText(tu.getNghia());
        return convertView;
    }

    //code viewholder để tối ưu cho dữ liệu

    class ViewHolder {
        public TextView txtTu, txtTT, txtNghia;
    }

}


