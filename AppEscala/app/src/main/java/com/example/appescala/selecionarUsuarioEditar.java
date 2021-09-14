package com.example.appescala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class selecionarUsuarioEditar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_usuario_editar);

    }

    public void editarUsuario(View view) {
        Intent it = new Intent(this, editarUsuario.class);
        startActivity(it);
    }
}