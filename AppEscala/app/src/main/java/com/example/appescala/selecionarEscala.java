package com.example.appescala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class selecionarEscala extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_escala);
    }



    public void selecionarUnidade(View view){
        Intent it = new Intent(this, selecionarTurno.class);
        startActivity(it);
    }


}