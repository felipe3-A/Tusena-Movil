package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
List<Version> versionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recicleview);
        initData();
        setRecycleView();
    }

    private void setRecycleView() {
        VersionAdapter versionAdapter=new VersionAdapter(versionList);
        recyclerView.setAdapter(versionAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {
        versionList=new ArrayList<>();

        versionList.add(new Version("Trl1","Version Trl1","Api Level 29","Descripcion"));

        versionList.add(new Version("Trl2","Version Trl2","Api Level 20","Descripcion"));
        versionList.add(new Version("Trl3","Version Trl3","Api Level 26","Descripcion"));
        versionList.add(new Version("Trl4","Version Trl4","Api Level 23","Descripcion"));
        versionList.add(new Version("Trl5","Version Trl4","Api Level 23","Descripcion"));
        versionList.add(new Version("Trl6","Version Trl4","Api Level 23","Descripcion"));
        versionList.add(new Version("Trl7","Version Trl4","Api Level 23","Descripcion"));
        versionList.add(new Version("Trl8","Version Trl4","Api Level 23","Descripcion"));
        versionList.add(new Version("Trl9","Version Trl4","Api Level 23","Descripcion"));
    }
    public void cargarpregungta(){



    }
}