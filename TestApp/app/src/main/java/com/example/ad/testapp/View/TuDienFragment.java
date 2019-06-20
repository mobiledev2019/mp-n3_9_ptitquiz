package com.example.ad.testapp.View;


import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.ad.testapp.Adapter.TuDienAdapter;
import com.example.ad.testapp.Control.LuyenThiController;
import com.example.ad.testapp.MainActivity;
import com.example.ad.testapp.Model.TuDien;
import com.example.ad.testapp.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuDienFragment extends Fragment implements View.OnClickListener{
    private TextToSpeech text;private EditText edtSearch;
    private ImageButton imgSearch;
    private ListView lvTuDien;
    private LuyenThiController luyenThiController;
    private TuDienAdapter adapter;
    private ImageView iconSpeak;
    private ArrayList<TuDien> listTuDien=new ArrayList<>();
    public TuDienFragment() {
        // Required empty public constructor
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
          initView();
          loadTuDien();
        text = new TextToSpeech(getActivity(),
                new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    text.setLanguage(Locale.US);
                }
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgSearch:
                String s=edtSearch.getText().toString();
                listTuDien.clear();
                listTuDien.addAll(luyenThiController.searchTu(s));
                adapter.notifyDataSetChanged();
                iconSpeak.setVisibility(View.VISIBLE);
                break;
            case R.id.iconSpeak:
                String toSpeak = edtSearch.getText().toString();
                text.speak(toSpeak, TextToSpeech.QUEUE_FLUSH
                        , null);
                break;
        }

    }
private void initView(){
    luyenThiController=new LuyenThiController(getActivity());
    edtSearch=getActivity().findViewById(R.id.edtSearch);
    imgSearch=getActivity().findViewById(R.id.imgSearch);
    lvTuDien=getActivity().findViewById(R.id.lvTuDien);
    edtSearch=getActivity().findViewById(R.id.edtSearch);
    imgSearch = getActivity().findViewById(R.id.imgSearch);
    iconSpeak=getActivity().findViewById(R.id.iconSpeak);
    imgSearch.setOnClickListener(this);
    iconSpeak.setOnClickListener(this);
}
private void loadTuDien(){
    listTuDien=luyenThiController.getAllTuDien();
    adapter=new TuDienAdapter(getContext(),listTuDien);
    lvTuDien.setAdapter(adapter);
    adapter.notifyDataSetChanged();
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).
                getSupportActionBar().setTitle("Từ diển");
        return inflater.inflate(R.layout.fragment_tu_dien, container, false);
    }
}
