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

public class Trl7 extends AppCompatActivity {

    public static List<Preguntas> list = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference myref;
    public static String nivel;
    Button btn_calcular7;
    TextView txt_trl7p1, txt_trl7p2, txt_trl7p3, txt_trl7p4, txt_trl7p5, txt_trl7p6, txt_trl7p7;

    RadioGroup rg7_respuestas1, rg7_respuestas2, rg7_respuestas3, rg7_respuestas4, rg7_respuestas5, rg7_respuestas6, rg7_respuestas7;

    RadioButton rd7_p1, rd7_p_1, rd7_p2, rd7_p2_2, rd7_p3, rb7_p_3, rb7_p4, rb7_p4_4, rb7_p5, rb7_p5_5, rb7_p6, rb7_p6_6, rb7_p7, rb7_p7_7;
    public static int
    resultadot7_1,
    resultado7_1_1,
    resultado7_2,
    resultado7_2_2,
    resultado7_3,
    resultado7_3_3,
    resultado7_4,
    resultado7_4_4,
    resultado7_5,
    resultado7_5_5,
    resultado7_6,
    resultado7_6_6,
    resultado7_7,
    resultado7_7_7,

    todos7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl7);

        txt_trl7p1 = findViewById(R.id.txt_trl7p1);
        txt_trl7p2 = findViewById(R.id.txt_trl7p2);
        txt_trl7p3 = findViewById(R.id.txt_trl7p3);
        txt_trl7p4 = findViewById(R.id.txt_trl7p4);
        txt_trl7p5 = findViewById(R.id.txt_trl7p5);
        txt_trl7p6 = findViewById(R.id.txt_trl7p6);
        txt_trl7p7 = findViewById(R.id.txt_trl7p7);

        rg7_respuestas1 = findViewById(R.id.rg7_respuestas1);
        rd7_p1 = findViewById(R.id.rd7_p1);
        rd7_p_1 = findViewById(R.id.rd7_p_1);

        rg7_respuestas2 = findViewById(R.id.rd7_repuesta2);
        rd7_p2 = findViewById(R.id.rb7_p2);
        rd7_p2_2 = findViewById(R.id.rb7_p_2);

        rg7_respuestas3 = findViewById(R.id.rg7_respuestas3);
        rd7_p3 = findViewById(R.id.rb7_p3);
        rb7_p_3 = findViewById(R.id.rb7_p_3);

        rg7_respuestas4 = findViewById(R.id.rg7_respuestas4);
        rb7_p4 = findViewById(R.id.rb7_p4);
        rb7_p4_4 = findViewById(R.id.rb7_p_4);

        rg7_respuestas5 = findViewById(R.id.rg7_respuestas5);
        rb7_p5 = findViewById(R.id.rb7_p5);
        rb7_p5_5 = findViewById(R.id.rb7_p_5);

        rg7_respuestas6 = findViewById(R.id.rg7_respuestas6);
        rb7_p6 = findViewById(R.id.rb7_p6);
        rb7_p6_6 = findViewById(R.id.rb7_p_6);

        rg7_respuestas7 = findViewById(R.id.rg7_respuestas7);
        rb7_p7 = findViewById(R.id.rb7_p7);
        rb7_p7_7 = findViewById(R.id.rb7_p_7);



        btn_calcular7 = findViewById(R.id.btn_calcular7);
        cargarP();
    }
    public void cargarP() {

        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION

        Query query = myref.child("Preguntas").orderByChild("nivel").equalTo("Tlr7");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Preguntas pregunta = dataSnapshot.getValue(Preguntas.class);
                    list.add(pregunta);
                }
                txt_trl7p1.setText(list.get(0).getPregunta());
                txt_trl7p2.setText(list.get(1).getPregunta());
                txt_trl7p3.setText(list.get(2).getPregunta());
                txt_trl7p4.setText(list.get(3).getPregunta());
                txt_trl7p5.setText(list.get(4).getPregunta());
                txt_trl7p6.setText(list.get(5).getPregunta());
                txt_trl7p7.setText(list.get(6).getPregunta());

                rg7_respuestas1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId){
                            case R.id.rd7_p1:

                                resultadot7_1= (resultadot7_1+15);
                                resultado7_1_1=resultadot7_1;
                                cargarP();
                                // Toast.makeText(Trl3.this, "Su porcentaje es: "+resultado , Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rd7_p_1:
                                resultadot7_1=0;
                                resultado7_1_1=resultadot7_1;
                                cargarP();
                                // Toast.makeText(Trl3.this, "ghjj"+resultado, Toast.LENGTH_SHORT).show();
                                break;

                        }

                    }
                });

                rg7_respuestas2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.rb7_p2:

                                resultado7_2 = (resultado7_2 + 15);
                                resultado7_2_2 = resultado7_2;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb7_p_2:
                                resultado7_2 = 0;
                                resultado7_2_2 = resultado7_2;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });

                rg7_respuestas3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.rb7_p3:

                                resultado7_3 = (resultado7_3 + 15);
                                resultado7_3_3 = resultado7_3;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb7_p_3:
                                resultado7_3 = 0;
                                resultado7_3_3 = resultado7_3;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });

                rg7_respuestas4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.rb7_p4:

                                resultado7_4 = (resultado7_4 + 15);
                                resultado7_4_4 = resultado7_4;
                                //txtresultado.setText("sus puntos" + puntos);
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb7_p_4:
                                resultado7_4 = 0;
                                resultado7_4_4 = resultado7_4;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });

                rg7_respuestas5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.rb7_p5:

                                resultado7_5 = (int) (resultado7_5 + 15);
                                resultado7_5_5 = resultado7_5;
                                cargarP();
                                //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.rb7_p_5:
                                resultado7_5 =0;
                                resultado7_5_5 = resultado7_5;
                                cargarP();
                                //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
                 rg7_respuestas6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                     @Override
                     public void onCheckedChanged(RadioGroup group, int checkedId) {
                         switch (checkedId) {
                             case R.id.rb7_p6:

                                 resultado7_6 =  (resultado7_6 + 15);
                                 resultado7_6_6 = resultado7_6;
                                 cargarP();
                                 //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                 break;

                             case R.id.rb4_p_7:
                                 resultado7_6 =0;
                                 resultado7_6_6 = resultado7_6;
                                 cargarP();
                                 //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                 break;
                         }

                     }
                 });

                 rg7_respuestas7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                     @Override
                     public void onCheckedChanged(RadioGroup group, int checkedId) {
                         switch (checkedId) {
                             case R.id.rb7_p7:

                                 resultado7_7 = (resultado7_7 +25);
                                 resultado7_7_7 = resultado7_7;
                                 //txtresultado.setText("sus puntos" + puntos);
                                 cargarP();
                                 //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                                 break;

                             case R.id.rb7_p_7:
                                 resultado7_7 =0;
                                 resultado7_7_7 = resultado7_7;
                                 cargarP();
                                 //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                                 break;
                         }

                     }
                 });

                 btn_calcular7.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {

                         todos7=resultadot7_1+resultado7_2+resultado7_3+resultado7_5+resultado7_6+resultado7_7;
                         nivel="Trl7";
                         cargarResultados();


                         if(todos7>= 100) {
                             nivel = "Tlr4";

                             Intent intent = new Intent(Trl7.this, Trl_8.class);
                             startActivity(intent);
                             Toast.makeText(Trl7.this, "Muy Bien, Sigues al siguiente nivel con " + " " +  todos7 + "%" ,Toast.LENGTH_SHORT).show();

                         }
                         else{
                             nivel = "Tlr7";
                             Intent intent = new Intent(Trl7.this, Error_Trl.class);
                             startActivity(intent);
                             Toast.makeText(Trl7.this, "sus resultados "+ todos7 +"%", Toast.LENGTH_SHORT).show();
                         }
                     }

                     private void cargarResultados() {
                         Resultados resultados = new Resultados();

                         resultados.setId(UUID.randomUUID().toString());
                         resultados.setInvestigador(Menu_Principal.nombre_investigador);
                         resultados.setProducto(Menu_Principal.producto_investigador);
                         resultados.setNivel(nivel);
                         resultados.setProyecto(Admin2.proyecto);
                         resultados.setPorcentaje(todos7);

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