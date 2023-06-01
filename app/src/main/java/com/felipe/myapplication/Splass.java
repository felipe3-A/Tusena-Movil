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
<<<<<<< HEAD

                Intent intent=new Intent(Splass.this, Login.class);

=======
                Intent intent=new Intent(Splass.this, Login.class);
>>>>>>> 9c811fb6627df005e3b7c8ebe5939ca897b8120b
>>>>>>> 9fdde4a9c5a4bcca61ad9106a2e66fd2f40b497a
                startActivity(intent);
                finish();
            }
        };
        Timer timer=new Timer();
        timer.schedule(tarea,2000);
    }
}