package com.example.appescala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class selecionarTurno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_turno);
    }

    public void selecionarTurno(View view){
        Intent it = new Intent(this, selecionarEquipe.class);
        startActivity(it);
    }
}