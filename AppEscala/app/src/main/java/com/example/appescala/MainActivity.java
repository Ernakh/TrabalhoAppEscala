package com.example.appescala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    EditText editLogin, editSenha;
    private DatabaseReference refUsuarios;
    private FirebaseDatabase raizBanco;
    List<Usuarios> usuarios = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);

        raizBanco = FirebaseDatabase.getInstance();
        refUsuarios = raizBanco.getReference("usuarios");


    }
    public void menuTec(){
        Intent it = new Intent(this, menuTec.class);
        startActivity(it);
    }
    public void menuEnf(){
        Intent it = new Intent(this, menuEnf.class);
        startActivity(it);
    }
    public void menuLU(){
        Intent it = new Intent(this, menuLU.class);
        startActivity(it);
    }public void menuRT(){
        Intent it = new Intent(this, menuRT.class);
        startActivity(it);
    }

    public void fazerLogin(View view) {
        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();

        refUsuarios.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                usuarios.clear();
                String txt = "";


                for(DataSnapshot pNode: snapshot.getChildren()){
                    String key = pNode.getKey();
                    Usuarios e = pNode.getValue(Usuarios.class);
                    usuarios.add(e);
                    if(login.equals(e.login) && senha.equals(e.senha)){
                        if(e.cargo.equals("1")){
                            //rTecnicoEnfermagem();
                            menuTec();
                        }if(e.cargo.equals("2")){
                            //rEnfermeiro();
                            menuEnf();
                        }if(e.cargo.equals("3")){
                            //rEnfermeiroUnidade();
                            menuLU();
                        }if(e.cargo.equals("4")){
                            menuRT();
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error){

            }
        });
    }
}