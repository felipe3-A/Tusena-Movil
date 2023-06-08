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
import java.util.UUID;

public class Trl4 extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myref;
    public static String nivel;
    Button btn_calcular4;
    TextView txt_trl4p1, txt_trl4p2, txt_trl4p3, txt_trl4p4, txt_trl4p5, txt_trl4p6, txt_trl4p7;

    RadioGroup rg4_respuestas1,rg4_respuestas2,rg4_respuestas3,rg4_respuestas4,rg4_respuestas5,rg4_respuestas6,rg4_respuestas7;
    RadioButton rd4_p1, rd4_p_1,rd4_p2, rd4_p2_2,rd4_p3, rb4_p_3,rb4_p4, rb4_p4_4,rb4_p5, rb4_p5_5,rb4_p6, rb4_p6_6,rb4_p7, rb4_p7_7;

    public static int
            resultadot4_1,
            resultado4_1_1,
            resultado4_2,
            resultado4_2_2,
            resultado4_3,
            resultado4_3_3,
            resultado4_4,
            resultado4_4_4,
            resultado4_5,
            resultado4_5_5,
            resultado4_6,
            resultado4_6_6,
            resultado4_7,
            resultado4_7_7,

            todos4;
    public static List<Preguntas> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl4);

        txt_trl4p1 = findViewById(R.id.txt_trl4p1);
        txt_trl4p2 = findViewById(R.id.txt_trl4p2);
        txt_trl4p3 = findViewById(R.id.txt_trl4p3);
        txt_trl4p4 = findViewById(R.id.txt_trl4p4);
        txt_trl4p5 = findViewById(R.id.txt_trl4p5);
        txt_trl4p6 = findViewById(R.id.txt_trl4p6);
        txt_trl4p7 = findViewById(R.id.txt_trl4p7);

        btn_calcular4 = findViewById(R.id.btn_calcular4);

        rg4_respuestas1 = findViewById(R.id.rg4_respuestas1);
        rd4_p1 = findViewById(R.id.rd4_p1);
        rd4_p_1 = findViewById(R.id.rd4_p_1);

        rg4_respuestas2 = findViewById(R.id.rd4_repuesta2);
        rd4_p2 = findViewById(R.id.rb4_p2);
        rd4_p2_2 = findViewById(R.id.rb4_p_2);

        rg4_respuestas3 = findViewById(R.id.rg4_respuestas3);
        rd4_p3 = findViewById(R.id.rb4_p3);
        rb4_p_3 = findViewById(R.id.rb4_p_3);

        rg4_respuestas4 = findViewById(R.id.rg4_respuestas4);
        rb4_p4 = findViewById(R.id.rb4_p4);
        rb4_p4_4 = findViewById(R.id.rb4_p_4);

        rg4_respuestas5 = findViewById(R.id.rg4_respuestas5);
        rb4_p5 = findViewById(R.id.rb4_p5);
        rb4_p5_5 = findViewById(R.id.rb4_p_5);

        rg4_respuestas6 = findViewById(R.id.rg4_respuestas6);
        rb4_p6 = findViewById(R.id.rb4_p6);
        rb4_p6_6 = findViewById(R.id.rb4_p_6);

        rg4_respuestas7 = findViewById(R.id.rg4_respuestas7);
        rb4_p7 = findViewById(R.id.rb4_p7);
        rb4_p7_7 = findViewById(R.id.rb4_p_7);



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
                txt_trl4p1.setText(list.get(0).getPregunta());
                txt_trl4p2.setText(list.get(1).getPregunta());
                txt_trl4p3.setText(list.get(2).getPregunta());
                txt_trl4p4.setText(list.get(3).getPregunta());
                txt_trl4p5.setText(list.get(4).getPregunta());
                txt_trl4p6.setText(list.get(5).getPregunta());
                txt_trl4p7.setText(list.get(6).getPregunta());



                rg4_respuestas1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i){
                            case R.id.rd4_p1:

                                resultadot4_1= (resultadot4_1+15);
                                resultado4_1_1=resultadot4_1;
                                cargarP();
                                // Toast.makeText(Trl3.this, "Su porcentaje es: "+resultado , Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rd4_p_1:
                                resultadot4_1=0;
                                resultado4_1_1=resultadot4_1;
                                cargarP();
                                // Toast.makeText(Trl3.this, "ghjj"+resultado, Toast.LENGTH_SHORT).show();
                                break;

                        }

                    }
                });


                rg4_respuestas2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb4_p2:

                                resultado4_2 = (resultado4_2 + 15);
                                resultado4_2_2 = resultado4_2;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb4_p_2:
                                resultado4_2 = 0;
                                resultado4_2_2 = resultado4_2;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }
                    }
                });

                rg4_respuestas3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb4_p3:

                                resultado4_3 = (resultado4_3 + 15);
                                resultado4_3_3 = resultado4_3;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb4_p_3:
                                resultado4_3 = 0;
                                resultado4_3_3 = resultado4_3;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });
                rg4_respuestas4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb4_p4:

                                resultado4_4 = (resultado4_4 + 15);
                                resultado4_4_4 = resultado4_4;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb4_p_4:
                                resultado4_4 = 0;
                                resultado4_4_4 = resultado4_4;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg4_respuestas5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb4_p5:

                                resultado4_5 = (int) (resultado4_5 + 15);
                                resultado4_5_5 = resultado4_5;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb4_p_5:
                                resultado4_5 =0;
                                resultado4_5_5 = resultado4_5;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;


                        }

                    }
                });

                rg4_respuestas6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb4_p6:

                                resultado4_6 =  (resultado4_6 + 15);
                                resultado4_6_6 = resultado4_6;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb4_p_6:
                                resultado4_6 =0;
                                resultado4_6_6 = resultado4_6;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }

                    }
                });

                rg4_respuestas7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.rb4_p7:

                                resultado4_7 = (resultado4_7 +25);
                                resultado4_7_7 = resultado4_7;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb4_p_7:
                                resultado4_7 =0;
                                resultado4_7_7 = resultado4_7;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }

                    }
                });

                btn_calcular4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        todos4=resultadot4_1+resultado4_2+resultado4_3+resultado4_5+resultado4_6+resultado4_7;
                        cargarResultados();


                        if(todos4>= 100) {
                            //nivel = "Tlr4";

                            Intent intent = new Intent(Trl4.this, Trl5.class);
                            startActivity(intent);
                            Toast.makeText(Trl4.this, "Muy Bien, Sigues al siguiente nivel con " + " " +  todos4 + "%" ,Toast.LENGTH_SHORT).show();

                        }
                        else{
                            nivel = "Tlr4";
                            Intent intent = new Intent(Trl4.this, Error_Trl.class);
                            startActivity(intent);
                            Toast.makeText(Trl4.this, "sus resultados "+ todos4 +"%", Toast.LENGTH_SHORT).show();
                        }
                    }


                    private void cargarResultados() {
                        Resultados resultados = new Resultados();

                        resultados.setId(UUID.randomUUID().toString());
                        resultados.setInvestigador(Admin2.investigador);
                        resultados.setProducto(Admin2.producto);
                        resultados.setNivel(Admin.nivel);
                        resultados.setProyecto(Admin2.proyecto);
                        resultados.setPorcentaje(todos4);

                        myref.child("Respuestas").child(resultados.getId()).setValue(resultados); //insercion
                    }
                });



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}