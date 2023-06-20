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

import com.felipe.myapplication.databinding.ActivityTrl2Binding;
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
import java.util.Random;
import java.util.UUID;

public class Trl2 extends AppCompatActivity {

    ActivityTrl2Binding binding;

    FirebaseDatabase database;
    DatabaseReference myref;
    public static String nivel2;
    public static String prueba;
    TextView txt_trl2p1, txt_trl2p2, txt_trl2p3, txt_trl2p4, txt_trl2p5, txt_trl2p6, txt_trl2p7,txt_trl2p8;
    RadioGroup rg2_respuestas,rg2_respuestas2,rg2_respuestas3,rg2_respuestas4,rg2_respuestas5,rg2_respuestas6,rg2_respuestas7,rg2_respuestas8;
    RadioButton rb2_p1, rb2_p_1,rb2_p2, b2_p2_2,rb2_p3, rb2_p3_3,rb2_p4, rb2_p4_4,rb2_p5, rb2_p5_5,rb2_p6, rb2_p6_6,rb2_p7, rb2_p7_7,rb2_p8,rb2_p8_8;

    Button btn_calcular2;

    public static int
            resultados1_1_1,
            resultados1_1,
            resultado2_2,
            resultadop2_2_2,
            resultadop3_3,
          resultadop_3_3_3,
           resultadop4_4,
         resultadop_4_4_4,
          resultadop5_5,
           resultadop_5_5_5,
           resultadop6_6,
           resultadop_6_6_6,
          resultadop7_7,
            resultadop_7_7,
            resultadop8_8,
            resultadop_8_8_8,
    todos2;


    public static List<Preguntas> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl2);

        binding = ActivityTrl2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txt_trl2p1 = findViewById(R.id.txt_trl2p1);
        txt_trl2p2 = findViewById(R.id.txt_trl2p2);
        txt_trl2p3 = findViewById(R.id.txt_trl2p3);
        txt_trl2p4 = findViewById(R.id.txt_trl2p4);
        txt_trl2p5 = findViewById(R.id.txt_trl2p5);
        txt_trl2p6 = findViewById(R.id.txt_trl2p6);
        txt_trl2p7 = findViewById(R.id.txt_trl2p7);
        txt_trl2p8 = findViewById(R.id.txt_trl2p8);

        rg2_respuestas = findViewById(R.id.rg2_respuestas2);
        rb2_p1 = findViewById(R.id.rd2_p1);
        rb2_p_1 = findViewById(R.id.rb2_p_1);

        rg2_respuestas2 = findViewById(R.id.rd2_repuesta2);
        rb2_p2 = findViewById(R.id.rb2_p2);
        b2_p2_2 = findViewById(R.id.rb2_p2_2);

        rg2_respuestas3 = findViewById(R.id.rg2_respuestas3);
        rb2_p3 = findViewById(R.id.rb2_p3);
        rb2_p3_3 = findViewById(R.id.rb2_p3_3);

        rg2_respuestas4 = findViewById(R.id.rg2_respuestas4);
        rb2_p4 = findViewById(R.id.rb2_p4);
        rb2_p4_4 = findViewById(R.id.rb2_p4_4);

        rg2_respuestas5 = findViewById(R.id.rg2_respuestas5);
        rb2_p5 = findViewById(R.id.rb2_p5);
        rb2_p5_5= findViewById(R.id.rb2_p5_5);

        rg2_respuestas6 = findViewById(R.id.rg2_respuestas6);
        rb2_p6 = findViewById(R.id.rb2_p6);
        rb2_p6_6 = findViewById(R.id.rb2_p6_6);

        rg2_respuestas7 = findViewById(R.id.rg2_respuestas7);
        rb2_p7 = findViewById(R.id.rb2_p7);
        rb2_p7_7 = findViewById(R.id.rb2_p7_7);

        rg2_respuestas8 =findViewById(R.id.rg2_respuestas8);
        rb2_p8= findViewById(R.id.rb2_p8);
        rb2_p8_8 = findViewById(R.id.rb2_p8_8);



        btn_calcular2 = findViewById(R.id.btn_calcular2);





        cargarP();
        //list = findViewById(R.id.txt_trl1);

    }




    public void cargarP() {


        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION


        Query query = myref.child("Preguntas").orderByChild("nivel").equalTo("Tlr2");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Preguntas pregunta = dataSnapshot.getValue(Preguntas.class);
                    list.add(pregunta);
                }
                txt_trl2p1.setText(list.get(0).getPregunta());
                txt_trl2p2.setText(list.get(1).getPregunta());
                txt_trl2p3.setText(list.get(2).getPregunta());
                txt_trl2p4.setText(list.get(3).getPregunta());
                txt_trl2p5.setText(list.get(4).getPregunta());
                txt_trl2p6.setText(list.get(5).getPregunta());
                txt_trl2p7.setText(list.get(6).getPregunta());
                txt_trl2p8.setText(list.get(7).getPregunta());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        rg2_respuestas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rd2_p1:

                        resultados1_1= (int) (resultados1_1+12.5);
                        resultados1_1_1=resultados1_1;
                        cargarP();
                        //Toast.makeText(Trl2.this, "Su porcentaje es: " + resultados, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rd_p_1:
                        resultados1_1= 0;
                        resultados1_1_1=resultados1_1;
                        cargarP();
                        // Toast.makeText(Trl3.this, "ghjj"+resultado, Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
        rg2_respuestas2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rb2_p2:

                        resultado2_2 = (int)(resultado2_2 + 12.5);
                        resultadop2_2_2 = resultado2_2;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb_p2_2:
                        resultado2_2 =0;
                        resultadop2_2_2 = resultado2_2;
                        cargarP();
                        //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                        break;


                }

            }
        });

        rg2_respuestas3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId) {
                    case R.id.rb2_p3:

                        resultadop3_3 =(int)(resultadop_3_3_3 + 12.5);
                        resultadop_3_3_3 = resultadop3_3;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb2_p3_3:
                        resultadop3_3 =0;
                        resultadop_3_3_3 = resultadop3_3;
                        cargarP();
                        //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                        break;


                }

            }
        });

        rg2_respuestas4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb2_p4:

                        resultadop4_4 = (int) (resultadop4_4 + 12.5);
                        resultadop_4_4_4 = resultadop4_4;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb2_p4_4:
                        resultadop4_4 = 0;
                        resultadop_4_4_4 = resultadop4_4;
                        cargarP();
                        //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                        break;


                }



            }
        });

        rg2_respuestas5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rb2_p5:

                        resultadop5_5 =  (resultadop5_5 + 13);
                        resultadop_5_5_5 = resultadop5_5;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb2_p5_5:
                        resultadop5_5 =  0;
                        resultadop_5_5_5 = resultadop5_5;
                        cargarP();
                        //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                        break;


                }


            }
        });

        rg2_respuestas6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb2_p6:

                        resultadop6_6 = (int) (resultadop6_6 + 13);
                        resultadop_6_6_6 = resultadop6_6;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb2_p6_6:
                        resultadop6_6 = 0;
                        resultadop_6_6_6 = resultadop6_6;
                        cargarP();
                        //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                        break;


                }


            }
        });

        rg2_respuestas7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb2_p7:

                        resultadop7_7 =(resultadop7_7 + 13);
                        resultadop_7_7 = resultadop7_7;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb2_p7_7:
                        resultadop7_7 = 0;
                        resultadop_7_7 = resultadop7_7;

                        cargarP();
                        //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        rg2_respuestas8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb2_p8:

                        resultadop8_8 =  (resultadop8_8 + 13);
                        resultadop_8_8_8 = resultadop8_8;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb2_p8_8:
                        resultadop8_8 = 0;
                        resultadop_8_8_8 = resultadop8_8;
                        cargarP();
                        //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                        break;


                }


            }
        });



        btn_calcular2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Resultados resultados = new Resultados();
                resultados.setId(UUID.randomUUID().toString());
                resultados.setPorcentaje(todos2);
<<<<<<< HEAD
                String investigador = Menu_Principal.nombre_investigador;
                String producto = Menu_Principal.producto_investigador;


                //updateData(resultados.id,nivel,todos2, investigador,producto);

=======
                resultados.setNivel(nivel2);
                resultados.setInvestigador(Menu_Principal.nombre_investigador);
                resultados.setId_investigador(Menu_Principal.id_investigador);
                resultados.setProducto(Menu_Principal.producto_investigador);
                resultados.setAnio(Menu_Principal.anio);
                resultados.setProyecto(Menu_Principal.proyecto);
                resultados.setTipo_producto(Menu_Principal.tipo);
>>>>>>> f7a195a1a5363de41dd1b63a9a0a776b1086c738

                String id_investigador=Menu_Principal.id_investigador;
                todos2=resultados1_1+resultado2_2+resultadop3_3+resultadop4_4+resultadop5_5+resultadop6_6+resultadop7_7+resultadop8_8;
                nivel2="Trl2";
               // cargarResultados();



                if(todos2>= 100) {
                    updateData(nivel2,id_investigador,todos2);
                    Intent intent = new Intent(Trl2.this, Trl3.class);
                    startActivity(intent);
                    Toast.makeText(Trl2.this, "Muy Bien, Sigues al siguiente nivel con " + " " +  todos2 + "%" ,Toast.LENGTH_SHORT).show();

                }
                else{
                    nivel2="Trl2";
                    updateData1(id_investigador);
                    Intent intent = new Intent(Trl2.this, Error_Trl.class);
                    startActivity(intent);
                    Toast.makeText(Trl2.this, "sus resultados "+ todos2 +"%", Toast.LENGTH_SHORT).show();
                }



            }

<<<<<<< HEAD
           /* private void updateData(String id,String nivel,int todos2,String investigador, String producto) {
=======
            private void updateData(String nivel2,String id_investigador,int porcentaje) {
>>>>>>> f7a195a1a5363de41dd1b63a9a0a776b1086c738
                HashMap resulttado =new HashMap();
                resulttado.put("nivel",nivel2);
                resulttado.put("porcentaje",porcentaje);

                myref=FirebaseDatabase.getInstance().getReference("Respuestas");
                myref.child(id_investigador).updateChildren(resulttado).addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {

                        if (task.isSuccessful()){
                            Toast.makeText(Trl2.this, "Datos actualixados", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Trl2.this, "Err0r", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
<<<<<<< HEAD
            }*/
=======
            }
            private void updateData1(String id_investigador) {
                HashMap resulttado =new HashMap();
>>>>>>> f7a195a1a5363de41dd1b63a9a0a776b1086c738

                myref=FirebaseDatabase.getInstance().getReference("Respuestas");
                myref.child(id_investigador).updateChildren(resulttado).addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {

                        if (task.isSuccessful()){
                            Toast.makeText(Trl2.this, "Datos actualixados", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Trl2.this, "Err0r", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }




        });


    }


}

