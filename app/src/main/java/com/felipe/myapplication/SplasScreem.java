package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplasScreem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

<<<<<<< HEAD
        Intent intent=new Intent(this,MainActivity.class);
=======
        Intent intent=new Intent(this,Admin.class);
>>>>>>> 3ea429799f1ee6dd45e80406dc23055ccf7b6d31
        startActivity(intent);

    }
}
