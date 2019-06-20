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
public class CppFragment extends Fragment {
    private DeThiAdapter adapterQuizG;
    private ListView lvQuizG;
    private ArrayList<DeThi> listQuizG = new ArrayList<>();

    public CppFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvQuizG = getActivity().findViewById(R.id.lvQuizCpp);
        listQuizG.add(new DeThi("Quiz 1: easy"));
        listQuizG.add(new DeThi("Quiz 2: easy"));
        listQuizG.add(new DeThi("Quiz 3: nomal"));
        listQuizG.add(new DeThi("Quiz 4: hard"));
        listQuizG.add(new DeThi("Quiz 5: hard"));
        adapterQuizG = new DeThiAdapter(listQuizG, getLayoutInflater());
        lvQuizG.setAdapter(adapterQuizG);
        adapterQuizG.notifyDataSetChanged();
        lvQuizG.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("soDe",String.valueOf(i+1));
                intent.putExtra("loaiDe","QuizG");
                intent.putExtra("thoiGian",10);
                //intent.putExtra("soTrang",20);
                startActivity(intent);
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Quiz Cpp");
        return inflater.inflate(R.layout.fragment_cpp, container, false);
    }

}
