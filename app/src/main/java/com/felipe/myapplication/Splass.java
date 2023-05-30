package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class Splass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splass);
        TimerTask tarea=new TimerTask() {
            @Override
            public void run() {
<<<<<<< HEAD

                Intent intent=new Intent(Splass.this, Login.class);

=======
                Intent intent=new Intent(Splass.this, Login.class);
>>>>>>> 9c811fb6627df005e3b7c8ebe5939ca897b8120b
                startActivity(intent);
                finish();
            }
        };
        Timer timer=new Timer();
        timer.schedule(tarea,1000);
    }
}