package com.example.appescala;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;


public class criarTurno extends AppCompatActivity {

    TimePicker picker;
    Button btnGet;
    TextView tvw;

    TimePicker picker1;
    Button btnGet1;
    TextView tvw1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_turno);

        tvw=(TextView)findViewById(R.id.textView);
        picker=(TimePicker)findViewById(R.id.timePicker);
        picker.setIs24HourView(true);
        btnGet=(Button)findViewById(R.id.button);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour, minute;
                String am_pm;
                if (Build.VERSION.SDK_INT >= 23 ){
                    hour = picker.getHour();
                    minute = picker.getMinute();
                }
                else{
                    hour = picker.getCurrentHour();
                    minute = picker.getCurrentMinute();
                }

                tvw.setText("Horario Inicial: "+ hour +":"+ minute);
            }
        });
        tvw1=(TextView)findViewById(R.id.textView1);
        picker1=(TimePicker)findViewById(R.id.timePicker);
        picker1.setIs24HourView(true);
        btnGet1=(Button)findViewById(R.id.button1);
        btnGet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour, minute;
                String am_pm;
                if (Build.VERSION.SDK_INT >= 23 ){
                    hour = picker1.getHour();
                    minute = picker1.getMinute();
                }
                else{
                    hour = picker1.getCurrentHour();
                    minute = picker1.getCurrentMinute();
                }

                tvw1.setText("Horario Final: "+ hour +":"+ minute);
            }
        });
    }
    }


