package com.example.ad.testapp.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ad.testapp.Control.LuyenThiController;
import com.example.ad.testapp.Control.SQLiteDataController;
import com.example.ad.testapp.Model.CauHoi;
import com.example.ad.testapp.Model.Diem;
import com.example.ad.testapp.R;

import java.io.IOException;
import java.util.ArrayList;

public class XemDiemActivity extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<CauHoi> lists = new ArrayList<>();
    private int cauDung=0;
    private int cauSai=0;
    private double tongDiem=0;
    private TextView txtDung,txtSai,txtTongDiem;
    private Button btnLuuDiem;
    private ImageView iconThoat;
    private LuyenThiController luyenThiController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_diem);
        this.getSupportActionBar().setTitle("Xem điểm");
        initView();
        getDataFromFragment();
        getKetQua();
        iconThoat.setOnClickListener(this);
        btnLuuDiem.setOnClickListener(this);
    }
    private void initView(){
        luyenThiController=new LuyenThiController(this);
        iconThoat=findViewById(R.id.iconThoat);
        btnLuuDiem=findViewById(R.id.btnLuuDiem);
        txtDung=findViewById(R.id.txtDung);
        txtSai=findViewById(R.id.txtSai);
        txtTongDiem=findViewById(R.id.txtTongDiem);
    }
    private void getDataFromFragment(){
        Intent intent= getIntent();
        lists= (ArrayList<CauHoi>) intent.getExtras().
                getSerializable("listCauHoi");
    }
    private void getKetQua(){
        for (CauHoi i: lists){
            if(i.getDapAnDung().equals
                    (i.getDapAnChon())==true){
                cauDung++;
            }else cauSai++;
        }
        tongDiem=cauDung*0.2;
        txtDung.setText(""+cauDung);
        txtSai.setText(""+cauSai);
        txtTongDiem.setText(""+tongDiem);
    }
    private void luuDiem(){
        final AlertDialog.Builder builder=new AlertDialog.Builder
                (XemDiemActivity.this);
        //  LayoutInflater inflater=XemDiemActivity.this.getLayoutInflater();
        View view = getLayoutInflater().
                inflate(R.layout.dialog_luudiem,null);
        builder.setView(view);
        final EditText edtName=  view.findViewById(R.id.edtName);
        TextView txtPoint = view.findViewById(R.id.txtPoint);
        final TextView txtNumTest = view.findViewById(R.id.txtNumTest);
        final double numTotal= cauDung*0.2;
        txtPoint.setText(numTotal+" điểm");
        txtNumTest.setText(lists.get(0).getLoaiDe()+" "+lists.get(0).getSoDe());
        builder.setPositiveButton("Lưu điểm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String ten= edtName.getText().toString();
                String soDe= txtNumTest.getText().toString();
                Diem dt = new Diem(ten,soDe,numTotal);
                luyenThiController.themDSDiem(dt);
                Toast.makeText(XemDiemActivity.this,
                        "Lưu điểm thành công!",Toast.LENGTH_LONG).show();
                finish();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iconThoat:
                finish();
                break;
            case R.id.btnLuuDiem:
                luuDiem();
                break;
        }
    }
}
