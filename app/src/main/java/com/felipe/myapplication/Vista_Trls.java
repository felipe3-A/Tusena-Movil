package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Vista_Trls extends AppCompatActivity {
Button trl1_b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_trls);
        referenciar();
    }

    private void referenciar() {
        trl1_b=findViewById(R.id.ir_a_trl1);
        trl1_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vista_Trls.this, Tlr1_1.class));
            }
        });
    }

    public void i(View view){
        Intent intent=new Intent(this, Vista_Trls.class);
        startActivity(intent);
    }
    public void logout(View view){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
        Toast.makeText(this, "Has cerrado sesion con exito", Toast.LENGTH_SHORT).show();
    }
    public void home(View view){
        Intent intent=new Intent(this, Menu_Principal.class);
        startActivity(intent);
    }
}