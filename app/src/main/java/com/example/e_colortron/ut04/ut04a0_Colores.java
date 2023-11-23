package com.example.e_colortron.ut04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_colortron.R;

public class ut04a0_Colores extends AppCompatActivity {

    ImageView estrella;
    ut04f0_Colores fragment;
    TextView txt_color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut04a1_colores);

        estrella=findViewById(R.id.ut4a1_imgLanzador);
        txt_color=findViewById(R.id.ut04a1txt_Color);

        fragment=(ut04f0_Colores) getSupportFragmentManager().findFragmentById(R.id.ut04f1fg_color);
        estrella.setOnClickListener((view -> {
            fragment.setColor(0xFF,00,0xFF);
        }));
        fragment.setColorChangeListener((int c)-> txt_color.setText(String.valueOf(c)));
    }
}