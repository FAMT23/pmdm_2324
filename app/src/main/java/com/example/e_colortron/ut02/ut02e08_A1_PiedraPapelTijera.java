package com.example.e_colortron.ut02;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_colortron.R;

public class ut02e08_A1_PiedraPapelTijera extends AppCompatActivity {

    View.OnClickListener controlador;
    ImageView imgHumano, imgRobot, imgPiedra, imgPapel, imgTijera;
    TextView tvMarcadorHumano, tvMarcadorRobot, tvResultado, tvEleccionHumano, tvEleccionRobot;
    Button btnReiniciar;

    private enum opciones{
        PIEDRA,PAPEL,TIJERA;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hpiedra_papel_tijera);

        //imgHumano=findViewById(R.id.u1e6imgHumano);
        //imgPapel=findViewById(R.id.u1e6imgPapel);
        tvMarcadorHumano=findViewById(R.id.u1e6tvMarcadorHumano);
        tvMarcadorRobot=findViewById(R.id.u1e6tvMarcadorRobot);
        tvResultado=findViewById(R.id.u1e6tvResultado);
        tvEleccionHumano=findViewById(R.id.u1e6tvEleccionHumano);
        tvEleccionRobot=findViewById(R.id.u1e6tvEleccionRobot);

        imgHumano=findViewById(R.id.u1e6imgHumano);
        imgRobot=findViewById(R.id.u1e6imgRobot);
        imgPiedra=findViewById(R.id.u1e6imgPiedra);
        imgPapel=findViewById(R.id.u1e6imgPapel);
        imgTijera=findViewById(R.id.u1e6imgTijera);

        btnReiniciar=findViewById(R.id.u1e6btReiniciar);

        int imgId=0;
        int imgPiedraId=imgPiedra.getId();
        int imgPapelId=imgPapel.getId();
        int imgTijeraId=imgTijera.getId();
        int[] arrayElementos= new int[]{imgPiedraId, imgPapelId, imgTijeraId};
        String[] arrayElementosNombre=new String[]{"Piedra","Papel","Tijera"};

        final int MAX_TAMANO=24;
        final int MIN_TAMANO=14;

        // Piedra gana a tijera
        // Tijera gana a papel
        // Papel gana a tijera

        //Vamos a proceder a asignar tags a las imágenes para poder reconocerlas
        imgPiedra.setTag(opciones.PIEDRA);
        imgPapel.setTag(opciones.PAPEL);
        imgTijera.setTag(opciones.TIJERA);


        controlador =new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declaramos los contadores
                int contadorHumano=Integer.parseInt(tvMarcadorHumano.getText().toString());
                int contadorRobot=Integer.parseInt(tvMarcadorRobot.getText().toString());

                if (contadorRobot!=3 && contadorHumano!=3){
                    ImageView iv=(ImageView) view;
                    // Elección Humano
                    int eleccionHumano=iv.getId();
                    int eleccionHumanoPosicion;

                    if(eleccionHumano==imgPiedraId){
                        eleccionHumanoPosicion=0;
                        tvEleccionHumano.setText(imgPiedra.getTag().toString());

                    } else if (eleccionHumano==imgPapelId) {
                        eleccionHumanoPosicion=1;
                        tvEleccionHumano.setText(imgPapel.getTag().toString());
                    } else{
                        eleccionHumanoPosicion=2;
                        tvEleccionHumano.setText(imgTijera.getTag().toString());
                    }
                    // Elección Robot
                    int eleccionRobotPosicion=(int) (Math.random()*3);
                    int eleccionRobot=arrayElementos[eleccionRobotPosicion];

                    if(eleccionRobot==imgPiedraId){
                        tvEleccionRobot.setText(imgPiedra.getTag().toString());
                    } else if (eleccionRobot==imgPapelId) {
                        tvEleccionRobot.setText(imgPapel.getTag().toString());
                    } else{
                        tvEleccionRobot.setText(imgTijera.getTag().toString());
                    }

                    if(eleccionHumanoPosicion==0 && eleccionRobotPosicion==1){
                        tvResultado.setText("Gana Papel de la máquina");
                        contadorRobot++;
                    } else if (eleccionHumanoPosicion==1 && eleccionRobotPosicion==0) {
                        tvResultado.setText("Gana Papel del usuario");
                        contadorHumano++;
                    } else if (eleccionHumanoPosicion==1 && eleccionRobotPosicion==2) {
                        tvResultado.setText("Gana tijera de la máquina");
                        contadorRobot++;
                    } else if (eleccionHumanoPosicion==2 && eleccionRobotPosicion==1) {
                        tvResultado.setText("Gana tijera del usuario");
                        contadorHumano++;
                    } else if (eleccionHumanoPosicion==2 && eleccionRobotPosicion==0) {
                        tvResultado.setText("Gana piedra de la máquina ");
                        contadorRobot++;
                    } else if (eleccionHumanoPosicion==0 && eleccionRobotPosicion==2) {
                        tvResultado.setText("Gana piedra del usuario ");
                        contadorHumano++;
                    } else{
                        tvResultado.setText("Empate");
                    }

                    tvMarcadorHumano.setText(Integer.toString(contadorHumano));
                    tvMarcadorRobot.setText(Integer.toString(contadorRobot));

                }
                if(contadorRobot>=3){
                    tvResultado.setTextSize(MAX_TAMANO);
                    tvResultado.setText("El ganador final es la Máquina");

                } else if (contadorHumano>=3) {
                    tvResultado.setTextSize(MAX_TAMANO);
                    tvResultado.setText("El ganador final es la Usuario");
                }
            }
        };

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMarcadorHumano.setText("0");
                tvMarcadorRobot.setText("0");
                tvResultado.setText("");
                tvResultado.setTextSize(MIN_TAMANO);

            }
        });




        imgPapel.setOnClickListener(controlador);
        imgPiedra.setOnClickListener(controlador);
        imgTijera.setOnClickListener(controlador);

    }


}