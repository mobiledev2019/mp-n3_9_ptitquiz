package com.example.ad.testapp.View;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ad.testapp.Adapter.DiemAdapter;
import com.example.ad.testapp.Control.LuyenThiController;
import com.example.ad.testapp.MainActivity;
import com.example.ad.testapp.Model.Diem;
import com.example.ad.testapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DSDiemFragment extends Fragment {

private ListView lvDSDiem;
private LuyenThiController luyenThiController;
private DiemAdapter diemAdapter;
private ArrayList<Diem> lists=new ArrayList<>();
    public DSDiemFragment() {
        // Required empty public constructor
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       initView();
       loadDSDiem();
    }
    private void initView(){
        luyenThiController = new LuyenThiController(getActivity());
        lvDSDiem=(ListView) getActivity().findViewById(R.id.lvDSDiem);
    }
    private void loadDSDiem(){
        lists.addAll(luyenThiController.getDSDiem());
        diemAdapter=new DiemAdapter(lists,getLayoutInflater());
        lvDSDiem.setAdapter(diemAdapter);
        diemAdapter.notifyDataSetChanged();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).
                getSupportActionBar().setTitle("Danh sách điểm");
        return inflater.inflate(R.layout.fragment_dsdiem, container, false);
    }

}
