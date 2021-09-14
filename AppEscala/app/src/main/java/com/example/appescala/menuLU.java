package com.example.appescala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menuLU extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lu);
    }

    public void gerenciarEscala(View view) {
        Intent it = new Intent(this, selecionarEscala.class);
        startActivity(it);
    }

    public void gerenciarTrocas(View view) {
        Intent it = new Intent(this, gerenciarTroca.class);
        startActivity(it);
    }
}