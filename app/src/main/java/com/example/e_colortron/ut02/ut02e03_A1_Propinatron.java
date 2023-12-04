package com.example.e_colortron.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.e_colortron.R;

public class ut02e03_A1_Propinatron extends AppCompatActivity {

    View.OnClickListener controlador;
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,btn_6,btn_7, btn_8, btn_9, btn_del, btn_c, btn_generar;
    TextView tv_output, tv_propina;
    RadioButton rdbtn_bueno,rdbtn_excelente;
    RadioGroup rdbtng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcalcula_tron);

        btn_0=findViewById(R.id.u1e3btCero);
        btn_1=findViewById(R.id.u1e3btUno);
        btn_2=findViewById(R.id.u1e3btDos);
        btn_3=findViewById(R.id.u1e3btTres);
        btn_4=findViewById(R.id.u1e3btCuatro);
        btn_5=findViewById(R.id.u1e3btCinco);
        btn_6=findViewById(R.id.u1e3btSeis);
        btn_7=findViewById(R.id.u1e3btSiete);
        btn_8=findViewById(R.id.u1e3btOcho);
        btn_9=findViewById(R.id.u1e3btNueve);
        btn_del=findViewById(R.id.u1e3btDel);
        btn_c=findViewById(R.id.u1e3btClear);
        btn_generar=findViewById(R.id.u1e3btnGenerar);
        tv_output=findViewById(R.id.u1e3tvOutput);
        tv_propina=findViewById(R.id.u1e3tvPropina);
        rdbtng=findViewById(R.id.u1e3rdbtng);
        rdbtn_bueno=findViewById(R.id.u1e3rdbtn_bueno);
        rdbtn_excelente=findViewById(R.id.u1e3rdbtn_excelente);


        //tv_output.setText("uno");
        controlador =new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button bt=(Button) view;
                tv_output.append(bt.getText().toString());
            }
        };

        btn_0.setOnClickListener(controlador);
        btn_1.setOnClickListener(controlador);
        btn_2.setOnClickListener(controlador);
        btn_3.setOnClickListener(controlador);
        btn_4.setOnClickListener(controlador);
        btn_5.setOnClickListener(controlador);
        btn_6.setOnClickListener(controlador);
        btn_7.setOnClickListener(controlador);
        btn_8.setOnClickListener(controlador);
        btn_9.setOnClickListener(controlador);

        btn_generar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!tv_output.getText().toString().isEmpty()){
                    int propina=Integer.parseInt(tv_output.getText().toString());
                    double propina_excelente=1.2;
                    double propina_bueno=1.1;
                    if (rdbtng.getCheckedRadioButtonId()==rdbtn_excelente.getId()){
                        tv_propina.setText(Double.toString(propina*propina_excelente));
                    } else if (rdbtng.getCheckedRadioButtonId()==rdbtn_bueno.getId()) {
                        tv_propina.setText(Double.toString(propina*propina_bueno));
                    }
                    else {
                        tv_propina.setText(Integer.toString(propina));
                    }
                }
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tv_output_length=tv_output.getText().length();
                if (tv_output_length>0){
                    tv_output.setText(tv_output.getText().toString().subSequence(0,tv_output_length-1));
                }
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_output.setText("");
            }
        });


    }
}