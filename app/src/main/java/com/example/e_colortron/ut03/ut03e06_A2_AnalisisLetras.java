package com.example.e_colortron.ut03;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.e_colortron.R;

import java.util.LinkedHashMap;

public class ut03e06_A2_AnalisisLetras extends AppCompatActivity {

    Button btn_finalizar;
    TextView tv_listadoOutput;

    String listadoOriginal="";
    String listadoOutput="";
    String listadoTopTres="";

    List<Map.Entry<String, Integer> > lista;

    public static final String LISTADO_OUTPUT="1";
    int ELEMENTOS_MAX=3;
    int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l6b_analisis_letras);

        btn_finalizar=findViewById(R.id.u3a6bbtn_Finalizar);
        tv_listadoOutput=findViewById(R.id.u3a6btv_listadoOrdenado);

        Bundle info=getIntent().getExtras();
        listadoOriginal=info.getString(ut03e06_A1_AnalisisLetras.LISTADO_INPUT);

        // https://www.geeksforgeeks.org/java-program-to-sort-linkedhashmap-by-values/
        LinkedHashMap<String, Integer> lhm_letras = new LinkedHashMap<>();

        String letra;
        for (int i=0;i<listadoOriginal.length();i++){
            //listadoOutput=listadoOutput+listadoOriginal.substring(i,i+1)+"\n";
            letra = listadoOriginal.substring(i,i+1);

            if (lhm_letras.containsKey(letra)){
                lhm_letras.put(letra,lhm_letras.get(letra)+1);
            }
            else{
                lhm_letras.put(letra,1);
            };
        }

        //Creamos un set para obtener todas las claves y poder recorrerlas
        //https://www.geeksforgeeks.org/how-to-iterate-linkedhashmap-in-java/
        Set<String> claves = lhm_letras.keySet();

        //

        lista  = new ArrayList<Map.Entry<String, Integer> >(lhm_letras.entrySet());

        /*
        Collections.sort(
                lista,
                new Comparator<Map.Entry<String, Integer> >() {
                    // Comparing two entries by value
                    public int compare(
                            Map.Entry<String, Integer> entry1,
                            Map.Entry<String, Integer> entry2)
                    {
                        // Subtracting the entries
                        return entry2.getValue()-entry1.getValue();
                    }
                });
        */

        // Aplicando Lambda
        Collections.sort(
                lista,(l1,l2)->{
                    int resultado=l2.getValue()-l1.getValue();
                    return  resultado;
                });

        for (Map.Entry<String, Integer> l:lista) {
            listadoOutput=listadoOutput+l.getKey()+" -- "+l.getValue()+"\n";
            if(contador<3){
                listadoTopTres=listadoTopTres+l.getKey()+" -- "+l.getValue()+"\n";
                contador++;
            }
        }

        //tv_listadoOutput.setText(listadoOriginal);
        tv_listadoOutput.setText(listadoOutput);

        btn_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Ojo que este new intent no llama a ninuna otra actividad nueva, devuelve datos a la primera
                Intent i=new Intent();
                setResult(Activity.RESULT_OK,i);
                i.putExtra(LISTADO_OUTPUT,listadoTopTres);
                finish();

            }
        });
    }
}