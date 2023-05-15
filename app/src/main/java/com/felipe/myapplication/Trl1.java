package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Trl1 extends AppCompatActivity implements View.OnClickListener {

    FirebaseDatabase database;
    DatabaseReference myRef;

    TextView txt_trl1p1,txt_trl1p2,txt_trl1p3,txt_trl1p4,txt_trl1p5,txt_trl1p6,txt_trl1p7,txt_trl1p8,txt_trl1p9;
    public static List<Preguntas> list = new ArrayList<>();
    public int num,num2 ;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl1);
        referenciar();

    }

    private void referenciar() {


        txt_trl1p1 = findViewById(R.id.txt_trl1p1);
      txt_trl1p1.setOnClickListener(this::onClick);

        txt_trl1p2 = findViewById(R.id.txt_trl1p1);
        txt_trl1p3 = findViewById(R.id.txt_trl1p1);
        txt_trl1p4 = findViewById(R.id.txt_trl1p1);
        txt_trl1p5 = findViewById(R.id.txt_trl1p1);
        txt_trl1p6 = findViewById(R.id.txt_trl1p1);
        txt_trl1p7 = findViewById(R.id.txt_trl1p1);
        txt_trl1p8 = findViewById(R.id.txt_trl1p1);
        txt_trl1p9 = findViewById(R.id.txt_trl1p1);

        cargarpregunta();



    }
    public  void iniciarFireBase() {
        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
    }

    public void cargarpregunta(){
        final List<String> listapreguntas = new  ArrayList<>();
        iniciarFireBase();

        Query query = myRef.child("preguntas").orderByChild("Tlr1");// consulta en la base de datos en la tabla preguntas los niveles
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objSnaptshot : snapshot.getChildren()){
                    Preguntas preguntas = objSnaptshot.getValue(Preguntas.class); // fila de la tabla se la pojo al objeto preguntas
                    list.add(preguntas); // lleno la lista list con los valores de las variables que tiene el pojo
                }
                listapreguntas.add(list.get(num).getPregunta());// a la nueva lista se le van agregar las respuestas//
                listapreguntas.add(list.get(num).getNivel());
                listapreguntas.add(list.get(num).getNivel());
                listapreguntas.add(list.get(num).getNivel());

                txt_trl1p1.setText(listapreguntas.get(0));
                txt_trl1p2.setText(listapreguntas.get(1));
                txt_trl1p3.setText(listapreguntas.get(2));
                txt_trl1p4.setText(listapreguntas.get(3));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    @Override
    public void onClick(View view) {

    }
}