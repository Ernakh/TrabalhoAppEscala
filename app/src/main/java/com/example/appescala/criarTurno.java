package com.example.appescala;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class criarTurno extends AppCompatActivity {

    TimePicker picker;
    Button btnGet;
    TextView tvw;
    EditText editNomeTurno;
    TimePicker picker1;
    Button btnGet1;
    TextView tvw1;
    private DatabaseReference refturnos;
    private FirebaseDatabase raizBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_turno);
        raizBanco = FirebaseDatabase.getInstance();
        refturnos = raizBanco.getReference("turnos");

        editNomeTurno = findViewById(R.id.editNomeTurno);
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

                tvw.setText(hour +":"+ minute);
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

                tvw1.setText(hour +":"+ minute);
            }
        });
    }

    private void salvarTurno() {
        String nome = editNomeTurno.getText().toString();
        String horaInicial = tvw.getText().toString();
        String horaFinal = tvw1.getText().toString();
        String key = refturnos.push().getKey();
        Turnos t = new Turnos(nome,horaInicial,horaFinal);
        refturnos.child(key).setValue(t)
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(criarTurno.this, "Falha no Cadastro do Turno"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(criarTurno.this, "Turno cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void criarTurno(View view) {
        salvarTurno();
    }
}


