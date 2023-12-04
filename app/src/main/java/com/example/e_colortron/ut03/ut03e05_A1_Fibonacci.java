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
import android.widget.TextView;

import com.example.e_colortron.R;

public class ut03e05_A1_Fibonacci extends AppCompatActivity {

    //Declaramos variables necesarias.
    Button btn_siguiente;
    TextView tv_n1, tv_n2;

    //Debemos declararlas e inicializarlas con un valor distinto a cada una
    public static final String NUM1 = "1";
    public static final String NUM2 = "2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k5a_fibonacci);
        // Inicializamos las variables accediendo a las vistas creadas en el layout mediante findViewByID

        btn_siguiente=findViewById(R.id.u3a5abtn_siguiente);

        tv_n1=findViewById(R.id.u3a5atv_num1);
        tv_n2=findViewById(R.id.u3a5atv_num2);

        // El retorno de los datos de la segunda actividad
        ActivityResultLauncher<Intent> lanzaDatos = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // Verificamos si la actividad da como resultado OK o KO para realizar o no una acción.
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // Declaramos una variable de tipo Intent y le pasamos los datos generados en la segunda actividad
                            Intent datos = result.getData();
                            //Modificamos en nuestra actividad lo que deseemos con esos datos obtenidos de la segunda actividad.
                            tv_n1.setText(tv_n2.getText().toString());
                            tv_n2.setText(datos.getStringExtra(ut03e05_A2_Fibonacci.DATO));
                        }
                    }
                });

        //  Evento que genera el intent que que lanza los datos a la segunda actividad.
        btn_siguiente.setOnClickListener(view -> {

            Intent i=new Intent(this, ut03e05_A2_Fibonacci.class);
            i.putExtra(NUM1,Integer.parseInt(tv_n1.getText().toString()) );
            i.putExtra(NUM2,Integer.parseInt(tv_n2.getText().toString()) );

            // Lanzamos la actividad que contendrá datos de vuelta.
            lanzaDatos.launch(i);

        });

    }
}