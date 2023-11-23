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

public class m_7b_Metalslug extends AppCompatActivity {
    Button btn_aceptar, btn_limpiar;
    ImageView iv_p1,iv_p2,iv_p3,iv_p4;
    View.OnClickListener controladorTag;
    String tagElegido;
    int personaje_elegido;

    public static final String IMG_PERSONAJE="1";
    public static final String ID_PERSONAJE="2";
    public static final String TAG_ELEGIDO="3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m7b_metalslug);

        btn_aceptar=findViewById(R.id.u3a7bbtn_aceptar);
        btn_limpiar=findViewById(R.id.u3a7bbtn_limpiar);

        iv_p1=findViewById(R.id.u3a7bbtn_img_p1);
        iv_p2=findViewById(R.id.u3a7bbtn_img_p2);
        iv_p3=findViewById(R.id.u3a7bbtn_img_p3);
        iv_p4=findViewById(R.id.u3a7bbtn_img_p4);

        // Asigamos tags a cada una de las imágenes para poder reconocerlas
        iv_p1.setTag("P1");
        iv_p2.setTag("P2");
        iv_p3.setTag("P3");
        iv_p4.setTag("P4");

        //Recibimos el jugador (1 o 2) que está seleccionando personaje y su tag del personaje inverso para poder bloquearlo.
        Bundle info_jugador=getIntent().getExtras();
        String id_jugador=info_jugador.getString(m_7a_Metalslug.ID_JUGADOR);
        String tag_jugador=info_jugador.getString(m_7a_Metalslug.TAG_JUGADOR);

        // Posibles errores
        //Qué pasa si entra y no seleciona ningún personaje después de haber seleccionado un jugador uno ya.

        btn_limpiar.setOnClickListener(view -> {
            tagElegido="Limpiar";
        });

        // Si entro y no selecciona se indicará el personaje por defecto. Puesto que indico que el tag es null y mando como KO la actividad
        tagElegido= null;

        btn_aceptar.setOnClickListener(view -> {
            Intent personaje=new Intent();

            // Dejamos el que está por defecto en caso de que no se haya seleccionado ninguno y se de al botón aceptar.
            if (tagElegido==null){
                // Poder verificar que si no hemos clicado sobre ningún personaje no aplique cambios.
                setResult(Activity.RESULT_CANCELED,personaje);
                finish();
            } else if (tagElegido.equals("Limpiar")) {
                // Poder verificar si tengo que limpiar el jugador seleccionado
                personaje_elegido=R.drawable.ic_launcher_foreground;
                setResult(Activity.RESULT_OK,personaje);
                personaje.putExtra(ID_PERSONAJE,id_jugador);
                personaje.putExtra(TAG_ELEGIDO,tagElegido);
                personaje.putExtra(IMG_PERSONAJE,personaje_elegido);
                finish();

            } else{
                switch (tagElegido){
                    case "P1":
                        personaje_elegido=R.drawable.p1;
                        break;
                    case "P2":
                        personaje_elegido=R.drawable.p2;
                        break;
                    case "P3":
                        personaje_elegido=R.drawable.p3;
                        break;
                    case "P4":
                        personaje_elegido=R.drawable.p4;
                        break;
                    default:
                        personaje_elegido=R.drawable.p1;
                        break;
                }

                setResult(Activity.RESULT_OK,personaje);
                personaje.putExtra(ID_PERSONAJE,id_jugador);
                personaje.putExtra(TAG_ELEGIDO,tagElegido);
                personaje.putExtra(IMG_PERSONAJE,personaje_elegido);
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
            case "P1":
                iv_p1.setColorFilter(filter);
                iv_p1.setEnabled(false);
                break;
            case "P2":
                iv_p2.setColorFilter(filter);
                iv_p2.setEnabled(false);
                break;
            case "P3":
                iv_p3.setColorFilter(filter);
                iv_p3.setEnabled(false);
                break;
            case "P4":
                iv_p4.setColorFilter(filter);
                iv_p4.setEnabled(false);
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
        iv_p1.setOnClickListener(controladorTag);
        iv_p2.setOnClickListener(controladorTag);
        iv_p3.setOnClickListener(controladorTag);
        iv_p4.setOnClickListener(controladorTag);

    }
}