package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Menu_Principal extends AppCompatActivity {
Button to_manual,to_calculadora;

    public static String investigador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        referenciar();
    }

    private void referenciar() {
        to_manual=findViewById(R.id.btn_foat_to_manual);
        to_calculadora=findViewById(R.id.btn_foat_to_calculadora);

        to_manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Principal.this, Manual_trls.class));
            }
        });
        to_calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Principal.this,Vista_Trls.class));
            }
        });
        investigador= "";

    }


}