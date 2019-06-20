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
public class LuyenThiFragment extends Fragment {
    private DeThiAdapter adapter;
    private ListView lvDeThi;
    private ArrayList<DeThi> listDeThi = new ArrayList<>();

    public LuyenThiFragment() {
        // Required empty public constructor
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvDeThi = getActivity().findViewById(R.id.lvDeThi);
        listDeThi.add(new DeThi("Đề 1"));
        listDeThi.add(new DeThi("Đề 2"));
        listDeThi.add(new DeThi("Đề 3"));
        listDeThi.add(new DeThi("Đề 4"));
        listDeThi.add(new DeThi("Đề 5"));
        adapter = new DeThiAdapter(listDeThi, getLayoutInflater());
        lvDeThi.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        lvDeThi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("soDe",String.valueOf(i+1));
                intent.putExtra("loaiDe","Test");
                intent.putExtra("thoiGian",60);
                startActivity(intent);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Luyện thi");
        return inflater.inflate(R.layout.fragment_luyen_thi, container, false);
    }

}
