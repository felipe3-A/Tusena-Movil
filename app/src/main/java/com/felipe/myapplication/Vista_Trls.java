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

    public void home(View view){
        Intent intent=new Intent(this, Admin_Menu.class);
        startActivity(intent);
    }
}