package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Admin extends AppCompatActivity {
    EditText edtx_pregtunta,edtx_nivel_relativo;
    Spinner sp_trl;
    Button btn_agregar;

    FirebaseDatabase database;
    DatabaseReference myRef;

    //DatabaseReference database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tusena-c86eb-default-rtdb.firebaseio.com/");

    List<Preguntas> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        referenciar();
    }

    private void referenciar() {
        edtx_pregtunta = findViewById(R.id.edtx_pregtunta);
        edtx_nivel_relativo = findViewById(R.id.edtx_nivel_relativo);
        btn_agregar = findViewById(R.id.btn_agregarp);
        sp_trl = findViewById(R.id.sp_trl);


        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar();

            }
            private void insertar() {
                database = FirebaseDatabase.getInstance(); //conexion
                myRef = database.getReference(); // referencia


                Preguntas preguntas_trl = new Preguntas();
                preguntas_trl.setId(UUID.randomUUID().toString());

                preguntas_trl.setPregunta(edtx_pregtunta.getText().toString());
                preguntas_trl.setNivelRelativo(edtx_nivel_relativo.getText().toString());
                preguntas_trl.setNivel((sp_trl.getSelectedItem().toString()));

                myRef.child("preguntas").child(preguntas_trl.getId()).setValue(preguntas_trl); //insercion
                Toast.makeText(Admin.this, "Pregunta Agregada", Toast.LENGTH_SHORT).show();

            }
        });

    }
}






            //radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        //  @Override
        //  public void onCheckedChanged(RadioGroup group, int checkedId) {

               /* final String respuesta1Txt = radioButton3.getText().toString();
                final String respuesta2Txt = radioButton4.getText().toString();

                database.child("Respuestas").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        database.child("Respuestas").child(respuesta1Txt).child("Respuesta 1").setValue(respuesta1Txt);
                        database.child("Respuestas").child(respuesta2Txt).child("Respuesta 2").setValue(respuesta2Txt);
                        Toast.makeText(Admin.this,"",Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });*/


        //  }
        // });

       /*btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String respuesta1Txt = radioButton3.getText().toString();
                final String respuesta2Txt = radioButton4.getText().toString();
                final String preguntaTxt = edtx_pregtunta.getText().toString();
                if (preguntaTxt.isEmpty() || respuesta1Txt.isEmpty() || respuesta2Txt.isEmpty()) {
                    Toast.makeText(Admin.this, "Agregar pregunta", Toast.LENGTH_SHORT).show();
                } else {
                    database.child("Preguntas").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            database.child("Preguntas").child(preguntaTxt).child("Pregunta").setValue(preguntaTxt);
                            database.child("Respuestas").child(respuesta1Txt).child("Respuesta 1").setValue(respuesta1Txt);
                            database.child("Respuestas").child(respuesta2Txt).child("Respuesta 2").setValue(respuesta2Txt);
                            Toast.makeText(Admin.this, "Pregunta agregada", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }


            }

        });*/











