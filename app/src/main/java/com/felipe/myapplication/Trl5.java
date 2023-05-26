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

public class Trl5 extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference myref;
    public static String nivel;
    Button btn_calcular5;
    TextView txt_trl5p1, txt_trl5p2, txt_trl5p3, txt_trl5p4, txt_trl5p5, txt_trl5p6, txt_trl5p7,txt_trl5p8;
    RadioGroup rg5_respuestas1,rg5_respuestas2,rg5_respuestas3,rg5_respuestas4,rg5_respuestas5,rg5_respuestas6,rg5_respuestas7,rg5_respuestas8;
    RadioButton rd5_p1, rd5_p_1,rd5_p2, rd5_p2_2,rd5_p3, rb5_p_3,rb5_p4, rb5_p4_4,rb5_p5, rb5_p5_5,rb5_p6, rb5_p6_6,rb5_p7, rb5_p7_7,rb5_p8, rb5_p7_8;

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
            resultadop8,
            resultadop_8,
            todos5;
    public static List<Preguntas> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl5);

        txt_trl5p1 = findViewById(R.id.txt_trl5p1);
        txt_trl5p2 = findViewById(R.id.txt_trl5p2);
        txt_trl5p3 = findViewById(R.id.txt_trl5p3);
        txt_trl5p4 = findViewById(R.id.txt_trl5p4);
        txt_trl5p5 = findViewById(R.id.txt_trl5p5);
        txt_trl5p6 = findViewById(R.id.txt_trl5p6);
        txt_trl5p7 = findViewById(R.id.txt_trl5p7);
        txt_trl5p8 = findViewById(R.id.txt_trl5p8);

        btn_calcular5 = findViewById(R.id.btn_calcular5);

        rg5_respuestas1 = findViewById(R.id.rg5_respuestas1);
        rd5_p1 = findViewById(R.id.rd5_p1);
        rd5_p_1 = findViewById(R.id.rd5_p_1);

        rg5_respuestas2 = findViewById(R.id.rd5_repuesta2);
        rd5_p2 = findViewById(R.id.rb5_p2);
        rd5_p2_2 = findViewById(R.id.rb5_p_2);

        rg5_respuestas3 = findViewById(R.id.rg5_respuestas3);
        rd5_p3 = findViewById(R.id.rb5_p3);
        rb5_p_3 = findViewById(R.id.rb5_p_3);

        rg5_respuestas4 = findViewById(R.id.rg5_respuestas4);
        rb5_p4 = findViewById(R.id.rb5_p4);
        rb5_p4_4 = findViewById(R.id.rb5_p_4);

        rg5_respuestas5 = findViewById(R.id.rg5_respuestas5);
        rb5_p5 = findViewById(R.id.rb5_p5);
        rb5_p5_5 = findViewById(R.id.rb5_p_5);

        rg5_respuestas6 = findViewById(R.id.rg5_respuestas6);
        rb5_p6 = findViewById(R.id.rb5_p6);
        rb5_p6_6 = findViewById(R.id.rb5_p_6);

        rg5_respuestas7 = findViewById(R.id.rg5_respuestas7);
        rb5_p7 = findViewById(R.id.rb5_p7);
        rb5_p7_7 = findViewById(R.id.rb5_p_7);

        rg5_respuestas8 = findViewById(R.id.rg5_respuestas8);
        rb5_p8 = findViewById(R.id.rb5_p8);
        rb5_p7_8 = findViewById(R.id.rb5_p_8);



        cargarP();

    }


    public void cargarP() {

        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION

        Query query = myref.child("Preguntas").orderByChild("nivel").equalTo("Tlr4");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Preguntas pregunta = dataSnapshot.getValue(Preguntas.class);
                    list.add(pregunta);
                }
                txt_trl5p1.setText(list.get(0).getPregunta());
                txt_trl5p2.setText(list.get(1).getPregunta());
                txt_trl5p3.setText(list.get(2).getPregunta());
                txt_trl5p4.setText(list.get(3).getPregunta());
                txt_trl5p5.setText(list.get(4).getPregunta());
                txt_trl5p6.setText(list.get(5).getPregunta());
                txt_trl5p7.setText(list.get(6).getPregunta());
                txt_trl5p8.setText(list.get(7).getPregunta());



                rg5_respuestas1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i){
                            case R.id.rd5_p1:

                                resultado= (int) (resultado+13);
                                resultado1=resultado;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                // Toast.makeText(Trl3.this, "Su porcentaje es: "+resultado , Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rd5_p_1:
                                resultado= 0;
                                resultado1=resultado;
                                cargarP();
                                // Toast.makeText(Trl3.this, "ghjj"+resultado, Toast.LENGTH_SHORT).show();
                                break;

                        }

                    }
                });


                rg5_respuestas2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb5_p2:

                                resultadop2 = (int) (resultadop2 + 13);
                                resultadop2_2 = resultadop2;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb5_p_2:
                                resultadop2 = 0;
                                resultadop2_2 = resultadop2;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }
                    }
                });

                rg5_respuestas3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb5_p3:

                                resultadop3 = (int) (resultadop3 + 15);
                                resultadop_3 = resultadop3;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb5_p_3:
                                resultadop3 = 0;
                                resultadop_3 = resultadop3;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });
                rg5_respuestas4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb5_p4:

                                resultadop4 = (int) (resultadop4 + 15);
                                resultadop_4 = resultadop4;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb5_p_4:
                                resultadop4 = 0;
                                resultadop_4 = resultadop4;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg5_respuestas5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb5_p5:

                                resultadop5 = (int) (resultadop5 + 15);
                                resultadop_5 = resultadop5;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb5_p_5:
                                resultadop5 = 0;
                                resultadop_5 = resultadop5;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg5_respuestas6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb5_p6:

                                resultadop6 = (int) (resultadop6 + 15);
                                resultadop_6 = resultadop6;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb5_p_6:
                                resultadop6 = 0;
                                resultadop_6 = resultadop6;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg5_respuestas7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb5_p7:

                                resultadop7 = (int) (resultadop7 + 15);
                                resultadop_7 = resultadop7;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb5_p_7:
                                resultadop7 = 0;
                                resultadop_7 = resultadop7;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });

                rg5_respuestas8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb5_p8:

                                resultadop8 = (int) (resultadop8 + 15);
                                resultadop_8 = resultadop8;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb5_p_8:
                                resultadop8 = 0;
                                resultadop_8 = resultadop8;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });

                btn_calcular5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        todos5=resultado+resultadop2+resultadop3+resultadop4+resultadop5+resultadop6+resultadop_7;


                        if(todos5>= 100) {
                            //nivel = "Tlr2";

                            Intent intent = new Intent(Trl5.this, Trl6.class);
                            startActivity(intent);
                            Toast.makeText(Trl5.this, "su porcentaje es :" + todos5 + "%", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            nivel = "Tlr5";
                            Intent intent = new Intent(Trl5.this, Error_Trl.class);
                            startActivity(intent);
                            Toast.makeText(Trl5.this, "s" +
                                    "us resultados "+ todos5 +"%", Toast.LENGTH_SHORT).show();
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