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

    Button agregar_preguntas,exit_admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        agregar_preguntas=findViewById(R.id.agregar_preguntas);
        exit_admin=findViewById(R.id.exit_admin);

        agregar_preguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        startActivity(new Intent(Admin_Menu.this,Buscador_Botones_admin.class));
            }
        });
        exit_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_Menu.this, Login.class));
            }
        });
    }


}