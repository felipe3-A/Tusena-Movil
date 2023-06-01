package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class Splass extends AppCompatActivity {
VideoView view;
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splass);

        view=findViewById(R.id.video);
        //Direciones
        view.setVideoPath("android.resource://" + getPackageName() + "/"+R.raw.logotusena);
        view.start();

        TimerTask tarea=new TimerTask() {
            @Override
            public void run() {
<<<<<<< HEAD
                Intent intent=new Intent(Splass.this, Menu_Principal.class);
=======

                Intent intent=new Intent(Splass.this, Login.class);




>>>>>>> 0e6b41b7a8a8eea12a7126c163766a3226cb98b5
                startActivity(intent);
                finish();
            }
        };
        Timer timer=new Timer();
        timer.schedule(tarea,2000);
    }
}