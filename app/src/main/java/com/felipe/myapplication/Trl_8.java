package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Trl_8 extends AppCompatActivity {

    public static List<Preguntas> list = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference myref;
    public static String nivel;
    Button btn_calcular8;
    TextView txt_trl8p1, txt_trl8p2, txt_trl8p3, txt_trl8p4, txt_trl8p5, txt_trl8p6, txt_trl8p7;

    RadioGroup rg4_respuestas1, rg4_respuestas2, rg4_respuestas3, rg4_respuestas4, rg4_respuestas5, rg4_respuestas6, rg4_respuestas7;
    RadioButton rd4_p1, rd4_p_1, rd4_p2, rd4_p2_2, rd4_p3, rb4_p_3, rb4_p4, rb4_p4_4, rb4_p5, rb4_p5_5, rb4_p6, rb4_p6_6, rb4_p7, rb4_p7_7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl8);
        txt_trl8p1 = findViewById(R.id.txt_trl8p1);
        txt_trl8p2 = findViewById(R.id.txt_trl8p2);
        txt_trl8p3 = findViewById(R.id.txt_trl8p3);
        txt_trl8p4 = findViewById(R.id.txt_trl8p4);
        txt_trl8p5 = findViewById(R.id.txt_trl8p5);
        txt_trl8p6 = findViewById(R.id.txt_trl8p6);
        txt_trl8p7 = findViewById(R.id.txt_trl8p7);


        btn_calcular8 = findViewById(R.id.btn_calcular8);
        cargarP();
    }
    public void cargarP() {

        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION

        Query query = myref.child("Preguntas").orderByChild("nivel").equalTo("Tlr8");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Preguntas pregunta = dataSnapshot.getValue(Preguntas.class);
                    list.add(pregunta);
                }
                txt_trl8p1.setText(list.get(0).getPregunta());
                txt_trl8p2.setText(list.get(1).getPregunta());
                txt_trl8p3.setText(list.get(2).getPregunta());
                txt_trl8p4.setText(list.get(3).getPregunta());
                txt_trl8p5.setText(list.get(4).getPregunta());
                txt_trl8p6.setText(list.get(5).getPregunta());
                txt_trl8p7.setText(list.get(6).getPregunta());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}