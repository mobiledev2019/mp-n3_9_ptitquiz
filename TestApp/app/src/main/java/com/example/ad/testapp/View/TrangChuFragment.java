package com.example.ad.testapp.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ad.testapp.MainActivity;
import com.example.ad.testapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrangChuFragment extends Fragment {


    public TrangChuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).
                getSupportActionBar().setTitle("Trang chủ");
        return inflater.inflate(R.layout.fragment_trang_chu, container, false);
    }

}
