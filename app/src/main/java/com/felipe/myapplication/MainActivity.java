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

        versionList.add(new Version("¿Que es Trl1?","","","El termino de Trl (Technological Readiness Level),o Niveles de preparación tecnológica, es una tecnologia que se encarga de medir o calcular en que estado de calidad esta un proyecto o un producto"));
        versionList.add(new Version("¿Que significa Trl1,Trl2..?","","","Estos conceptos son niveles que se usan para saber cual es la calidad de un producto,en total existen 9 niveles, entre mayor el numero es mejor la calidad del producto"));
        versionList.add(new Version("¿Como funciona la calculadora de TuSena?","","","El metodo de calificacion de nuestra calculadora es si tu prododucto cumple con TODOS los lineamientos, inmediatamente este producto sube de nivel, en caso de que este producto no cumpla con algunos de los requisitos, el producto quedaria en el nivel que establesido"));

    }
    public void cargarpregungta(){

    }
}