package com.example.appescala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class selecionarUsuarioEditar extends AppCompatActivity {
    private DatabaseReference refEnfermeiros;
    private FirebaseDatabase raizBanco;
    TextView textView12;
    LinearLayout lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_usuario_editar);
        TextView textView12 = findViewById(R.id.textView12);
        raizBanco = FirebaseDatabase.getInstance();
        refEnfermeiros = raizBanco.getReference("enfermeiros");

        refEnfermeiros.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String txt = "";


                for(DataSnapshot pNode: snapshot.getChildren()){
                    String key = pNode.getKey();
                    Enfermeiro e = pNode.getValue(Enfermeiro.class);
                    textView12.setText(e.nome);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error){

            }
        });
    }

    public void editarUsuario(View view) {
        Intent it = new Intent(this, editarUsuario.class);
        startActivity(it);
    }
}