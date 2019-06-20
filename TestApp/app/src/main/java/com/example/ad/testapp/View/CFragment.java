package com.example.ad.testapp.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ad.testapp.Adapter.DeThiAdapter;
import com.example.ad.testapp.MainActivity;
import com.example.ad.testapp.Model.DeThi;
import com.example.ad.testapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment {
    private DeThiAdapter adapterQuizV;
    private ListView lvQuizV;
    private ArrayList<DeThi> listQuizV = new ArrayList<>();

    public CFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).
                getSupportActionBar().setTitle("Quiz C");
        return inflater.inflate(R.layout.fragment_c, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvQuizV = getActivity().findViewById(R.id.lvQuizC);
        listQuizV.add(new DeThi("Quiz 1"));
        listQuizV.add(new DeThi("Quiz 2"));
        listQuizV.add(new DeThi("Quiz 3"));
        listQuizV.add(new DeThi("Quiz 4"));
        listQuizV.add(new DeThi("Quiz 5"));
        adapterQuizV = new DeThiAdapter(listQuizV, getLayoutInflater());
        lvQuizV.setAdapter(adapterQuizV);
        adapterQuizV.notifyDataSetChanged();
        lvQuizV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("soDe",String.valueOf(i+1));
                intent.putExtra("loaiDe","QuizV");
                intent.putExtra("thoiGian",10);
                //intent.putExtra("soTrang",15);
                startActivity(intent);
            }
        });
    }

}
