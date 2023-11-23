package com.example.e_colortron.ut04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.e_colortron.R;

public class ut041a_ContadorActividades extends AppCompatActivity {

    ut041f_ContadorActividades frgContadorActividadesT1,frgContadorActividadesT2,frgContadorActividadesT3;
    TextView tarea1,tarea2,tarea3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut04a1_contador_activiades);


        //fragment=(ut040f_Colores) getSupportFragmentManager().findFragmentById(R.id.ut04f1fg_color);
        tarea1=findViewById(R.id.ut041atv_tarea1);
        tarea2=findViewById(R.id.ut041atv_tarea2);
        tarea3=findViewById(R.id.ut041atv_tarea3);


        frgContadorActividadesT1=(ut041f_ContadorActividades) getSupportFragmentManager().findFragmentById(R.id.ut041ftv_frgTarea1);
        frgContadorActividadesT2=(ut041f_ContadorActividades) getSupportFragmentManager().findFragmentById(R.id.ut041ftv_frgTarea2);
        frgContadorActividadesT3=(ut041f_ContadorActividades) getSupportFragmentManager().findFragmentById(R.id.ut041ftv_frgTarea3);

        //Por qué no puedo asignarle un nombre a cada textview del fragment
        //¿Por qué hace falta meterlo en un evento?
        View.OnClickListener manejador=view -> {
            frgContadorActividadesT1.setText("Tarea 1");
            frgContadorActividadesT2.setText("Tarea 2");
            frgContadorActividadesT3.setText("Tarea 3");
        };
        tarea1.setOnClickListener(manejador);
        tarea2.setOnClickListener(manejador);
        tarea3.setOnClickListener(manejador);


        frgContadorActividadesT1.herramientaCambiarInfo((String info)-> tarea1.append(info));
        frgContadorActividadesT2.herramientaCambiarInfo((String info)-> tarea2.append(info));
        frgContadorActividadesT3.herramientaCambiarInfo((String info)-> tarea3.append(info));

    }
}