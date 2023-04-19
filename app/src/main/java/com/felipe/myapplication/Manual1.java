package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Manual1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual1);
    }
    public void Manual2(View view){
        Intent primer_guia= new Intent(this,Manual2.class);
        startActivity(primer_guia);
    }
}