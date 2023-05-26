package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Trl2 extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myref;
    public static String nivel;
    TextView txt_trl2p1, txt_trl2p2, txt_trl2p3, txt_trl2p4, txt_trl2p5, txt_trl2p6, txt_trl2p7,txt_trl2p8;
    RadioGroup rg2_respuestas,rg2_respuestas2,rg2_respuestas3,rg2_respuestas4,rg2_respuestas5,rg2_respuestas6,rg2_respuestas7,rg2_respuestas8;
    RadioButton rb2_p1, rb2_p_1,rb2_p2, b2_p2_2,rb2_p3, rb2_p3_3,rb2_p4, rb2_p4_4,rb2_p5, rb2_p5_5,rb2_p6, rb2_p6_6,rb2_p7, rb2_p7_7,rb2_p8,rb2_p8_8;

    Button btn_calcular2;

    public static int
            resultados,
            resultados1,
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
    todos2;


    public static List<Preguntas> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl2);

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

                        resultados= (int) (resultados+13);
                        resultados1=resultados;
                        cargarP();
                        //Toast.makeText(Trl2.this, "Su porcentaje es: " + resultados, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rd_p_1:
                        resultados= 0;
                        resultados1=resultados;
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

                        resultadop2 = (int) (resultadop2 + 13);
                        resultadop2_2 = resultadop2;
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

        rg2_respuestas3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId) {
                    case R.id.rb2_p3:

                        resultadop2 = (int) (resultadop2 + 13);
                        resultadop2_2 = resultadop2;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb2_p3_3:
                        resultadop2 = 0;
                        resultadop2_2 = resultadop2;
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

                        resultadop2 = (int) (resultadop2 + 13);
                        resultadop2_2 = resultadop2;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb2_p4_4:
                        resultadop2 = 0;
                        resultadop2_2 = resultadop2;
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

                        resultadop2 = (int) (resultadop2 + 13);
                        resultadop2_2 = resultadop2;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb2_p5_5:
                        resultadop2 = 0;
                        resultadop2_2 = resultadop2;
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

                        resultadop2 = (int) (resultadop2 + 13);
                        resultadop2_2 = resultadop2;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb2_p6_6:
                        resultadop2 = 0;
                        resultadop2_2 = resultadop2;
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

                        resultadop2 = (int) (resultadop2 + 13);
                        resultadop2_2 = resultadop2;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb2_p7_7:
                        resultadop2 = 0;
                        resultadop2_2 = resultadop2;
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

                        resultadop2 = (int) (resultadop2 + 13);
                        resultadop2_2 = resultadop2;
                        cargarP();
                        //   Toast.makeText(Trl3.this, "Su porcentaje es: " + resultado, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb2_p8_8:
                        resultadop2 = 0;
                        resultadop2_2 = resultadop2;
                        cargarP();
                        //  Toast.makeText(Trl3.this, "ghjj" + resultado, Toast.LENGTH_SHORT).show();
                        break;


                }


            }
        });


        btn_calcular2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todos2=resultados+resultadop2+resultadop3+resultadop4+resultadop5+resultadop6+resultadop_7;

                if(todos2>= 100) {
                    //nivel = "Tlr2";

                    Intent intent = new Intent(Trl2.this, Trl3.class);
                    startActivity(intent);
                    Toast.makeText(Trl2.this, "Muy Bien, Sigues al siguiente nivel", Toast.LENGTH_SHORT).show();

                }
                else{
                    nivel = "Tlr2";
                    Intent intent = new Intent(Trl2.this, Error_Trl.class);
                    startActivity(intent);
                    Toast.makeText(Trl2.this, "sus resultados "+ todos2 +"%", Toast.LENGTH_SHORT).show();
                }




            }
        });


    }


}











