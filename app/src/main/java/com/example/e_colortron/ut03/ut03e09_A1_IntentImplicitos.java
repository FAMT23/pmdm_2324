package com.example.e_colortron.ut03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.e_colortron.R;

import java.util.Locale;

public class ut03e09_A1_IntentImplicitos extends AppCompatActivity {

    Button btn_Navegar,btn_Tfno,btn_Sms,btn_Email, btn_Maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut03e09_a1_intent_implicitos);

        btn_Navegar=findViewById(R.id.ut03e09a1btn_Navegador);
        btn_Tfno=findViewById(R.id.ut03e09a1btn_Tfno);
        btn_Sms=findViewById(R.id.ut03e09a1btn_Sms);
        btn_Email=findViewById(R.id.ut03e09a1btn_Email);
        btn_Maps=findViewById(R.id.ut03e09a1btn_Maps);

        /*
        btn_Navegar.setOnClickListener(view -> {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.youtube.com/watch?v=dvgZkm1xWPE"));
            startActivity(intent);
        });
*/

        // Otra forma de accesder al navegador
        btn_Navegar.setOnClickListener(view -> {
            Intent intent=new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY,"https://www.youtube.com/watch?v=dvgZkm1xWPE");
            startActivity(intent);
        });

        btn_Email.setOnClickListener(view -> {
            String[] TO={"famt.docs@gmail.com"};
            String[] CC={"famt_94@hotmail.es"};
            Intent intent=new Intent(Intent.ACTION_SEND);

            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL,TO); //From
            intent.putExtra(Intent.EXTRA_CC,CC);
            intent.putExtra(Intent.EXTRA_SUBJECT,"Saludo desde Android");
            intent.putExtra(Intent.EXTRA_TEXT,"Este es un mensaje generado desde Android Studio");

            try {
                startActivity(Intent.createChooser(intent,"Enviar Email"));
            }catch (ActivityNotFoundException ex){
                Toast.makeText(getApplicationContext(),"No hay aplicación de correo", Toast.LENGTH_SHORT).show();
            }
        });

        btn_Tfno.setOnClickListener(view -> {
            Intent intent= new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
        });

        btn_Sms.setOnClickListener(view -> {
            String number="699874123";
            Intent intent=new Intent(Intent.ACTION_VIEW);

            intent.setData(Uri.fromParts("sms",number,null));
            intent.putExtra("sms_body","Este es el cuerpo del mensaje");
            startActivity(intent);
        });

        btn_Maps.setOnClickListener(view -> {
            // Creates an Intent that will load a map of San Francisco
            //Uri gmmIntentUri = Uri.parse("geo:40.4023,-3.712?q=restaurants");
            Uri gmmIntentUri = Uri.parse("geo:40.4023,-3.712?q=Delicias, Madrid, Madrid");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });
    }
}