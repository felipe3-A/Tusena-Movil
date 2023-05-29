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
                Intent intent=new Intent(Splass.this, Trl5.class);
>>>>>>> 01a889706d89cbf12c76279e6f0bb424f031f211
                startActivity(intent);
                finish();
            }
        };
        Timer timer=new Timer();
        timer.schedule(tarea,2000);
    }
}