package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Trl1 extends AppCompatActivity {

    TextView txt_trl1,txt_trl2,txt_trl3,txt_trl4,txt_trl5,txt_trl6,txt_trl7;
    RadioGroup trl1_r,trl1_p2,trl1_p3,trl1_p4,trl1_p5,trl1_p6,trl1_p7;
    RadioButton r1,r2,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15;
    FirebaseDatabase database;
    DatabaseReference myRef;

    List<Preguntas> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl1);
        
       referenciar();
    }

    private void referenciar() {
        txt_trl1=findViewById(R.id.txt_trl1);
        txt_trl2=findViewById(R.id.txt_trl2);
        txt_trl1=findViewById(R.id.txt_trl3);
        txt_trl1=findViewById(R.id.txt_trl4);
        txt_trl1=findViewById(R.id.txt_trl5);
        txt_trl1=findViewById(R.id.txt_trl6);
        txt_trl1=findViewById(R.id.txt_trl7);
    }


}