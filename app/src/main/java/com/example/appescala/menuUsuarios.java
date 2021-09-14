package com.example.appescala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menuUsuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuarios);
    }
    public void menuCadastrar(View view) {
        Intent it = new Intent(this, cadastrarUsuario.class);
        startActivity(it);
    }

    public void menuEditar(View view) {
        Intent it = new Intent(this, selecionarUsuarioEditar.class);
        startActivity(it);
    }

    public void menuDeletar(View view) {
        Intent it = new Intent(this, deletarUsuario.class);
        startActivity(it);
    }
}