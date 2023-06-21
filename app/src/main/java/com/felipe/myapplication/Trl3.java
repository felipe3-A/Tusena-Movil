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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Trl3 extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myref;
    public static String nivel;
    Button btn_calcular3;
    TextView txt_trl3p1, txt_trl3p2, txt_trl3p3, txt_trl3p4, txt_trl3p5, txt_trl3p6, txt_trl3p7, txt_trl3p8;

    RadioGroup rg3_respuestas1, rg3_respuestas2, rg3_respuestas3, rg3_respuestas4, rg3_respuestas5, rg3_respuestas6, rg3_respuestas7, rg3_respuestas8;
    RadioButton rd3_p1, rd3_p_1, rd3_p2, rd3_p2_2, rd3_p3, rb3_p3_3, rb3_p4, rb3_p4_4, rb3_p5, rb3_p5_5, rb3_p6, rb3_p6_6, rb3_p7, rb3_p7_7, rb3_p8, rb3_p7_8;

    public static int

            resultadot3_1,
            resultado3_1_1,
            resultado3_2,
            resultado3_2_2,
            resultado3_3,
            resultado3_3_3,
            resultado3_4,
            resultado3_4_4,
            resultado3_5,
            resultado3_5_5,
            resultado3_6,
            resultado3_6_6,
            resultado3_7,
            resultado3_7_7,
            resultado3_8,
            resultado3_8_8,
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
                        switch (i) {
                            case R.id.rd3_p1:

                                resultadot3_1 = (int) (resultadot3_1 + 12.5);
                                resultado3_1_1 = resultadot3_1;
                                cargarP();
                                // Toast.makeText(Trl3.this, "Su porcentaje es: "+resultado , Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rd3_p_1:
                                resultadot3_1 = 0;
                                resultado3_1_1 = resultadot3_1;
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

                                resultado3_2 = (int) (resultado3_2 + 12.5);
                                resultado3_2_2 = resultado3_2;

                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_2:
                                resultado3_2 = 0;
                                resultado3_2_2 = resultado3_2;
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

                                resultado3_3 = (int) (resultado3_3 + 12.5);
                                resultado3_3_3 = resultado3_3;

                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_3:
                                resultado3_3 = 0;
                                resultado3_3_3 = resultado3_3;
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

                                resultado3_4 = (int) (resultado3_4 + 12.5);
                                resultado3_4_4 = resultado3_4;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_4:
                                resultado3_4 = 0;
                                resultado3_4_4 = resultado3_4;
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

                                resultado3_5 = (resultado3_5 + 13);
                                resultado3_5_5 = resultado3_5;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_5:
                                resultado3_5 = 0;
                                resultado3_5_5 = resultado3_5;
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

                                resultado3_6 = (resultado3_6 + 13);
                                resultado3_6_6 = resultado3_6;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_6:
                                resultado3_6 = 0;
                                resultado3_6_6 = resultado3_6;
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

                                resultado3_7 = (resultado3_7 + 13);
                                resultado3_7_7 = resultado3_7;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_7:
                                resultado3_7 = 0;
                                resultado3_7_7 = resultado3_7;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });
                rg3_respuestas8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.rb3_p8:

                                resultado3_8 = (resultado3_8 + 13);
                                resultado3_8_8 = resultado3_8;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb3_p_8:
                                resultado3_8 = 0;
                                resultado3_8_8 = resultado3_8;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                btn_calcular3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        todos3 = resultadot3_1 + resultado3_2 + resultado3_3 + resultado3_4 + resultado3_5 + resultado3_6 + resultado3_7 + resultado3_8;
                        nivel = "Trl3";
                        String id_investigador=Menu_Principal.nombre_investigador;



                        if (todos3 >= 100) {
                            //nivel = "Tlr2";
                            updateData(nivel,id_investigador,todos3);

                            Intent intent = new Intent(Trl3.this, Trl4.class);
                            startActivity(intent);
                            Toast.makeText(Trl3.this, "Muy Bien, Sigues al siguiente nivel con " + " " + todos3 + "%", Toast.LENGTH_SHORT).show();

                        } else {
                            nivel = "Tlr3";
                            updateData1(id_investigador);
                            Intent intent = new Intent(Trl3.this, Error_Trl.class);
                            startActivity(intent);
                            Toast.makeText(Trl3.this, "sus resultados " + todos3 + "%", Toast.LENGTH_SHORT).show();
                        }


                    }

                    private void updateData(String nivel3, String id_investigador, int porcentaje) {

                        HashMap resulttado = new HashMap();
                        resulttado.put("nivel", nivel3);
                        resulttado.put("porcentaje",porcentaje);

                        myref=FirebaseDatabase.getInstance().getReference("Respuestas");
                        myref.child(id_investigador).updateChildren(resulttado).addOnCompleteListener(new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Trl3.this, "Datos actualixados", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Trl3.this, "Err0r", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                    }


                    private void updateData1(String id_investigador) {
                        HashMap resulttado = new HashMap();


                        myref.child(id_investigador).updateChildren(resulttado).addOnCompleteListener(new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Trl3.this, "Datos actualixados", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Trl3.this, "Err0r", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                    }


                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }






}