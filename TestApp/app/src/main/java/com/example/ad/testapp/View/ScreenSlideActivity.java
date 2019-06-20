package com.example.ad.testapp.View;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ad.testapp.Adapter.NopBaiAdapter;
import com.example.ad.testapp.Control.LuyenThiController;
import com.example.ad.testapp.Model.CauHoi;
import com.example.ad.testapp.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ScreenSlideActivity extends FragmentActivity implements View.OnClickListener{
    private static int soTrang=50;
    private ViewPager mPager;
    private Button btnThoat,btnNopBai;
    private PagerAdapter mPagerAdapter;
    private NopBaiAdapter adapter;
    private GridView gvTraLoi;
    private int nopBai=0;
    private LuyenThiController luyenThiController;
    private   ArrayList<CauHoi> listCauHoi = new ArrayList<>();
    private TextView txtTimer,txtNopBai,txtDiem;
    private ImageView iconThoat;
    private AlertDialog dialog;
    // private CounterClass timer;
    private CountDownTimer timer;
    private String loaiDe;
    private String soDe;
    private int thoiGian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        initView();
        getDataFromFragment();
        loadCauHoi();
        startClock();
        txtNopBai.setOnClickListener(this);
        txtDiem.setOnClickListener(this);
        iconThoat.setOnClickListener(this);
    }
    private void initView(){
        mPager = (ViewPager) findViewById(R.id.pager);
        txtNopBai=findViewById(R.id.txtNopBai);
        txtTimer=findViewById(R.id.txtTimer);
        txtDiem=findViewById(R.id.txtDiem);
        iconThoat = findViewById(R.id.iconThoat);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true,
                new DepthPageTransformer());
    }
    private void getDataFromFragment(){
        Intent intent = getIntent();
        loaiDe = intent.getStringExtra("loaiDe");
        soDe = intent.getStringExtra("soDe");
        thoiGian=intent.getIntExtra("thoiGian",0);
    }
    private void loadCauHoi(){
        luyenThiController=new LuyenThiController(this);
        listCauHoi=luyenThiController.getAllCauHoi(soDe,loaiDe);
    }
    private void startClock(){
       /* timer = new CounterClass(1 * 60*1000,
                1000);
        timer.start();*/
        timer = new CountDownTimer(thoiGian*60*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                //SetText cho textview hiện thị thời gian.
                txtTimer.setText(countTime);
            }

            @Override
            public void onFinish() {
                TextView txtDialog = new TextView(ScreenSlideActivity.this);
                Dialog dialogtime = new Dialog(ScreenSlideActivity.this);
                dialogtime.setContentView(txtDialog);
                dialogtime.setTitle("Hết thời gian làm bài");
                txtTimer.setText("00:00");
                stopTest();
                dialogtime.show();
            }
        }.start();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtNopBai:
                kiemTraDapAn();
                break;
            case R.id.txtDiem:
                finish();
                Intent xemDiem = new Intent(ScreenSlideActivity.this,
                        XemDiemActivity.class);
                xemDiem.putExtra("listCauHoi", listCauHoi);
                startActivity(xemDiem);
                break;
            case R.id.iconThoat:
                mPager.setCurrentItem(0);
                onBackPressed();
                break;
        }
    }

    public void kiemTraDapAn(){
        final AlertDialog.Builder builder=new AlertDialog.Builder
                (ScreenSlideActivity.this);
        //  LayoutInflater inflater=XemDiemActivity.this.getLayoutInflater();
        View view = getLayoutInflater().
                inflate(R.layout.dialog_kiemtra,null);
        builder.setView(view);
        builder.setTitle("Danh sách câu trả lời");
        gvTraLoi = view.findViewById(R.id.gvTraLoi);
        adapter = new NopBaiAdapter(listCauHoi,getLayoutInflater());
        gvTraLoi.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        gvTraLoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPager.setCurrentItem(position);
                dialog.dismiss();
            }
        });
        btnNopBai=view.findViewById(R.id.btnNopBai);
        btnThoat=view.findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnNopBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                stopTest();
                dialog.dismiss();
            }
        });
        dialog= builder.create();
        dialog.show();
    }
    public void stopTest() {
        nopBai = 1;
        mPager.setCurrentItem(0);
        txtDiem.setVisibility(View.VISIBLE);
        txtNopBai.setVisibility(View.GONE);
    }

    public ArrayList<CauHoi> getData(){
        return listCauHoi;
    }
    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            thoat();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }
    public void thoat(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(ScreenSlideActivity.this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn thoát không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                timer.cancel();
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
    }
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position,nopBai);
        }

        @Override
        public int getCount() {
            return soTrang;
        }
    }
    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}
