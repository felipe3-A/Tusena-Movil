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

public class Trl3 extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myref;
    public static String nivel;
    Button btn_calcular3;
    TextView txt_trl3p1, txt_trl3p2, txt_trl3p3, txt_trl3p4, txt_trl3p5, txt_trl3p6, txt_trl3p7,txt_trl3p8;

    RadioGroup rg3_respuestas1,rg3_respuestas2,rg3_respuestas3,rg3_respuestas4,rg3_respuestas5,rg3_respuestas6,rg3_respuestas7,rg3_respuestas8;
    RadioButton rd3_p1, rd3_p_1,rd3_p2, rd3_p2_2,rd3_p3, rb3_p3_3,rb3_p4, rb3_p4_4,rb3_p5, rb3_p5_5,rb3_p6, rb3_p6_6,rb3_p7, rb3_p7_7,rb3_p8, rb3_p7_8;

    public static int
            resultado,
            resultado1,
            resultadop2,
            resultadop2_2,
            resultadop3,
            resultadop_3,
            resultadop4,
            resultadop_4,
            resultadop5,
            resultadop_5,
            resultadop6,
            resultadop_6,
            resultadop7,
            resultadop_7,
            todos3;
    public static List<Preguntas> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl3);
        txt_trl3p1 = findViewById(R.id.txt_trl3p1);
        txt_trl3p2 = findViewById(R.id.txt_trl3p2);
        txt_trl3p3 = findViewById(R.id.txt_trl3p3);
        txt_trl3p4 = findViewById(R.id.txt_trl3p4);
        txt_trl3p5 = findViewById(R.id.txt_trl3p5);
        txt_trl3p6 = findViewById(R.id.txt_trl3p6);
        txt_trl3p7 = findViewById(R.id.txt_trl3p7);
        txt_trl3p8 = findViewById(R.id.txt_trl3p8);
        btn_calcular3 = findViewById(R.id.btn_calcular3);

        rg3_respuestas1 = findViewById(R.id.rg3_respuestas1);
        rd3_p1 = findViewById(R.id.rd3_p1);
        rd3_p_1 = findViewById(R.id.rd3_p_1);

        rg3_respuestas2 = findViewById(R.id.rd3_repuesta2);
        rd3_p2 = findViewById(R.id.rb3_p2);
        rd3_p2_2 = findViewById(R.id.rb3_p_2);

        rg3_respuestas3 = findViewById(R.id.rg3_respuestas3);
        rd3_p3 = findViewById(R.id.rb3_p3);
        rb3_p3_3 = findViewById(R.id.rb3_p_3);

        rg3_respuestas4 = findViewById(R.id.rg3_respuestas4);
        rb3_p4 = findViewById(R.id.rb3_p4);
        rb3_p4_4 = findViewById(R.id.rb3_p_4);

        rg3_respuestas5 = findViewById(R.id.rg3_respuestas5);
        rb3_p5 = findViewById(R.id.rb3_p5);
        rb3_p5_5 = findViewById(R.id.rb3_p_5);

        rg3_respuestas6 = findViewById(R.id.rg3_respuestas6);
        rb3_p6 = findViewById(R.id.rb3_p6);
        rb3_p6_6 = findViewById(R.id.rb3_p_6);

        rg3_respuestas7 = findViewById(R.id.rg3_respuestas7);
        rb3_p7 = findViewById(R.id.rb3_p7);
        rb3_p7_7 = findViewById(R.id.rb3_p_7);

        rg3_respuestas8 = findViewById(R.id.rg3_respuestas8);
        rb3_p8 = findViewById(R.id.rb3_p8);
        rb3_p7_8 = findViewById(R.id.rb3_p_8);



        cargarP();

    }


    public void cargarP() {

        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION

        Query query = myref.child("Preguntas").orderByChild("nivel").equalTo("Tlr3");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Preguntas pregunta = dataSnapshot.getValue(Preguntas.class);
                    list.add(pregunta);
                }
                txt_trl3p1.setText(list.get(0).getPregunta());
                txt_trl3p2.setText(list.get(1).getPregunta());
                txt_trl3p3.setText(list.get(2).getPregunta());
                txt_trl3p4.setText(list.get(3).getPregunta());
                txt_trl3p5.setText(list.get(4).getPregunta());
                txt_trl3p6.setText(list.get(5).getPregunta());
                txt_trl3p7.setText(list.get(6).getPregunta());
                txt_trl3p8.setText(list.get(7).getPregunta());


                rg3_respuestas1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i){
                            case R.id.rd3_p1:

                                resultado= (int) (resultado+13);
                                resultado1=resultado;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                // Toast.makeText(Trl3.this, "Su porcentaje es: "+resultado , Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rd3_p_1:
                                resultado= 0;
                                resultado1=resultado;
                                cargarP();
                                // Toast.makeText(Trl3.this, "ghjj"+resultado, Toast.LENGTH_SHORT).show();
                                break;

                        }

                    }
                });


                rg3_respuestas2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb3_p2:

                                resultadop2 = (int) (resultadop2 + 13);
                                resultadop2_2 = resultadop2;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_2:
                                resultadop2 = 0;
                                resultadop2_2 = resultadop2;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }
                    }
                });

                rg3_respuestas3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb3_p3:

                                resultadop3 = (int) (resultadop3 + 15);
                                resultadop_3 = resultadop3;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_3:
                                resultadop3 = 0;
                                resultadop_3 = resultadop3;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });
                rg3_respuestas4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb3_p4:

                                resultadop4 = (int) (resultadop4 + 15);
                                resultadop_4 = resultadop4;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_4:
                                resultadop4 = 0;
                                resultadop_4 = resultadop4;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg3_respuestas5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb3_p5:

                                resultadop5 = (int) (resultadop5 + 15);
                                resultadop_5 = resultadop5;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_5:
                                resultadop5 = 0;
                                resultadop_5 = resultadop5;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg3_respuestas6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb3_p6:

                                resultadop6 = (int) (resultadop6 + 15);
                                resultadop_6 = resultadop6;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_6:
                                resultadop6 = 0;
                                resultadop_6 = resultadop6;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg3_respuestas7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb3_p7:

                                resultadop7 = (int) (resultadop7 + 15);
                                resultadop_7 = resultadop7;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_7:
                                resultadop7 = 0;
                                resultadop_7 = resultadop7;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                btn_calcular3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        todos3=resultado+resultadop2+resultadop3+resultadop4+resultadop5+resultadop6+resultadop_7;


                        if(todos3>= 100) {
                            //nivel = "Tlr2";

                            Intent intent = new Intent(Trl3.this, Trl4.class);
                            startActivity(intent);
                            Toast.makeText(Trl3.this, "Muy bien", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            nivel = "Tlr3";
                            Intent intent = new Intent(Trl3.this, Error_Trl.class);
                            startActivity(intent);
                            Toast.makeText(Trl3.this, "s" +
                                    "us resultados "+ todos3 +"%", Toast.LENGTH_SHORT).show();
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