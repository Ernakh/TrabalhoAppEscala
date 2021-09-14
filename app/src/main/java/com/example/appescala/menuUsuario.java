package com.example.appescala;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;

public class menuUsuario extends AppCompatActivity {

    private List<Enfermeiro> list = new ArrayList<Enfermeiro>();
    private ListView listView;
    private DatabaseReference refEnfermeiros;
    private FirebaseDatabase raizBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        carregarListView();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }

    public void carregarListView(){
        listView = (ListView) findViewById(R.id.listProdutos);

        final ArrayAdapter<Enfermeiro> adaptador = new ArrayAdapter<Enfermeiro>(this, android.R.layout.simple_list_item_checked, list);
        adaptador.clear();
        listView.setAdapter(adaptador);

        raizBanco = FirebaseDatabase.getInstance();
        refEnfermeiros = raizBanco.getReference("enfermeiros");

        refEnfermeiros.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                list.add(dataSnapshot.getValue(Enfermeiro.class));
                adaptador.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                list.remove(dataSnapshot.getValue(Enfermeiro.class));
                adaptador.notifyDataSetChanged();
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


    }
    public void onCLick (View view){
        if(view.getId() == R.id.btCadastrar){
            startActivity(new Intent(this, cadastrarUsuario.class));
        }
    }

    public void btExcluir(View view){

        String selecionados = "";

        //Cria um array com os itens selecionados no listview
        SparseBooleanArray checked = listView.getCheckedItemPositions();
        raizBanco = FirebaseDatabase.getInstance();
        refEnfermeiros = raizBanco.getReference("enfermeiros");
        for (int i = 0; i < checked.size(); i++){
            Enfermeiro enfermeiro = (Enfermeiro) listView.getItemAtPosition(checked.keyAt(i));
            //pega os itens marcados
            refEnfermeiros.child(enfermeiro.nome).removeValue();
        }
        Toast.makeText(this, "Usuário Removido com Sucesso!", Toast.LENGTH_LONG).show();
        carregarListView();
    }

}

