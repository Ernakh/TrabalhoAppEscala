package com.example.appescala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class cadastrarUsuario extends AppCompatActivity {
    EditText editNomeCompleto, editLoginCadastro, editSenhaCadastro;
    RadioGroup rgCargo;
    RadioButton rTecnicoEnfermagem, rEnfermeiro, rEnfermeiroUnidade, rEnfermeiroRT;
    private DatabaseReference refEnfermeiros;
    private FirebaseDatabase raizBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_criar);

        raizBanco = FirebaseDatabase.getInstance();
        refEnfermeiros = raizBanco.getReference("enfermeiros");

        editNomeCompleto = findViewById(R.id.editNomeCompleto);
        editLoginCadastro = findViewById(R.id.editLoginCadastro);
        editSenhaCadastro = findViewById(R.id.editSenhaCadastro);
        rgCargo = findViewById(R.id.rgCargo);
        rTecnicoEnfermagem = findViewById(R.id.rTecnicoEnfermagem);
        rEnfermeiro = findViewById(R.id.rEnfermeiro);
        rEnfermeiroUnidade = findViewById(R.id.rEnfermeiroUnidade);
        rEnfermeiroRT = findViewById(R.id.rEnfermeiroRT);
    }
    private void cadastrarEnfermeiro() {
        String nome = editNomeCompleto.getText().toString();
        String login = editLoginCadastro.getText().toString();
        String senha = editSenhaCadastro.getText().toString();
        String cargo = "";
        if(rTecnicoEnfermagem.isChecked()){
            cargo = "1";
        }
        else if (rEnfermeiro.isChecked()){
            cargo = "2";
        }
        else if(rEnfermeiroUnidade.isChecked()){
            cargo = "3";
        }
        else{
            cargo = "4";
        }
        Enfermeiro e = new Enfermeiro(nome,login,senha,cargo);
        String key = refEnfermeiros.push().getKey();

        refEnfermeiros.child(key).setValue(e)
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(cadastrarUsuario.this, "Falha no Cadastro do Enfermeiro"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(cadastrarUsuario.this, "Enfermeiro cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void cadastrarUsuario(View view) {
        cadastrarEnfermeiro();
    }
}