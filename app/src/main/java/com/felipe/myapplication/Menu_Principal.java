package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Menu_Principal extends AppCompatActivity {
Button to_manual,to_calculadora,to_logout;

    public static String investigador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        referenciar();
    }

    private void referenciar() {
        to_manual=findViewById(R.id.btn_foat_to_manual);
        to_logout=findViewById(R.id.btn_float_exit);
        to_calculadora=findViewById(R.id.ir_a_calculadora);

        to_calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Principal.this,Tlr1_1.class));
            }
        });

        to_manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Principal.this, MainActivity.class));
            }
        });
        to_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Principal.this,Login.class));
                Toast.makeText(Menu_Principal.this, "Has cerrado sesion", Toast.LENGTH_SHORT).show();
            }
        });
        investigador= "";

    }


}