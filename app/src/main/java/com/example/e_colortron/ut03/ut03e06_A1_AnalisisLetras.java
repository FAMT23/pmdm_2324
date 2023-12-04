package com.example.e_colortron.ut03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.e_colortron.R;


public class ut03e06_A1_AnalisisLetras extends AppCompatActivity {

    // Declaramos las variables necesarias de la actividad
    Button btn_analizar;
    TextView tv_topTres;
    EditText etxt_insertar;
    public  static final String LISTADO_INPUT="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l6a_analisis_letras);

        btn_analizar=findViewById(R.id.u3a6abtn_Analizar);
        tv_topTres=findViewById(R.id.u3a6atv_ListadoTopTres);
        etxt_insertar=findViewById(R.id.u3a6aetxt_InsertarTexto);


        ActivityResultLauncher<Intent> lanzarListado=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()== Activity.RESULT_OK){
                            Intent datos=result.getData();
                            //Ahora nos falta trabajar con estos datos
                            tv_topTres.setText(datos.getStringExtra(ut03e06_A2_AnalisisLetras.LISTADO_OUTPUT));
                        }
                    }
        });

        btn_analizar.setOnClickListener(view -> {
            Intent i=new Intent(this, ut03e06_A2_AnalisisLetras.class);
            i.putExtra(LISTADO_INPUT,etxt_insertar.getText().toString());

            //Vamos a lanzar la actividad con el vagón para que traiga la info
            lanzarListado.launch(i);

        });
    }
}