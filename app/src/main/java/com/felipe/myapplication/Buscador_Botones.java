package com.felipe.myapplication;

import android.os.Bundle;

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

        //database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        //myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION

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
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        Resultados rp = snapshot1.getValue(Resultados.class);
                        list.add(rp);
                    }
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
                buscar(s);
                return true;
            }
        });
    }

    private void buscar(String s) {
        ArrayList<Resultados> mylista = new ArrayList<>();
        for (Resultados obj : list) {
            if (obj.getId_producto().toLowerCase().contains(s.toLowerCase())) {
                mylista.add(obj);

            }

        }
        AdapterRespuestas adapter = new AdapterRespuestas(mylista);
        rv.setAdapter(adapter);
    }
}