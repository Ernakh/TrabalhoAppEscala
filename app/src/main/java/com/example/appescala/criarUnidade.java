package com.example.appescala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class criarUnidade extends AppCompatActivity {
    private DatabaseReference refUnidades;
    private FirebaseDatabase raizBanco;
    EditText editUnidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_unidade);
        editUnidade = findViewById(R.id.editUnidade);
        raizBanco = FirebaseDatabase.getInstance();
        refUnidades = raizBanco.getReference("unidades");
    }

    private void salvarUnidade() {
        String nome = editUnidade.getText().toString();
        String key = refUnidades.push().getKey();
        refUnidades.child(key).setValue(nome)
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(criarUnidade.this, "Falha no Cadastro da Unidade"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(criarUnidade.this, "Unidade cadastrada com sucesso", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void cadastrarUnidade(View view) {
        salvarUnidade();
    }
}