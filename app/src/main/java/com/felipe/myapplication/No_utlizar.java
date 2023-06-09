package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class No_utlizar extends AppCompatActivity {
    ListView lista1;
    FirebaseDatabase database;
    DatabaseReference myref;

    //public static  List<Preguntas> list = new ArrayList<>();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Crear conexion a la base de datos
        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION



        //Almacena los datos
        ArrayList<Preguntas> almacenapreguntas =new ArrayList<>();

        myref.child("Preguntas").orderByChild("nivel").equalTo("").addValueEventListener(new ValueEventListener() {//* Select *from Preguntas
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Crear un cico para que recorra cda uno de los datos almacenados

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                    Preguntas preguntas=dataSnapshot.getValue(Preguntas.class);

                    almacenapreguntas.add(preguntas);//Aqui se guardan los datos del nodo o algo asi

                    adapter=new ArrayAdapter<Preguntas>(No_utlizar.this, android.R.layout.simple_list_item_1,almacenapreguntas);

                    lista1.setAdapter(adapter);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


}