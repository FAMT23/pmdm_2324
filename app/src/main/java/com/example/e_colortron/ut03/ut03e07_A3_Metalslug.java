package com.example.e_colortron.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.e_colortron.R;

public class ut03e07_A3_Metalslug extends AppCompatActivity {

    ImageView iv_a1,iv_a2,iv_a3,iv_a4;
    Button btn_aceptar,btn_limpiar;

    String tagElegido;

    int personaje_elegido;
    View.OnClickListener controladorTag;

    public static final String IMG_PERSONAJE="1";
    public static final String ID_PERSONAJE="2";
    public static final String TAG_ELEGIDO="3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m7c_metalslug);
        //--------

        btn_aceptar=findViewById(R.id.u3a7cbtn_aceptar);
        btn_limpiar=findViewById(R.id.u3a7cbtn_limpiar);

        iv_a1=findViewById(R.id.u3a7cbtn_img_a1);
        iv_a2=findViewById(R.id.u3a7cbtn_img_a2);
        iv_a3=findViewById(R.id.u3a7cbtn_img_a3);
        iv_a4=findViewById(R.id.u3a7cbtn_img_a4);

        // Asigamos tags a cada una de las imágenes para poder reconocerlas
        iv_a1.setTag("A1");
        iv_a2.setTag("A2");
        iv_a3.setTag("A3");
        iv_a4.setTag("A4");

        //Recibimos el jugador (1 o 2) que está seleccionando personaje y su tag del personaje inverso para poder bloquearlo.
        Bundle info_jugador=getIntent().getExtras();
        String id_jugador=info_jugador.getString(ut03e07_A1_Metalslug.ID_ARMA);
        String tag_jugador=info_jugador.getString(ut03e07_A1_Metalslug.TAG_ARMA);



        // Posibles errores
        //Qué pasa si entra y no seleciona ningún personaje después de haber seleccionado un jugador uno ya.

        btn_limpiar.setOnClickListener(view -> {
            tagElegido="Limpiar";
        });

        // Si entro y no selecciona se indicará el personaje por defecto. Puesto que indico que el tag es null y mando como KO la actividad
        tagElegido= null;
        btn_aceptar.setOnClickListener(view -> {
            Intent arma=new Intent();

            // Dejamos el que está por defecto en caso de que no se haya seleccionado ninguno y se de al botón aceptar.
            if (tagElegido==null){
                // Poder verificar que si no hemos clicado sobre ningún personaje no aplique cambios.
                setResult(Activity.RESULT_CANCELED,arma);
                finish();
            } else if (tagElegido.equals("Limpiar")) {
                // Poder verificar si tengo que limpiar el jugador seleccionado
                personaje_elegido=R.drawable.ic_launcher_foreground;
                setResult(Activity.RESULT_OK,arma);
                arma.putExtra(ID_PERSONAJE,id_jugador);
                arma.putExtra(TAG_ELEGIDO,tagElegido);
                arma.putExtra(IMG_PERSONAJE,personaje_elegido);
                finish();

            } else{
                switch (tagElegido){
                    case "A1":
                        personaje_elegido=R.drawable.a1;
                        break;
                    case "A2":
                        personaje_elegido=R.drawable.a2;
                        break;
                    case "A3":
                        personaje_elegido=R.drawable.a3;
                        break;
                    case "A4":
                        personaje_elegido=R.drawable.a4;
                        break;
                    default:
                        personaje_elegido=R.drawable.a1;
                        break;
                }
                setResult(Activity.RESULT_OK,arma);
                arma.putExtra(ID_PERSONAJE,id_jugador);
                arma.putExtra(TAG_ELEGIDO,tagElegido);
                arma.putExtra(IMG_PERSONAJE,personaje_elegido);
                finish();
            }

        });

        // Creamos una matriz de color para aplicarla a la imagen.
        ColorMatrix matrix = new ColorMatrix();
        // Configura la saturación a 0 para convertir la imagen en escala de grises
        matrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);

        // Identificamos la imagen a la que aplicar la matriz de color y desabilizar que se pueda clicar.
        switch (tag_jugador){
            case "A1":
                iv_a1.setColorFilter(filter);
                iv_a1.setEnabled(false);
                break;
            case "A2":
                iv_a2.setColorFilter(filter);
                iv_a2.setEnabled(false);
                break;
            case "A3":
                iv_a3.setColorFilter(filter);
                iv_a3.setEnabled(false);
                break;
            case "A4":
                iv_a4.setColorFilter(filter);
                iv_a4.setEnabled(false);
                break;
            default:
                break;
        }

        controladorTag =new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imgPersonaje=(ImageView) view;
                //Vamos a identificar el tag elegido para pasárselo al personaje y que el switch indique el drawable correspondiente
                tagElegido=imgPersonaje.getTag().toString();
                //Aplicamos un fondo para la img seleccionadad (Falta quitar cuando se seleccicionan varias y quitar las demás)
                imgPersonaje.setBackgroundColor(Color.argb(80, 255, 255, 255));
            }
        };

        // Realizamos una llamada al controlador con cada una de las imágenes
        iv_a1.setOnClickListener(controladorTag);
        iv_a2.setOnClickListener(controladorTag);
        iv_a3.setOnClickListener(controladorTag);
        iv_a4.setOnClickListener(controladorTag);
    }
}