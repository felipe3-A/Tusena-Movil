package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Trl6 extends AppCompatActivity {

    public static List<Preguntas> list = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference myref;
    public static String nivel;
    Button btn_calcular6;
    TextView txt_trl6p1, txt_trl6p2, txt_trl6p3, txt_trl6p4, txt_trl6p5, txt_trl6p6, txt_trl6p7, txt_trl6p8, txt_trl6p9, txt_trl6p10;

    RadioGroup rg6_respuestas1, rg6_respuestas2, rg6_respuestas3, rg6_respuestas4, rg6_respuestas5, rg6_respuestas6, rg6_respuestas7,rg6_respuestas8,rg6_respuestas9,rg6_respuestas10;
    RadioButton rd6_p1, rd6_p_1, rd6_p2, rd6_p2_2, rd6_p3, rb6_p3_3, rb6_p4, rb6_p4_4, rb6_p5, rb6_p5_5, rb6_p6, rb6_p6_6, rb6_p7, rb6_p7_7,rb6_p8, rb6_p8_8,rb6_p9, rb6_p9_9,rb6_p10, rb6_p10_10;
    public static int
            resultado6_1,
            resultado6_1_1,
            resultado6_2,
            resultado6_2_2,
            resultado6_3,
            resultado6_3_3,
            resultado6_4,
            resultado6_4_4,
            resultado6_5,
            resultado6_5_5,
            resultado6_6,
            resultado6_6_6,
            resultado6_7,
            resultado6_7_7,
            resultado6_8,
            resultado6_8_8,
            resultado6_9,
            resultado6_9_9,
            resultado6_10,
            resultado6_10_10,
            todos6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl6);

        txt_trl6p1 = findViewById(R.id.txt_trl6p1);
        txt_trl6p2 = findViewById(R.id.txt_trl6p2);
        txt_trl6p3 = findViewById(R.id.txt_trl6p3);
        txt_trl6p4 = findViewById(R.id.txt_trl6p4);
        txt_trl6p5 = findViewById(R.id.txt_trl6p5);
        txt_trl6p6 = findViewById(R.id.txt_trl6p6);
        txt_trl6p7 = findViewById(R.id.txt_trl6p7);
        txt_trl6p8 = findViewById(R.id.txt_trl6p8);
        txt_trl6p9 = findViewById(R.id.txt_trl6p9);
        txt_trl6p10 = findViewById(R.id.txt_trl6p10);

        btn_calcular6 = findViewById(R.id.btn_calcular6);
        cargarP();

        rg6_respuestas1 = findViewById(R.id.rg6_respuestas1);
        rd6_p1 = findViewById(R.id.rd6_p1);
        rd6_p_1 = findViewById(R.id.rd6_p_1);

        rg6_respuestas2 = findViewById(R.id.rg6_respuestas2);
        rd6_p2 = findViewById(R.id.rb6_p2);
        rd6_p2_2 = findViewById(R.id.rb6_p_2);

        rg6_respuestas3 = findViewById(R.id.rg6_respuestas3);
        rd6_p3 = findViewById(R.id.rb6_p3);
        rb6_p3_3 = findViewById(R.id.rb6_p_3);

        rg6_respuestas4 = findViewById(R.id.rg6_respuestas4);
        rb6_p4 = findViewById(R.id.rb6_p4);
        rb6_p4_4 = findViewById(R.id.rb6_p_4);

        rg6_respuestas5 = findViewById(R.id.rg6_respuestas5);
        rb6_p5 = findViewById(R.id.rb6_p5);
        rb6_p5_5 = findViewById(R.id.rb6_p_5);

        rg6_respuestas6 = findViewById(R.id.rg6_respuestas6);
        rb6_p6 = findViewById(R.id.rb6_p6);
        rb6_p6_6 = findViewById(R.id.rb6_p_6);

        rg6_respuestas7 = findViewById(R.id.rg6_respuestas7);
        rb6_p7 = findViewById(R.id.rb6_p7);
        rb6_p7_7 = findViewById(R.id.rb6_p_7);

        rg6_respuestas8 = findViewById(R.id.rg6_respuestas8);
        rb6_p8 = findViewById(R.id.rb6_p8);
        rb6_p8_8 = findViewById(R.id.rb6_p_8);

        rg6_respuestas9 = findViewById(R.id.rg6_respuestas9);
        rb6_p9 = findViewById(R.id.rb6_p9);
        rb6_p9_9 = findViewById(R.id.rb6_p_9);

        rg6_respuestas10 = findViewById(R.id.rg6_respuestas10);
        rb6_p10 = findViewById(R.id.rb6_p10);
        rb6_p10_10 = findViewById(R.id.rb6_p_10);

    }

    public void cargarP() {

        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION

        Query query = myref.child("Preguntas").orderByChild("nivel").equalTo("Tlr6");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Preguntas pregunta = dataSnapshot.getValue(Preguntas.class);
                    list.add(pregunta);
                }
                txt_trl6p1.setText(list.get(0).getPregunta());
                txt_trl6p2.setText(list.get(1).getPregunta());
                txt_trl6p3.setText(list.get(2).getPregunta());
                txt_trl6p4.setText(list.get(3).getPregunta());
                txt_trl6p5.setText(list.get(4).getPregunta());
                txt_trl6p6.setText(list.get(5).getPregunta());
                txt_trl6p7.setText(list.get(6).getPregunta());
                txt_trl6p8.setText(list.get(7).getPregunta());
                txt_trl6p9.setText(list.get(8).getPregunta());
                txt_trl6p10.setText(list.get(9).getPregunta());

            rg6_respuestas1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int i) {
                    switch (i){
                        case R.id.rd6_p1:
                            resultado6_1=(int) (resultado6_1+10);
                            resultado6_1_1=resultado6_1;
                            cargarP();
                            break;

                        case R.id.rd6_p_1:
                            resultado6_1=0;
                            resultado6_1_1=resultado6_1;
                            cargarP();
                            break;
                    }
                }
            });

                rg6_respuestas2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int i) {
                        switch (i){
                            case R.id.rb6_p2:
                                resultado6_2=(int) (resultado6_2+10);
                                resultado6_2_2=resultado6_2;
                                cargarP();
                                break;

                            case R.id.rb6_p_2:
                                resultado6_2=0;
                                resultado6_2_2=resultado6_2;
                                cargarP();
                                break;
                        }
                    }
                });
                rg6_respuestas3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int i) {
                        switch (i){
                            case R.id.rb6_p3:
                                resultado6_3=(int) (resultado6_3+10);
                                resultado6_3_3=resultado6_3;
                                cargarP();
                                break;

                            case R.id.rb6_p_3:
                                resultado6_3=0;
                                resultado6_3_3=resultado6_3;
                                cargarP();
                                break;
                        }
                    }
                });

                rg6_respuestas4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int i) {
                        switch (i){
                            case R.id.rb6_p4:
                                resultado6_4=(int) (resultado6_4+10);
                                resultado6_4_4=resultado6_4;
                                cargarP();
                                break;

                            case R.id.rb6_p_4:
                                resultado6_4=0;
                                resultado6_4_4=resultado6_4;
                                cargarP();
                                break;
                        }
                    }
                });

                rg6_respuestas5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int i) {
                        switch (i){
                            case R.id.rb6_p5:
                                resultado6_5=(int) (resultado6_5+10);
                                resultado6_5_5=resultado6_5;
                                cargarP();
                                break;

                            case R.id.rb6_p_5:
                                resultado6_5=0;
                                resultado6_5_5=resultado6_5;
                                cargarP();
                                break;
                        }
                    }
                });

                rg6_respuestas6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int i) {
                        switch (i){
                            case R.id.rb6_p6:
                                resultado6_6=(int) (resultado6_6+10);
                                resultado6_6_6=resultado6_6;
                                cargarP();
                                break;


                            case R.id.rb6_p_6:
                                resultado6_6=0;
                                resultado6_6_6=resultado6_6;
                                cargarP();
                                break;
                        }
                    }
                });
                rg6_respuestas7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int i) {
                        switch (i){
                            case R.id.rb6_p7:
                                resultado6_7=(int) (resultado6_7+10);
                                resultado6_7_7=resultado6_7;
                                cargarP();
                                break;

                            case R.id.rb6_p_7:
                                resultado6_7=0;
                                resultado6_7_7=resultado6_7;
                                cargarP();
                                break;
                        }
                    }
                });

                rg6_respuestas8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int i) {
                        switch (i){
                            case R.id.rb6_p8:
                                resultado6_8=(int) (resultado6_8+10);
                                resultado6_8_8=resultado6_8;
                                cargarP();
                                break;

                            case R.id.rb6_p_8:
                                resultado6_8=0;
                                resultado6_8_8=resultado6_8;
                                cargarP();
                                break;
                        }
                    }
                });

                rg6_respuestas9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int i) {
                        switch (i){
                            case R.id.rb6_p9:
                                resultado6_9=(int) (resultado6_9+10);
                                resultado6_9_9=resultado6_9;
                                cargarP();
                                break;

                            case R.id.rb6_p_9:
                                resultado6_9=0;
                                resultado6_9_9=resultado6_9;
                                cargarP();
                                break;
                        }
                    }
                });

                rg6_respuestas10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int i) {
                        switch (i){
                            case R.id.rb6_p10:
                                resultado6_10=(int) (resultado6_10+10);
                                resultado6_10_10=resultado6_10;
                                cargarP();
                                break;

                            case R.id.rb6_p_10:
                                resultado6_10=0;
                                resultado6_10_10=resultado6_10;
                                cargarP();
                                break;
                        }
                    }
                });

                btn_calcular6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        todos6=resultado6_1+resultado6_2+resultado6_3+resultado6_4+resultado6_5+resultado6_6+resultado6_7+resultado6_8+resultado6_9+resultado6_10;

                        if (todos6>=100){
                            Intent intent = new Intent(Trl6.this, Trl7.class);
                            startActivity(intent);
                            Toast.makeText(Trl6.this, "Muy Bien, Sigues al siguiente nivel con " + " " +  todos6 + "%" ,Toast.LENGTH_SHORT).show();
                        }
                        else{
                            nivel = "Tlr6";
                            Intent intent = new Intent(Trl6.this, Error_Trl.class);
                            startActivity(intent);
                            Toast.makeText(Trl6.this, "sus resultados "+ todos6 +"%", Toast.LENGTH_SHORT).show();
                        }


                    }
                });




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}