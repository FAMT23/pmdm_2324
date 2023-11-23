package com.example.e_colortron.ut04;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.e_colortron.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ut043f_PinPon#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ut043f_PinPon extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int MAX_PUNTOS = 3;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View layout;
    Button btn_fragment1,btn_fragment2;
    int marcador1,marcador2;


    public ut043f_PinPon() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ut043f_PinPon.
     */
    // TODO: Rename and change types and number of parameters
    public static ut043f_PinPon newInstance(String param1, String param2) {
        ut043f_PinPon fragment = new ut043f_PinPon();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_ut043f__pin_pon, container, false);
        btn_fragment1=layout.findViewById(R.id.ut043fbtn_marcador1);
        btn_fragment2=layout.findViewById(R.id.ut043fbtn_marcador2);

        marcador1=0;
        marcador2=0;

        btn_fragment1.setOnClickListener(view -> {
            if(marcador1<MAX_PUNTOS){
                marcador1=marcador1+1;
                btn_fragment1.setText(Integer.toString(marcador1));
            }
            if(marcador1==MAX_PUNTOS){
                btn_fragment1.setBackgroundColor(Color.GREEN);
                btn_fragment2.setClickable(false);
            }
        });

        btn_fragment2.setOnClickListener(view -> {
            if(marcador2<MAX_PUNTOS) {
                marcador2 = marcador2 + 1;
                btn_fragment2.setText(Integer.toString(marcador2));
            }
            if(marcador2==MAX_PUNTOS){
                btn_fragment2.setBackgroundColor(Color.GREEN);
                btn_fragment1.setClickable(false);
            }
        });
        return layout;
    }
}