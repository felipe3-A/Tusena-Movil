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

public class Trl9 extends AppCompatActivity {

    public static List<Preguntas> list = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference myref;
    public static String nivel9;
    Button btn_calcular9;
    TextView txt_trl9p1, txt_trl9p2, txt_trl9p3, txt_trl9p4, txt_trl9p5, txt_trl9p6, txt_trl9p7;

    RadioGroup rg9_respuestas1, rg9_respuestas2, rg9_respuestas3, rg9_respuestas4, rg9_respuestas5, rg9_respuestas6, rg9_respuestas7;
    RadioButton rd9_p1, rd9_p_1, rd9_p2, rd9_p2_2, rd9_p3, rb9_p_3, rb9_p4, rb9_p4_4, rb9_p5, rb9_p5_5, rb9_p6,rb9_p6_6,rb9_p7,rb9_p7_7;
    public static int
            resultado9_1,
            resultado9_1_1,
            resultado9_2,
            resultado9_2_2,
            resultado9_3,
            resultado9_3_3,
            resultado9_4,
            resultado9_4_4,
            resultado9_5,
            resultado9_5_5,
            resultado9_6,
            resultado9_6_6,
            resultado9_7,
            resultado9_7_7,

            todos9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl9);
        txt_trl9p1 = findViewById(R.id.txt_trl9p1);
        txt_trl9p2 = findViewById(R.id.txt_trl9p2);
        txt_trl9p3 = findViewById(R.id.txt_trl9p3);
        txt_trl9p4 = findViewById(R.id.txt_trl9p4);
        txt_trl9p5 = findViewById(R.id.txt_trl9p5);
        txt_trl9p6 = findViewById(R.id.txt_trl9p6);
        txt_trl9p7 = findViewById(R.id.txt_trl9p7);


        btn_calcular9 = findViewById(R.id.btn_calcular9);
        cargarP();

        rg9_respuestas1 = findViewById(R.id.rg9_respuestas1);
        rd9_p1 = findViewById(R.id.rd9_p1);
        rd9_p_1 = findViewById(R.id.rd9_p_1);

        rg9_respuestas2 = findViewById(R.id.rd9_respuesta2);
        rd9_p2 = findViewById(R.id.rb9_p2);
        rd9_p2_2 = findViewById(R.id.rb9_p_2);

        rg9_respuestas3 = findViewById(R.id.rg9_respuestas3);
        rd9_p3 = findViewById(R.id.rb9_p3);
        rb9_p_3 = findViewById(R.id.rb9_p_3);

        rg9_respuestas4 = findViewById(R.id.rg9_respuestas4);
        rb9_p4 = findViewById(R.id.rb9_p4);
        rb9_p4_4 = findViewById(R.id.rb9_p_4);

        rg9_respuestas5 = findViewById(R.id.rg9_respuestas5);
        rb9_p5 = findViewById(R.id.rb9_p5);
        rb9_p5_5 = findViewById(R.id.rb9_p_5);

        rg9_respuestas6 = findViewById(R.id.rg9_respuestas6);
        rb9_p6 = findViewById(R.id.rb9_p6);
        rb9_p6_6 = findViewById(R.id.rb9_p_6);

        rg9_respuestas7 = findViewById(R.id.rg9_respuestas7);
        rb9_p7 = findViewById(R.id.rb9_p7);
        rb9_p7_7 = findViewById(R.id.rb9_p_7);

    }
    public void cargarP() {

        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION

        Query query = myref.child("Preguntas").orderByChild("nivel").equalTo("Tlr9");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Preguntas pregunta = dataSnapshot.getValue(Preguntas.class);
                    list.add(pregunta);
                }
                txt_trl9p1.setText(list.get(0).getPregunta());
                txt_trl9p2.setText(list.get(1).getPregunta());
                txt_trl9p3.setText(list.get(2).getPregunta());
                txt_trl9p4.setText(list.get(3).getPregunta());
                txt_trl9p5.setText(list.get(4).getPregunta());
                txt_trl9p6.setText(list.get(5).getPregunta());
                txt_trl9p7.setText(list.get(6).getPregunta());

                rg9_respuestas1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i){
                            case R.id.rd9_p1:

                                resultado9_1= (resultado9_1+15);
                                resultado9_1_1=resultado9_1;
                                cargarP();
                                // Toast.makeText(Trl3.this, "Su porcentaje es: "+resultado , Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb9_p_2:
                                resultado9_1=0;
                                resultado9_1_1=resultado9_1;
                                cargarP();
                                // Toast.makeText(Trl3.this, "ghjj"+resultado, Toast.LENGTH_SHORT).show();
                                break;

                        }

                    }
                });


                rg9_respuestas2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb9_p2:

                                resultado9_2 = (resultado9_2 + 15);
                                resultado9_2_2 = resultado9_2;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb9_p_2:
                                resultado9_2 = 0;
                                resultado9_2_2 = resultado9_2;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }
                    }
                });

                rg9_respuestas3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb4_p3:

                                resultado9_3 = (resultado9_3 + 15);
                                resultado9_3_3 = resultado9_3;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb4_p_3:
                                resultado9_3 = 0;
                                resultado9_3_3 = resultado9_3;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });
                rg9_respuestas4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb9_p4:

                                resultado9_4 = (resultado9_4 + 15);
                                resultado9_4_4 = resultado9_4;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb9_p_4:
                                resultado9_4 = 0;
                                resultado9_4_4 = resultado9_4;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg9_respuestas5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb9_p5:

                                resultado9_5 = (int) (resultado9_5 + 15);
                                resultado9_5_5 = resultado9_5;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb9_p_5:
                                resultado9_5 =0;
                                resultado9_5_5 = resultado9_5;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg9_respuestas6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb9_p6:

                                resultado9_6 =  (resultado9_6 + 15);
                                resultado9_6_6 = resultado9_6;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb9_p_6:
                                resultado9_6 =0;
                                resultado9_6_6 = resultado9_6;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }

                    }
                });

                rg9_respuestas7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb9_p7:

                                resultado9_7 = (resultado9_7 +20);
                                resultado9_7_7 = resultado9_7;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb9_p_7:
                                resultado9_7 =0;
                                resultado9_7_7 = resultado9_7;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }

                    }
                });

                btn_calcular9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Resultados resultados = new Resultados();
                        resultados.setId(UUID.randomUUID().toString());
                        resultados.setPorcentaje(todos9);
                        resultados.setNivel(nivel9);
                        resultados.setInvestigador(Menu_Principal.nombre_investigador);
                        resultados.setId_investigador(Menu_Principal.id_investigador);
                        resultados.setProducto(Menu_Principal.producto_investigador);
                        resultados.setAnio(Menu_Principal.anio);
                        resultados.setProyecto(Menu_Principal.proyecto);

                        todos9=resultado9_1+resultado9_2+resultado9_3+resultado9_5+resultado9_6+resultado9_7;
                        String id_investigador=Menu_Principal.id_investigador;
                        String nombre_producto=Menu_Principal.producto_investigador;


                        if(todos9>= 100) {
                            Resultados.nivel=Resultados.nivel="Trl9";
                            Resultados.porcentaje=Resultados.porcentaje=todos9;
                            updateData(nivel9,todos9,nombre_producto);
                            Intent intent = new Intent(Trl9.this, Menu_Principal.class);
                            startActivity(intent);
                            Toast.makeText(Trl9.this, "Muy Bien tu producto es lo mejor" + " " +  todos9 + "%" ,Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Resultados.nivel=Resultados.nivel="Trl8";
                            Resultados.porcentaje=Resultados.porcentaje=todos9;
                            updateData1(id_investigador);
                            Intent intent = new Intent(Trl9.this, Error_Trl.class);
                            startActivity(intent);
                            Toast.makeText(Trl9.this, "sus resultados "+ todos9 +"%", Toast.LENGTH_SHORT).show();
                        }
                    }
                    private void updateData(String nivel9, int porcentaje,String nombre_producto) {

                        HashMap resulttado = new HashMap();
                        resulttado.put("nivel", nivel9);
                        resulttado.put("porcentaje",porcentaje);

                        myref.child("Respuestas").child(nombre_producto).updateChildren(resulttado).addOnCompleteListener(new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Trl9.this, "Datos actualixados", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Trl9.this, "Err0r", Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(Trl9.this, "Datos actualixados", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Trl9.this, "Err0r", Toast.LENGTH_SHORT).show();
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