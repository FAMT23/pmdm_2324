package com.example.e_colortron.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.e_colortron.R;

public class ut03e08_A1_MounstroSerializable extends AppCompatActivity {

    Button btn_Mounstro;
    TextView tv_Nombre,tv_Color, tv_Extremidades;
    final  static public String LLAVE="NOMBRE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut03e08_a1_mounstro_serializable);
        btn_Mounstro=findViewById(R.id.ut03e08a1btn_Mounstro);
        tv_Nombre=findViewById(R.id.ut03e08a1etv_MNombre);
        tv_Color=findViewById(R.id.ut03e08a1etv_MColor);
        tv_Extremidades=findViewById(R.id.ut03e08a1etv_MExtremidades);

        //int color=HexTorgb(tv_Color.getText().toString());



        btn_Mounstro.setOnClickListener(view -> {
            Intent datos=new Intent(ut03e08_A1_MounstroSerializable.this,ut03e08_A2_Mounstro.class);
            datos.putExtra(LLAVE, new ut03e08_C1_Mounstro(Integer.parseInt(tv_Extremidades.getText().toString()) ,tv_Nombre.getText().toString(), tv_Color.getText().toString()));
            startActivity(datos);
        });
    }

    /**
     * Converts the given hex-color-string to rgb.
     *
     * @param hex
     * @return
     */
    public static int HexTorgb(String hex) {
        int color = (int) Long.parseLong(hex.replace("#", ""), 16);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = (color >> 0) & 0xFF;
        return Color.rgb(r, g, b);
    }

}