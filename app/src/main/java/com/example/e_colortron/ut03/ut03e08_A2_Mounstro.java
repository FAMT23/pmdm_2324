package com.example.e_colortron.ut03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.e_colortron.R;

public class ut03e08_A2_Mounstro extends AppCompatActivity {

    TextView tv_mounstro, tv_nombreMounstro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut03e08_a2_mounstro);

        tv_mounstro=findViewById(R.id.ut03e08a2tv_Mounstro);
        tv_nombreMounstro=findViewById(R.id.ut03e08a2tv_MounstroNombre);

        Bundle info=getIntent().getExtras();

        ut03e08_C1_Mounstro mounstro=(ut03e08_C1_Mounstro)getIntent().getSerializableExtra(ut03e08_A1_MounstroSerializable.LLAVE);

        tv_mounstro.setText(mounstro.toString());
        tv_nombreMounstro.setText(mounstro.nombre);
        tv_mounstro.setTextColor(Color.parseColor(mounstro.color));

    }
}