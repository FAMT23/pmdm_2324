package com.example.e_colortron.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.e_colortron.R;

public class ut03e05_A2_Fibonacci extends AppCompatActivity {

    public static final String DATO = "2";
    //Declaramos las variables necesarias.
    TextView tv_resultado;
    Button btn_aceptar;

    int resultado=0,num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k5b_fibonacci);

        //Inicializamos las variables
        tv_resultado=findViewById(R.id.u3a5btv_resultado);
        btn_aceptar=findViewById(R.id.u3a5bbtn_aceptar);

        //Recibimos los exras mediante una variable del tipo Bundle de la otra actividad
        Bundle info=getIntent().getExtras();

        // Desglosamos las variables necesarias de la otra actividad. Podemos obtener distintos tipos de datos get(int, string, boolean...)
        num1=info.getInt(ut03e05_A1_Fibonacci.NUM1);
        num2=info.getInt(ut03e05_A1_Fibonacci.NUM2);

        //Realozamos el cálculo
        resultado=num1+num2;

        //Mostramos el resultado conviertiéndolo a un string que es lo que recibe un TextView
        tv_resultado.setText(Integer.toString (resultado));

        //Devolvemos los datos a la primera acvidad al pulsar aceptar.
        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent datos=new Intent();
                //Indicamos el restulado de nuestra actividad OK para que lo reciba la primera y haga lo que proceda en tal caso.
                setResult(Activity.RESULT_OK,datos);
                // Enviamos los extras necesarios.
                datos.putExtra(DATO,Integer.toString(resultado));
                // Finalizamos la actividad
                finish();
            }
        });


    }
}