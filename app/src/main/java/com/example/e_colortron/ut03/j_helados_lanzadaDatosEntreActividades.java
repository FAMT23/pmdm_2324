package com.example.e_colortron.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.e_colortron.R;

public class j_helados_lanzadaDatosEntreActividades extends AppCompatActivity {

    TextView tv_datoLanzado, tv_saboresLanzados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jhelados_lanzada_datos_entre_actividades);

        tv_datoLanzado=findViewById(R.id.u1e8a2tvDatoLanzado);
        tv_saboresLanzados=findViewById(R.id.u1e8a2tvSaboresLanzado);

        Bundle info=getIntent().getExtras();

        String seleccion=info.getString(j_helados_lanzarDatosEntreActividades.SELECCION);
        String uds_chco=info.getString(j_helados_lanzarDatosEntreActividades.SABORCHOCOLATE);
        String uds_fresa=info.getString(j_helados_lanzarDatosEntreActividades.SABORFRESA);
        String uds_vainilla=info.getString(j_helados_lanzarDatosEntreActividades.SABORVAINILLA);
        String opcion="";

        String [] udsSabores={uds_chco,uds_fresa,uds_vainilla};
        String [] sabores={"Chocolate","Fresa","Vainilla"};
        Object sChoco=info.get(j_helados_lanzarDatosEntreActividades.SABORCHOCOLATE);
        String saboresLista=uds_helados(udsSabores,sabores);

        if(seleccion.toString().toUpperCase().equals("CUCURUCHO")){
            opcion="\\/ \n";
            tv_datoLanzado.setText(opcion);
            tv_saboresLanzados.setText(saboresLista);
        } else if (seleccion.toString().toUpperCase().equals("CUCUCHOCO")){
            opcion="\\/ \n";
            tv_datoLanzado.setText(opcion);
            tv_saboresLanzados.setText(saboresLista);
            tv_datoLanzado.setTextColor(Color.rgb(139,69,19));
        }else{
            opcion="U\n"+uds_helados(udsSabores,sabores);
            tv_datoLanzado.setText(opcion);
            tv_saboresLanzados.setText(saboresLista);
            ;}
    }

    public static String uds_helados(String[] uds, String[] sabores)
    {
        String total ="";
        for(int i=0;i<uds.length;i++)
        {
            total=total+sabores[i]+" "+uds[i]+"\n";
        }
        return total;
    }
}