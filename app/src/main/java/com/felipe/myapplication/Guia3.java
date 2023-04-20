package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.VideoView;

public class Guia3 extends AppCompatActivity {

VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guia3);

video = findViewById(R.id.video);
MediaPlayer v ;

        video.setVideoPath("android.resource://" + getPackageName() + "/"+R.raw.prueba);
        video.start();

    }
    public void Manual1(View view){
        Intent primer_guia= new Intent(this,Manual1.class);
        startActivity(primer_guia);

    }



}