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

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Admin extends AppCompatActivity {
    TextInputLayout edtx_pregtunta,edtx_nivel_relativo;
    Spinner sp_trl;
    Button btn_agregar,float_home_return_2;

    public static String nivel;

    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        referenciar();
    }

    private void referenciar() {
        edtx_pregtunta = (TextInputLayout) findViewById(R.id.edtx_pregtunta);
        edtx_nivel_relativo =(TextInputLayout) findViewById(R.id.edtx_nivel_relativo);
        btn_agregar = findViewById(R.id.btn_agregarp);
        sp_trl = findViewById(R.id.sp_trl);
        nivel=sp_trl.getSelectedItem().toString();


        float_home_return_2=findViewById(R.id.float_home_return_2);
        float_home_return_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin.this,Admin_Menu.class));
            }
        });


        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               insertar();



            }
            private void insertar() {


                final String txtpregunta = edtx_pregtunta.getEditText().getText().toString();
                final String txtnivelr = edtx_nivel_relativo.getEditText().getText().toString();


                database = FirebaseDatabase.getInstance(); //conexion
                myRef = database.getReference(); // referencia

                Preguntas preguntas_trl = new Preguntas();
                preguntas_trl.setId(UUID.randomUUID().toString());
                preguntas_trl.setPregunta(edtx_pregtunta.getEditText().getText().toString());
                preguntas_trl.setNivelRelativo(edtx_nivel_relativo.getEditText().getText().toString());
                preguntas_trl.setNivel((sp_trl.getSelectedItem().toString()));
                nivel = sp_trl.getSelectedItem().toString();

                if (txtpregunta.isEmpty() || txtnivelr.isEmpty()) {
                    Toast.makeText(Admin.this, "Por favor llenar todos los campos", Toast.LENGTH_SHORT).show();
                } else {

                    myRef.child("Preguntas").child(preguntas_trl.getId()).setValue(preguntas_trl);
                    Toast.makeText(Admin.this, "Pregunta Agregada", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Admin.this, Admin_Menu.class));
                }
            }
        });

    }
}














