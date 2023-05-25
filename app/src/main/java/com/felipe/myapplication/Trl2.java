package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Trl2 extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myref;
    TextView txt_trl2p1, txt_trl2p2, txt_trl2p3, txt_trl2p4, txt_trl2p5, txt_trl2p6, txt_trl2p7,txt_trl2p8;

    Button btn_calcular;

    public static List<Preguntas> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl2);
        txt_trl2p1 = findViewById(R.id.txt_trl2p1);
        txt_trl2p2 = findViewById(R.id.txt_trl2p2);
        txt_trl2p3 = findViewById(R.id.txt_trl2p3);
        txt_trl2p4 = findViewById(R.id.txt_trl2p4);
        txt_trl2p5 = findViewById(R.id.txt_trl2p5);
        txt_trl2p6 = findViewById(R.id.txt_trl2p6);
        txt_trl2p7 = findViewById(R.id.txt_trl2p7);
        txt_trl2p8 = findViewById(R.id.txt_trl2p8);



        cargarP();
        //list = findViewById(R.id.txt_trl1);

    }
    public void cargarP() {


        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION


        Query query = myref.child("Preguntas").orderByChild("nivel").equalTo("Tlr2");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Preguntas pregunta = dataSnapshot.getValue(Preguntas.class);
                    list.add(pregunta);
                }
                txt_trl2p1.setText(list.get(0).getPregunta());
                txt_trl2p2.setText(list.get(1).getPregunta());
                txt_trl2p3.setText(list.get(2).getPregunta());
                txt_trl2p4.setText(list.get(3).getPregunta());
                txt_trl2p5.setText(list.get(4).getPregunta());
                txt_trl2p6.setText(list.get(5).getPregunta());
                txt_trl2p7.setText(list.get(6).getPregunta());
                txt_trl2p8.setText(list.get(7).getPregunta());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


}

























   /* iniciarfirebase();

    Query query = myRef.child("Preguntas").child("nivel");
        query.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(@NonNull DataSnapshot snapshot) {
        Preguntas p = new Preguntas();

        for (DataSnapshot data : snapshot.getChildren()) {
        p = data.getValue(Preguntas.class);
        Log.e("TAGRes", p.toString());
        }

        asignarPregunta(list);
        }

@Override
public void onCancelled(@NonNull DatabaseError error) {

        }
        });

        }

    private void asignarPregunta(List list) {
        List<Preguntas> preguntas = list;

        txt_trl1p1.setText(preguntas.get(0).getPregunta());
        Toast.makeText(this, "FFF" + preguntas, Toast.LENGTH_SHORT).show();
    }

    private void iniciarfirebase() {

    }


    @Override
    public void onClick(View view) {

    }


    */


