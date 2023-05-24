package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Trl3 extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myref;
    TextView txt_trl1p1, txt_trl1p2, txt_trl1p3, txt_trl1p4, txt_trl1p5, txt_trl1p6, txt_trl1p7;
    public static List<Preguntas> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl3);
        txt_trl1p1 = findViewById(R.id.txt_trl1p1);
        txt_trl1p2 = findViewById(R.id.txt_trl1p2);
        txt_trl1p3 = findViewById(R.id.txt_trl1p3);
        txt_trl1p4 = findViewById(R.id.txt_trl1p4);
        txt_trl1p5 = findViewById(R.id.txt_trl1p5);
        txt_trl1p6 = findViewById(R.id.txt_trl1p6);
        txt_trl1p7 = findViewById(R.id.txt_trl1p7);
        //Crear conexion a la base de datos
        cargarP();

    }


    public void cargarP() {

        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION

        Query query = myref.child("Preguntas").orderByChild("nivel").equalTo("Tlr1");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Preguntas pregunta = dataSnapshot.getValue(Preguntas.class);
                    list.add(pregunta);
                }
                txt_trl1p1.setText(list.get(0).getPregunta());
                txt_trl1p2.setText(list.get(1).getPregunta());
                txt_trl1p3.setText(list.get(2).getPregunta());
                txt_trl1p4.setText(list.get(3).getPregunta());
                txt_trl1p5.setText(list.get(4).getPregunta());
                txt_trl1p6.setText(list.get(5).getPregunta());
                txt_trl1p7.setText(list.get(6).getPregunta());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}



