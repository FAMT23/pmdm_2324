package com.example.e_colortron.ut03;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.e_colortron.R;

public class ut03e07_A1_Metalslug extends AppCompatActivity {

    Button btn_personaje1,btn_personaje2,btn_arma1,btn_arma2;
    ImageView img_personaje1,img_personaje2,img_arma1,img_arma2;
    private Button[] botonesPersonajes,botonesArmas;
    ActivityResultLauncher<Intent> personajeSeleccionado, armaSeleccionada;
    public static final String ID_JUGADOR="1",ID_ARMA="3";
    public static final String TAG_JUGADOR="2",TAG_ARMA="4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m7a_metalslug);

        img_personaje1=findViewById(R.id.u3a7aimg_personaje1);
        img_personaje2=findViewById(R.id.u3a7aimg_personaje2);
        img_arma1=findViewById(R.id.u3a7aimg_arma1);
        img_arma2=findViewById(R.id.u3a7aimg_arma2);

        btn_personaje1=findViewById(R.id.u3a7abtn_personaje1);
        btn_personaje2=findViewById(R.id.u3a7abtn_personaje2);
        btn_arma1=findViewById(R.id.u3a7abtn_arma1);
        btn_arma2=findViewById(R.id.u3a7abtn_arma2);

        personajeSeleccionado=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                if(result.getResultCode()== Activity.RESULT_OK){
                    Intent personaje=result.getData();
                    // Recuperamos el drawable de la imagen seleccionada
                    String id_judador=personaje.getStringExtra(ut03e05_A2_Metalslug.ID_PERSONAJE);
                    String tag_elegido=personaje.getStringExtra(ut03e05_A2_Metalslug.TAG_ELEGIDO);

                    int img=personaje.getIntExtra(ut03e05_A2_Metalslug.IMG_PERSONAJE,0);
                    //btn_arma1.setText(id_judador);
                    switch (id_judador){
                        case "Jugador 1":
                            img_personaje1.setImageResource(img);
                            //Envío el tag al personaje opuesto para saber cuál tiene seleccionado el otro y reconoderlo.
                            btn_personaje2.setTag(tag_elegido);
                            break;
                        case "Jugador 2":
                            img_personaje2.setImageResource(img);
                            //Envío el tag al personaje opuesto para saber cuál tiene seleccionado el otro y reconoderlo.
                            btn_personaje1.setTag(tag_elegido);
                            break;
                    }
                }
            };
        });
        // Método que indica el jugador que está llamando a la actividad
        BotonesJugador();
        //Asignamos un tag a los botones que nos servirá para identificar las imágenes
        btn_personaje1.setTag("1");
        btn_personaje2.setTag("2");

        // ARMAS
        armaSeleccionada=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                        if(result.getResultCode()== Activity.RESULT_OK){
                            Intent arma=result.getData();
                            // Recuperamos el drawable de la imagen seleccionada
                            String id_judador=arma.getStringExtra(ut03e07_A3_Metalslug.ID_PERSONAJE);
                            String tag_elegido=arma.getStringExtra(ut03e07_A3_Metalslug.TAG_ELEGIDO);
                            int img=arma.getIntExtra(ut03e07_A3_Metalslug.IMG_PERSONAJE,0);
                            //btn_arma1.setText(tag_elegido);
                            switch (id_judador){
                                case "Arma 1":
                                    img_arma1.setImageResource(img);
                                    break;
                                case "Arma 2":
                                    img_arma2.setImageResource(img);
                                    break;
                            }
                        }
                    };
                });
        // Método que indica el jugador que está llamando a la actividad
        BotonesArma();
        //Asignamos un tag a los botones que nos servirá para identificar las imágenes
        btn_arma1.setTag("1");
        btn_arma2.setTag("2");
    }

    // Método para configurar los botones del jugador
    private void BotonesJugador() {
        botonesPersonajes = new Button[]{
                findViewById(R.id.u3a7abtn_personaje1),
                findViewById(R.id.u3a7abtn_personaje2),
                // Agrega más botones aquí
        };
        for (Button boton : botonesPersonajes) {
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i_act1 = new Intent(ut03e07_A1_Metalslug.this, ut03e05_A2_Metalslug.class);
                    // Le pasamos el GetText del botón para saber el jugador que estamos modificando
                    i_act1.putExtra(TAG_JUGADOR,boton.getTag().toString());
                    i_act1.putExtra(ID_JUGADOR,boton.getText());
                    personajeSeleccionado.launch(i_act1);
                }
            });
        }
    }

    //-----------------Botones de la arma
    // Método para configurar los botones del arma
    private void BotonesArma() {
        botonesArmas = new Button[]{
                findViewById(R.id.u3a7abtn_arma1),
                findViewById(R.id.u3a7abtn_arma2),
                // Agrega más botones aquí
        };

        for (Button boton : botonesArmas) {
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i_act2 = new Intent(ut03e07_A1_Metalslug.this, ut03e07_A3_Metalslug.class);
                    // Le pasamos el GetText del botón para saber el jugador que estamos modificando
                    i_act2.putExtra(TAG_ARMA,boton.getTag().toString());
                    i_act2.putExtra(ID_ARMA,boton.getText());
                    armaSeleccionada.launch(i_act2);
                }
            });
        }
    }

}