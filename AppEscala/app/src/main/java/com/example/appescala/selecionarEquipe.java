package com.example.appescala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class selecionarEquipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_equipe);
    }

    public void selecionarEquipe(View view) {
        Intent it = new Intent(this, calendario.class);
        startActivity(it);
    }
}