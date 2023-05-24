package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
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
    //private List<Preguntas> listpregunta=new ArrayList<Preguntas>();
    FirebaseDatabase database;
    DatabaseReference myref;
    TextView txt_trl1p1, txt_trl1p2, txt_trl1p3, txt_trl1p4, txt_trl1p5, txt_trl1p6, txt_trl1p7,txt_trl1p8,txt_trl1p9,txt_trlp10;

    public static List<Preguntas> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl2);
        txt_trl1p1 = findViewById(R.id.txt_trl1p1);
        txt_trl1p2 = findViewById(R.id.txt_trl1p2);
        txt_trl1p3 = findViewById(R.id.txt_trl1p3);
        txt_trl1p4 = findViewById(R.id.txt_trl1p4);
        txt_trl1p5 = findViewById(R.id.txt_trl1p5);
        txt_trl1p6 = findViewById(R.id.txt_trl1p6);
        txt_trl1p7 = findViewById(R.id.txt_trl1p7);


        cargarP("tlr1");
        //list = findViewById(R.id.txt_trl1);

    }
    public void cargarP(String tlr) {


        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION


        Query query = myref.child("Preguntas").orderByChild("nivel").equalTo(tlr);
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
                txt_trl1p8.setText(list.get(7).getPregunta());
                txt_trl1p9.setText(list.get(8).getPregunta());
                txt_trlp10.setText(list.get(9).getPregunta());

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


