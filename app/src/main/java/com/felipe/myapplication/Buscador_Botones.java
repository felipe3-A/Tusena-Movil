package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Buscador_Botones extends AppCompatActivity {
    SearchView busquedas2;
    Button btn_buscar_trl;
    EditText bus;


    TextView buscador;
    FirebaseDatabase database;
    DatabaseReference myref;
    public static List<Resultados> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador_botones);
        buscador = findViewById(R.id.busquedas);
        busquedas2=findViewById(R.id.busquedas2);
        btn_buscar_trl=findViewById(R.id.btn_buscar_trl);
        btn_buscar_trl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buscador.setText("");
                buquedas(bus.getText().toString());
            }
        });




    }


    public void buquedas(String s) {

        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION

        Query query = myref.child("Respuestas").orderByChild("investigador");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Resultados resultado = dataSnapshot.getValue(Resultados.class);
                    list.add(resultado);
                    bus.getText().toString();
                }
                buscador.setText(list.get(0).getNivel());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}