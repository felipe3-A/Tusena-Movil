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

public class Trl_8 extends AppCompatActivity {

    public static List<Preguntas> list = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference myref;
    public static String nivel8;
    Button btn_calcular8;
    TextView txt_trl8p1, txt_trl8p2, txt_trl8p3, txt_trl8p4, txt_trl8p5, txt_trl8p6, txt_trl8p7;

    RadioGroup rg8_respuestas1, rg8_respuestas2, rg8_respuestas3, rg8_respuestas4, rg8_respuestas5, rg8_respuestas6,rg8_respuestas7;
    RadioButton rd8_p1, rd8_p_1, rd8_p2, rd8_p2_2, rd8_p3, rb8_p_3, rb8_p4, rb8_p4_4, rb8_p5, rb8_p5_5, rb8_p6, rb8_p6_6, rb8_p7, rb8_p7_7;

    public static int
            resultadot8_1,
            resultado8_1_1,
            resultado8_2,
            resultado8_2_2,
            resultado8_3,
            resultado8_3_3,
            resultado8_4,
            resultado8_4_4,
            resultado8_5,
            resultado8_5_5,
            resultado8_6,
            resultado8_6_6,
            resultado8_7,
            resultado8_7_7,

            todos8;


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

        rg8_respuestas1 = findViewById(R.id.rg8_respuestas1);
        rd8_p1 = findViewById(R.id.rd8_p1);
        rd8_p_1 = findViewById(R.id.rd8_p_1);

        rg8_respuestas2 = findViewById(R.id.rd8_repuesta2);
        rd8_p2 = findViewById(R.id.rb8_p2);
        rd8_p2_2 = findViewById(R.id.rb8_p_2);

        rg8_respuestas3 = findViewById(R.id.rg8_respuestas3);
        rd8_p3 = findViewById(R.id.rb8_p3);
        rb8_p_3 = findViewById(R.id.rb8_p_3);

        rg8_respuestas4 = findViewById(R.id.rg8_respuestas4);
        rb8_p4 = findViewById(R.id.rb8_p4);
        rb8_p4_4 = findViewById(R.id.rb8_p_4);

        rg8_respuestas5 = findViewById(R.id.rg8_respuestas5);
        rb8_p5 = findViewById(R.id.rb8_p5);
        rb8_p5_5 = findViewById(R.id.rb8_p_5);

        rg8_respuestas6 = findViewById(R.id.rg8_respuestas6);
        rb8_p6 = findViewById(R.id.rb8_p6);
        rb8_p6_6 = findViewById(R.id.rb8_p_6);

        rg8_respuestas7 = findViewById(R.id.rg8_respuestas7);
        rb8_p7 = findViewById(R.id.rb8_p7);
        rb8_p7_7 = findViewById(R.id.rb8_p_7);

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


                rg8_respuestas1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i){
                            case R.id.rd8_p1:

                                resultadot8_1= (resultadot8_1+15);
                                resultado8_1_1=resultadot8_1;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                // Toast.makeText(Trl3.this, "Su porcentaje es: "+resultado , Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rd8_p_1:
                                resultadot8_1= 0;
                                resultado8_1_1=resultadot8_1;
                                cargarP();
                                // Toast.makeText(Trl3.this, "ghjj"+resultado, Toast.LENGTH_SHORT).show();
                                break;

                        }

                    }
                });


                rg8_respuestas2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb8_p2:

                                resultado8_2 = (resultado8_2 + 15);
                                resultado8_2_2 = resultado8_2;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb8_p_2:
                                resultado8_2 = 0;
                                resultado8_2_2 = resultado8_2;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });

                rg8_respuestas3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb8_p3:

                                resultado8_3 =(resultado8_3 + 15);
                                resultado8_3_3 = resultado8_3;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb8_p_3:
                                resultado8_3 = 0;
                                resultado8_3_3 = resultado8_3;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });
                rg8_respuestas4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb8_p4:

                                resultado8_4 = (resultado8_4 + 15);
                                resultado8_4_4 = resultado8_4;

                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb8_p_4:
                                resultado8_4 = 0;
                                resultado8_4_4 = resultado8_4;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });

                rg8_respuestas5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb8_p5:

                                resultado8_5 =(resultado8_5 + 15);
                                resultado8_5_5 = resultado8_5;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb8_p_5:
                                resultado8_5 =0;
                                resultado8_5_5 = resultado8_5;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg8_respuestas6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb8_p6:
                                resultado8_6 =(resultado8_6 + 15);
                                resultado8_6_6 = resultado8_6;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb5_p_6:
                                resultado8_6 = 0;
                                resultado8_6_6 = resultado8_6;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
                rg8_respuestas7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb8_p7:

                                resultado8_7 = (resultado8_7 + 10);
                                resultado8_7_7 = resultado8_7;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb8_p_7:
                                resultado8_7 = 0;
                                resultado8_7_7 = resultado8_7;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });

                btn_calcular8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Resultados resultados = new Resultados();
                        resultados.setId(UUID.randomUUID().toString());
                        resultados.setPorcentaje(todos8);
                        resultados.setNivel(nivel8);
                        resultados.setInvestigador(Menu_Principal.nombre_investigador);
                        resultados.setId_investigador(Menu_Principal.id_investigador);
                        resultados.setProducto(Menu_Principal.producto_investigador);
                        resultados.setAnio(Menu_Principal.anio);
                        resultados.setProyecto(Menu_Principal.proyecto);
                        resultados.setTipo_producto(Menu_Principal.tipo);
                        todos8=resultadot8_1+resultado8_2+resultado8_3+resultado8_4+resultado8_5+resultado8_6+resultado8_7;

                        String id_investigador=Menu_Principal.id_investigador;
                        String nombre_producto=Menu_Principal.producto_investigador;


                        if(todos8>= 100) {
                            Resultados.nivel=Resultados.nivel="Trl8";
                            Resultados.porcentaje=Resultados.porcentaje=todos8;
                            updateData(nivel8,todos8,nombre_producto);
                            Intent intent = new Intent(Trl_8.this, Trl9.class);
                            startActivity(intent);
                            Toast.makeText(Trl_8.this, "Muy Bien, Sigues al siguiente nivel" + " " +  todos8+ "%", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Resultados.nivel=Resultados.nivel="Trl7";
                            Resultados.porcentaje=Resultados.porcentaje=todos8;
                            updateData1(id_investigador);
                            Intent intent = new Intent(Trl_8.this, Buscador_Botones.class);
                            startActivity(intent);
                            Toast.makeText(Trl_8.this, "sus resultados "+ todos8 +"%", Toast.LENGTH_SHORT).show();
                        }
                    }
                    private void updateData(String nivel8, int porcentaje,String nombre_producto) {

                        HashMap resulttado = new HashMap();
                        resulttado.put("nivel", nivel8);
                        resulttado.put("porcentaje",porcentaje);

                        myref.child("Respuestas").child(nombre_producto).updateChildren(resulttado).addOnCompleteListener(new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Trl_8.this, "Datos actualizados", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Trl_8.this, "Err0r", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                    }
                    private void updateData1(String id_investigador) {
                        HashMap resulttado = new HashMap();
                        myref.child("Respuestas").child(id_investigador).updateChildren(resulttado).addOnCompleteListener(new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Trl_8.this, "Datos actualizados", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Trl_8.this, "Err0r", Toast.LENGTH_SHORT).show();
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