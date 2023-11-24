package com.example.e_colortron.ut04;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    private static final String VERDE_GANADOR = "#09738a";
    private static final float BOTON_TRANSPARENCIA = 0.2f;
    private static final String AMARILLO_PERDEDOR ="#f0a818" ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View layout;
    Button btn_fragment1,btn_fragment2;
    int marcador1,marcador2;
    TextView tv_partido,tv_jugador1,tv_jugador2;


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
        tv_partido =layout.findViewById(R.id.ut043ftv_fragment);
        tv_jugador1=layout.findViewById(R.id.ut043ftv_frgJugador1);
        tv_jugador2=layout.findViewById(R.id.ut043ftv_frgJugador2);

        marcador1=0;
        marcador2=0;

        btn_fragment1.setOnClickListener(view -> {
            if(marcador1<MAX_PUNTOS){
                marcador1=marcador1+1;
                btn_fragment1.setText(Integer.toString(marcador1));
            }
            if(marcador1==MAX_PUNTOS){
                btn_fragment1.setTextColor(Color.parseColor(VERDE_GANADOR));
                btn_fragment2.setTextColor(Color.parseColor(AMARILLO_PERDEDOR));
                btn_fragment1.setAlpha(BOTON_TRANSPARENCIA);
                btn_fragment2.setAlpha(BOTON_TRANSPARENCIA);
                btn_fragment2.setClickable(false);
                btn_fragment1.setClickable(false);
                if(cambiador!=null){
                    cambiador.cambiaInfo(
                                    "<br>"+tv_partido.getText()+
                                    " "+tv_jugador1.getText()+
                                    "<b> "+marcador1+
                                    "</b> | "+marcador2);
                }
            }
        });

        btn_fragment2.setOnClickListener(view -> {
            if(marcador2<MAX_PUNTOS) {
                marcador2 = marcador2 + 1;
                btn_fragment2.setText(Integer.toString(marcador2));

            }
            if(marcador2==MAX_PUNTOS){
                btn_fragment2.setTextColor(Color.parseColor(VERDE_GANADOR));
                btn_fragment1.setTextColor(Color.parseColor(AMARILLO_PERDEDOR));
                btn_fragment1.setAlpha(BOTON_TRANSPARENCIA);
                btn_fragment2.setAlpha(BOTON_TRANSPARENCIA);
                btn_fragment1.setClickable(false);
                btn_fragment2.setClickable(false);

                if(cambiador!=null){
                    cambiador.cambiaInfo(
                                    "<br> "+tv_partido.getText()+
                                    " "+tv_jugador2.getText()+
                                    " "+marcador1+" | <b>"+
                                    marcador2+"</b>");
                }
            }
        });

        return layout;
    }

    public interface enviaInfo{
        public void cambiaInfo(String info);
    }

    enviaInfo cambiador;
    public  void herramientaCambiarInfo(enviaInfo receptorInfo){
        cambiador=receptorInfo;
    }

    public void setText(String txt,String txt_j1, String txt_j2){
        tv_partido.setText(txt);
        tv_jugador1.setText(txt_j1);
        tv_jugador2.setText(txt_j2);
    }

    public  void reinicioJornada(){
        marcador2=0;
        marcador1=0;
        btn_fragment1.setText("0");
        btn_fragment2.setText("0");
        btn_fragment1.setClickable(true);
        btn_fragment2.setClickable(true);
        btn_fragment1.setTextColor(Color.WHITE);
        btn_fragment2.setTextColor(Color.WHITE);
        btn_fragment1.setAlpha(1f);
        btn_fragment2.setAlpha(1f);

    }
}