package com.example.appescala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menuRT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_r_t);
    }


    public void gerenciarUsuarios(View view) {
        Intent it = new Intent(this, menuUsuario.class);
        startActivity(it);
    }

    public void gerenciarEscala(View view) {
        Intent it = new Intent(this, selecionarEscala.class);
        startActivity(it);
    }

    public void gerenciarTrocas(View view) {
        Intent it = new Intent(this, gerenciarTroca.class);
        startActivity(it);
    }

    public void gerenciarTurno(View view) {
        Intent it = new Intent(this, menuTurno.class);
        startActivity(it);
    }

    public void gerenciarUnidade(View view) {
        Intent it = new Intent(this, menuUnidade.class);
        startActivity(it);
    }
}