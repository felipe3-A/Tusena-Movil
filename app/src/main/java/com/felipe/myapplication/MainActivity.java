package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void guia1(View view){
        Intent primer_guia= new Intent(this,Guia1.class);
        startActivity(primer_guia);
    }
    public void Registro(View view){
        Intent primer_guia= new Intent(this,Register.class);
        startActivity(primer_guia);
    }
}