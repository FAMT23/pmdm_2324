package com.example.e_colortron.ut04;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.e_colortron.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ut041f_ContadorActividades#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ut041f_ContadorActividades extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView tv_fragment;

    View layout;
    public ut041f_ContadorActividades() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ut041f_ContadorActividades.
     */
    // TODO: Rename and change types and number of parameters
    public static ut041f_ContadorActividades newInstance(String param1, String param2) {
        ut041f_ContadorActividades fragment = new ut041f_ContadorActividades();
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
        layout= inflater.inflate(R.layout.fragment_ut041f__contador_actividades, container, false);
        tv_fragment=layout.findViewById(R.id.ut043f_fragment);

        tv_fragment.setOnClickListener((view -> {
            //tv_fragment.setBackgroundColor(Color.RED);

            if(cambiador!=null){
                cambiador.cambiaInfo("|");
            }
        }));

        return layout;
    }

    public interface enviaInfo{
        public void cambiaInfo(String info);
    }

    enviaInfo cambiador;
    public  void herramientaCambiarInfo(enviaInfo receptorInfo){
        cambiador=receptorInfo;
    }

    public void setText(String txt){
        this.tv_fragment.setText(txt);
    }
}