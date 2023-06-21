package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Admin_Menu extends AppCompatActivity {

    Button ir_a_agregar_preguntas,ira_agregar_inv;

    Button ir_a_agregar_investigadores,exit_admin,editar_preguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        refernciar();

    }

    private void refernciar() {
        ir_a_agregar_preguntas=findViewById(R.id.go_agragar_preguntas);
        ira_agregar_inv=findViewById(R.id.ira_agregar_inv);

        ir_a_agregar_preguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin_Menu.this,Admin2.class));
            }
        });
        ira_agregar_inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_Menu.this,Admin2.class));
            }
        });



    }

}