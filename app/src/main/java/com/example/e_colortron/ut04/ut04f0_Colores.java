package com.example.e_colortron.ut04;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.e_colortron.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ut04f0_Colores#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ut04f0_Colores extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final double COLOR_RANGE = 256;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ut04f0_Colores() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ut04f1_Colores.
     */
    // TODO: Rename and change types and number of parameters
    public static ut04f0_Colores newInstance(String param1, String param2) {
        ut04f0_Colores fragment = new ut04f0_Colores();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView tvColor1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_ut04f1__colores, container, false);
        View layout=inflater.inflate(R.layout.fragment_ut04f1__colores, container, false);

        tvColor1=layout.findViewById(R.id.ut04ftv_Color1);
        tvColor1.setOnClickListener((v)->{
            int c= Color.rgb(
                    (int) (Math.random()*COLOR_RANGE),
                    (int) (Math.random()*COLOR_RANGE),
                    (int) (Math.random()*COLOR_RANGE));
            tvColor1.setBackgroundColor(c);
            if(observer!=null){
                observer.OnColorChange(c);
            }
        });
        return  layout;
    }
    public void setColor(int r, int g, int b){
        tvColor1.setBackgroundColor(Color.rgb(r,g,b));
    }
    public interface ICambioColor{
        public void OnColorChange(int c);
    }
    ICambioColor observer;
    public  void setColorChangeListener(ICambioColor elQueRecibe){
        observer=elQueRecibe;

    }
}