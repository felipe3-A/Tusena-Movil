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

public class Tlr1_1 extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myref;
  public static String nivel;
    Button btn_calcular;
    TextView txt_trl1p1, txt_trl1p2, txt_trl1p3, txt_trl1p4, txt_trl1p5, txt_trl1p6, txt_trl1p7;

    RadioGroup rg_respuestas,rg_respuestas2,rg_respuestas3,rg_respuestas4,rg_respuestas5,rg_respuestas6,rg_respuestas7;
    RadioButton rd_p1, rd_p_1,rd_p2, rd_p2_2,rd_p3, rd_p3_3,rd_p4, rd_p4_4,rd_p5, rd_p5_5,rd_p6, rd_p6_6,rd_p7, rd_p7_7;

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
            todos;
    public static List<Preguntas> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl1_1);
        txt_trl1p1 = findViewById(R.id.txt_trl1p1);
        txt_trl1p2 = findViewById(R.id.txt_trl1p2);
        txt_trl1p3 = findViewById(R.id.txt_trl1p3);
        txt_trl1p4 = findViewById(R.id.txt_trl1p4);
        txt_trl1p5 = findViewById(R.id.txt_trl1p5);
        txt_trl1p6 = findViewById(R.id.txt_trl1p6);
        txt_trl1p7 = findViewById(R.id.txt_trl1p7);
        btn_calcular = findViewById(R.id.btn_calcular1);

        rg_respuestas = findViewById(R.id.rg_respuestas);
        rd_p1 = findViewById(R.id.rd_p1);
        rd_p_1 = findViewById(R.id.rd_p_1);

        rg_respuestas2 = findViewById(R.id.rd_repuesta2);
        rd_p2 = findViewById(R.id.rb_p2);
        rd_p2_2 = findViewById(R.id.rb_p2_2);

        rg_respuestas3 = findViewById(R.id.rg_respuestas3);
        rd_p3 = findViewById(R.id.rb_p3);
        rd_p3_3 = findViewById(R.id.rb_p3_3);

        rg_respuestas4 = findViewById(R.id.rg_respuestas4);
        rd_p4 = findViewById(R.id.rb_p4);
        rd_p4_4 = findViewById(R.id.rb_p4_4);

        rg_respuestas5 = findViewById(R.id.rg_respuestas5);
        rd_p5 = findViewById(R.id.rb_p5);
        rd_p5_5 = findViewById(R.id.rb_p5_5);

        rg_respuestas6 = findViewById(R.id.rg_respuestas6);
        rd_p6 = findViewById(R.id.rb_p6);
        rd_p6_6 = findViewById(R.id.rb_p6_6);

        rg_respuestas7 = findViewById(R.id.rg_respuestas7);
        rd_p7 = findViewById(R.id.rb_p7);
        rd_p7_7 = findViewById(R.id.rb_p7_7);



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


                rg_respuestas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i){
                            case R.id.rd_p1:

                                resultado= (int) (resultado+15);
                                resultado1=resultado;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                               // Toast.makeText(Trl3.this, "Su porcentaje es: "+resultado , Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rd_p_1:
                                resultado= 0;
                                resultado1=resultado;
                                cargarP();
                               // Toast.makeText(Trl3.this, "ghjj"+resultado, Toast.LENGTH_SHORT).show();
                                break;

                        }

                    }
                });


                rg_respuestas2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb_p2:

                                resultadop2 = (int) (resultadop2 + 15);
                                resultadop2_2 = resultadop2;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                             //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb_p2_2:
                                resultadop2 = 0;
                                resultadop2_2 = resultadop2;
                                cargarP();
                              //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }
                    }
                });

                rg_respuestas3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb_p3:

                                resultadop3 = (int) (resultadop3 + 15);
                                resultadop_3 = resultadop3;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb_p3_3:
                                resultadop3 = 0;
                                resultadop_3 = resultadop3;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });
                rg_respuestas4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb_p4:

                                resultadop4 = (int) (resultadop4 + 15);
                                resultadop_4 = resultadop4;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb_p4_4:
                                resultadop4 = 0;
                                resultadop_4 = resultadop4;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg_respuestas5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb_p5:

                                resultadop5 = (int) (resultadop5 + 15);
                                resultadop_5 = resultadop5;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb_p5_5:
                                resultadop5 = 0;
                                resultadop_5 = resultadop5;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg_respuestas6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb_p6:

                                resultadop6 = (int) (resultadop6 + 15);
                                resultadop_6 = resultadop6;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb_p6_6:
                                resultadop6 = 0;
                                resultadop_6 = resultadop6;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg_respuestas7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb_p7:

                                resultadop7 = (int) (resultadop7 + 15);
                                resultadop_7 = resultadop7;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb_p7_7:
                                resultadop7 = 0;
                                resultadop_7 = resultadop7;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                btn_calcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        todos=resultado+resultadop2+resultadop3+resultadop4+resultadop5+resultadop6+resultadop_7;

<<<<<<< HEAD
                        if(todos>= 100){
                            nivel= "Trl2";
                            Intent intent = new Intent(Tlr1_1.this,Trl2.class);
                            startActivity(intent);
                        }
=======
>>>>>>> 084ffec72e577649eee33501e5a4428c4d9846ec


                        if(todos>= 100) {
                            nivel = "Tlr2";

                                Intent intent = new Intent(Tlr1_1.this, Trl2.class);
                                startActivity(intent);
                                Toast.makeText(Tlr1_1.this, "su porcentaje es :" + todos + "%", Toast.LENGTH_SHORT).show();

                        }
                       else{
                            Intent intent = new Intent(Tlr1_1.this,Login.class);
                            startActivity(intent);
                            Toast.makeText(Tlr1_1.this, "sus resultados "+ todos +"%", Toast.LENGTH_SHORT).show();
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



