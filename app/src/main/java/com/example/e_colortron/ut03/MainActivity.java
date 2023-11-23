package com.example.e_colortron.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.e_colortron.R;

public class MainActivity extends AppCompatActivity {


    SeekBar sb_red, sb_green, sb_blue;
    TextView tv_output;
    EditText etxt_input;
    CheckedTextView chtxt_turn;
    Button bt_generar;
    Switch st_blanco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        sb_red=findViewById(R.id.u1e2sbRed);
        sb_green=findViewById(R.id.u1e2sbGreen);
        sb_blue=findViewById(R.id.u1e2sbBlue);

        etxt_input=findViewById(R.id.u1e2etxtInput);
        tv_output=findViewById(R.id.u1e2tvOutput);
        bt_generar=findViewById(R.id.u1e2btbGenerar);

        st_blanco=findViewById(R.id.u1e2stBlanco);

        bt_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int r,g,b,color,colorBlanco,ColorNegro;
                String texto;
                boolean fontColor;
                r=sb_red.getProgress();
                g=sb_green.getProgress();
                b=sb_blue.getProgress();
                color= Color.rgb(r,g,b);
                colorBlanco=Color.rgb(255,255,255);
                ColorNegro=Color.rgb(0,0,0);


                if (st_blanco.isChecked()){
                    tv_output.setTextColor(colorBlanco);
                }else{
                    tv_output.setTextColor(ColorNegro);
                }
                texto=etxt_input.getText().toString();

                tv_output.setBackgroundColor(color);
                tv_output.setText(texto);



            }
        });



    }
}