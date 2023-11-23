package com.example.e_colortron.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.e_colortron.R;

public class j_helados_lanzarDatosEntreActividades extends AppCompatActivity {

    Spinner spinner;
    Button btn_generar;
    EditText etv_uds_Chocolate,etv_uds_Fresa,etv_uds_Vainilla;

    //¿?Se le pueden pasar más parámetros de alguna forma sin tener que declararlos todos?
    public static final String SELECCION = "0";
    public static final String SABORCHOCOLATE= "Chocolate";
    public static final String SABORFRESA = "Fresa";
    public static final String SABORVAINILLA = "Vainilla";
    public  static String seleccion="4";
    public  static String seleccion2="2";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jhelados_lanzar_datos_entre_actividades);

        //Identificamos las variables
        spinner=findViewById(R.id.u1e8spnTipoHelado);
        btn_generar=findViewById(R.id.u1e8btnGenerar);
        etv_uds_Chocolate=findViewById(R.id.u1e8etvUdsChocolate);
        etv_uds_Fresa=findViewById(R.id.u1e8etvUdsFresa);
        etv_uds_Vainilla=findViewById(R.id.u1e8etvUdsVainilla);

        // Creamos un ArrayAdapter usando el array creado en el String.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_tipoHelado, android.R.layout.simple_spinner_item);
        // Indicamos el diseño de la vista del desplegable
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Aplicamos esos paramostros al spinner
        spinner.setAdapter(adapter);
        //Ahora tendremos que capturar la elección del usuario.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long l) {
                seleccion =adapterView.getItemAtPosition(posicion).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_generar.setOnClickListener(view -> {
                Intent i=new Intent(this, j_helados_lanzadaDatosEntreActividades.class);
                i.putExtra(SELECCION,seleccion);
                i.putExtra(SABORCHOCOLATE,etv_uds_Chocolate.getText().toString());
                i.putExtra(SABORFRESA,etv_uds_Fresa.getText().toString());
                i.putExtra(SABORVAINILLA,etv_uds_Vainilla.getText().toString());
                startActivity(i);
        });
    }
}