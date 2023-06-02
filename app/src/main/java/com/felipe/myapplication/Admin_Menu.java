package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Admin_Menu extends AppCompatActivity {

    Button ir_a_agregar_preguntas;
    Button ir_a_agregar_investigadores,exit_admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        refernciar();
    }

    private void refernciar() {
        ir_a_agregar_preguntas=findViewById(R.id.go_agragar_preguntas);
        ir_a_agregar_investigadores=findViewById(R.id.ira_agregar_inv);
        exit_admin=findViewById(R.id.exit_admin);

        exit_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_Menu.this, Login.class));
                Toast.makeText(Admin_Menu.this, "Admin,has cerrado secion", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
       ir_a_agregar_preguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_Menu.this, Admin.class));
            }
        });
       ir_a_agregar_investigadores.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(Admin_Menu.this, Admin2.class));
           }
       });
    }

}