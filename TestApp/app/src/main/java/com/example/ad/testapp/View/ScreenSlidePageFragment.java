package com.example.ad.testapp.View;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ad.testapp.Model.CauHoi;
import com.example.ad.testapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {
     ArrayList<CauHoi>listCauHoi = new ArrayList<>();
    private int curPageNum;
    private int nopBai;
    private TextView txtNum,txtQues;
    private RadioGroup radioGroup;
    private RadioButton radA, radB, radC, radD;
    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container,
                false);
        txtNum = (TextView) rootView.findViewById(R.id.txtNum);
        txtQues = (TextView) rootView.findViewById(R.id.txtQues);
        radA = (RadioButton) rootView.findViewById(R.id.radA);
        radB = (RadioButton) rootView.findViewById(R.id.radB);
        radC = (RadioButton) rootView.findViewById(R.id.radC);
        radD = (RadioButton) rootView.findViewById(R.id.radD);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radGroup);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenSlideActivity slideActivity = (ScreenSlideActivity)
                getActivity();
        listCauHoi = slideActivity.getData();
        curPageNum= getArguments().getInt("pageNumber");
        nopBai=getArguments().getInt("nopBai");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtNum.setText("Question "+(curPageNum+1)+": ");
        radA.setText(listCauHoi.get(curPageNum).getDapAnA());
        txtQues.setText(listCauHoi.get(curPageNum).getCauhoi());
        radB.setText(listCauHoi.get(curPageNum).getDapAnB());
        radC.setText(listCauHoi.get(curPageNum).getDapAnC());
        radD.setText(listCauHoi.get(curPageNum).getDapAnD());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                listCauHoi.get(curPageNum).choiceID = checkedId;
                listCauHoi.get(curPageNum).setDapAnChon(getDapAnChon(checkedId));
            }
        });
        if(nopBai!=0){
            radA.setClickable(false);
            radB.setClickable(false);
            radC.setClickable(false);
            radD.setClickable(false);
            getDapAnDung(listCauHoi.get(curPageNum).getDapAnDung().toString());
        }
    }
    private String getDapAnChon(int id) {
        if (id == R.id.radA) {
            return "A";
        } else if (id == R.id.radB) {
            return "B";
        } else if (id == R.id.radC) {
            return "C";
        } else if (id == R.id.radD) {
            return "D";
        }
        else return "";
    }
    private void getDapAnDung(String tl){
        if(tl.equals("A")==true){
        radA.setTextColor(Color.RED);
        }
        else if(tl.equals("B")==true){
            radB.setTextColor(Color.RED);
        }else if(tl.equals("C")==true){
            radC.setTextColor(Color.RED);
        }else if(tl.equals("D")==true){
            radD.setTextColor(Color.RED);
        }else ;
    }

    public static ScreenSlidePageFragment create(int pageNumber,
                                                 int nopBai) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pageNumber",pageNumber);
        bundle.putInt("nopBai",nopBai);
        fragment.setArguments(bundle);
        return fragment;
    }
}
