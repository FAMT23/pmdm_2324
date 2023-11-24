package com.example.e_colortron.ut04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;

import com.example.e_colortron.R;

public class ut043a_PinPon extends AppCompatActivity {

    TextView tv_resultados, tv_partido2, tv_partido3, tv_partido4;

    ut043f_PinPon frg_marcador1,frg_marcador2,frg_marcador3,frg_marcador4;

    Button btn_reinicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut043a_pin_pon);


        tv_resultados =findViewById(R.id.ut043atv_resultados);
        btn_reinicio=findViewById(R.id.ut043abtn_reinicio);

        frg_marcador1=(ut043f_PinPon) getSupportFragmentManager().findFragmentById(R.id.ut043f_frgEquipo1);
        frg_marcador2=(ut043f_PinPon) getSupportFragmentManager().findFragmentById(R.id.ut043f_frgEquipo2);
        frg_marcador3=(ut043f_PinPon) getSupportFragmentManager().findFragmentById(R.id.ut043f_frgEquipo3);
        frg_marcador4=(ut043f_PinPon) getSupportFragmentManager().findFragmentById(R.id.ut043f_frgEquipo4);

        // Modificamos resultados de la actividad
        frg_marcador1.herramientaCambiarInfo((String info)-> tv_resultados.append(HtmlCompat.fromHtml(info,HtmlCompat.FROM_HTML_MODE_LEGACY)));
        frg_marcador2.herramientaCambiarInfo((String info)-> tv_resultados.append(HtmlCompat.fromHtml(info,HtmlCompat.FROM_HTML_MODE_LEGACY)));
        frg_marcador3.herramientaCambiarInfo((String info)-> tv_resultados.append(HtmlCompat.fromHtml(info,HtmlCompat.FROM_HTML_MODE_LEGACY)));
        frg_marcador4.herramientaCambiarInfo((String info)-> tv_resultados.append(HtmlCompat.fromHtml(info,HtmlCompat.FROM_HTML_MODE_LEGACY)));

        tv_resultados.append("\n\nPartidos  G J1  J2");
        tv_resultados.append("\n__________________");

        btn_reinicio.setOnClickListener(view ->{
            tv_resultados.setText("\n\nPartidos  G J1  J2");
            tv_resultados.append("\n__________________");
            frg_marcador1.reinicioJornada();
            frg_marcador2.reinicioJornada();
            frg_marcador3.reinicioJornada();
            frg_marcador4.reinicioJornada();
        });
    }

    //Aplicamos los nombres a cada uno de los txt del fragment
    protected void onStart(){
        super.onStart();
        frg_marcador1.setText("Partido 1", "J1","J2");
        frg_marcador2.setText("Partido 2", "J3","J4");
        frg_marcador3.setText("Partido 3", "J5","J6");
        frg_marcador4.setText("Partido 4", "J7","J8");

    }
}