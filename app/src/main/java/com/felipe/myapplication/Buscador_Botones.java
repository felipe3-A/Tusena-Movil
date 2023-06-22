package com.felipe.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.felipe.myapplication.adapter.AdapterRespuestas;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Buscador_Botones extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myref;
    ArrayList<Resultados> list;
    RecyclerView rv;
    SearchView searchView;
    AdapterRespuestas adapter;

    LinearLayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador_botenes);

        myref = FirebaseDatabase.getInstance().getReference().child("Respuestas");

        rv = findViewById(R.id.rv);
        searchView = findViewById(R.id.search);

        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        list = new ArrayList<>();
        adapter = new AdapterRespuestas(list);

        rv.setAdapter(adapter);


        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Resultados ms = dataSnapshot.getValue(Resultados.class);
                        list.add(ms);}
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
               // s= "P";
                Toast.makeText(Buscador_Botones.this, "hola"+s, Toast.LENGTH_SHORT).show();
               buscar(s);
                return true;
            }
        });
    }

    private void buscar(String s) {
        myref.child("Respuestas").orderByChild("nivel");
        ArrayList<Resultados> mylista = new ArrayList<>();
        for (Resultados obj : list) {
<<<<<<< HEAD
            if (obj.getInvestigador().toLowerCase().contains(s.toLowerCase())) {
=======
            if (obj.getProducto().toLowerCase().contains(s.toLowerCase())) {
>>>>>>> 0c4f90ea866a6317636dee64f1559114879501b1
                mylista.add(obj);
            }
        }
        AdapterRespuestas adapter = new AdapterRespuestas(mylista);
        rv.setAdapter(adapter);
    }
}