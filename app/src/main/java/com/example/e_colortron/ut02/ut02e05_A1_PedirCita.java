package com.example.e_colortron.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.e_colortron.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ut02e05_A1_PedirCita extends AppCompatActivity {

    Button btn_caleandario, btn_hora;
    TextView tv_mensaje, tv_hora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpedir_cita);

        btn_caleandario=findViewById(R.id.ut02e05_btnCalendario);
        btn_hora=findViewById(R.id.ut02e05_btnHora);
        tv_mensaje=findViewById(R.id.u1e5etxdate);
        tv_hora=findViewById(R.id.ut02e05_tvHora);

        btn_caleandario.setOnClickListener((View v)-> {
            Calendar c= Calendar.getInstance();
            int anio=c.get(Calendar.YEAR);
            int mes=c.get(Calendar.MONTH);
            int dia=c.get(Calendar.DAY_OF_MONTH);

            // on below line we are creating a variable for date picker dialog.
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    // on below line we are passing context.
                    ut02e05_A1_PedirCita.this,
                    (view, year, monthOfYear, dayOfMonth) -> {
                        Calendar selectedDate = new GregorianCalendar(year, monthOfYear, dayOfMonth);
                        int diaSemana = selectedDate.get(Calendar.DAY_OF_WEEK);
                        // on below line we are setting date to our text view.
                        if (diaSemana == Calendar.SATURDAY || diaSemana == Calendar.SUNDAY) {
                            tv_mensaje.setText("Fecha erronea. Abrimos de lunes a viernes.");
                        } else {
                            // on below line we are setting date to our text view.
                            tv_mensaje.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            //tv_mensaje.setText("");
                        }

                    },
                    // on below line we are passing year,
                    // month and day for selected date in our date picker.
                    anio, mes, dia);
            // at last we are calling show to
            // display our date picker dialog.
            datePickerDialog.show();
        });

        btn_hora.setOnClickListener((View v)->{
            Calendar c=Calendar.getInstance();
            int hora=c.get(Calendar.HOUR);
            int minuto=c.get(Calendar.MINUTE);

            TimePickerDialog tpd=new TimePickerDialog(
                    ut02e05_A1_PedirCita.this,
                    (view, hour,min)->{
                        if(hour>9 && hour<14){
                            tv_hora.setText(hour+":"+min);
                        }else{
                            tv_hora.setText("Hora Incorrecta");
                        }
            },hora,minuto,true);
            tpd.show();
        });





    }

}