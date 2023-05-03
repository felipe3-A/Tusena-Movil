package com.felipe.myapplication;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.felipe.myapplication.Framents.Mainfragment;
import com.google.android.material.navigation.NavigationView;

public class Menu extends AppCompatActivity {
DrawerLayout drawerLayout;
ActionBarDrawerToggle actionBarDrawerToggle;
Toolbar toolbar;
NavigationView navigationView;

    //Variables para cargar el fragment principal
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigationview);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
   actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
   actionBarDrawerToggle.syncState();

   //Cargar fragmentos
fragmentManager=getSupportFragmentManager();
fragmentTransaction=fragmentManager.beginTransaction();
fragmentTransaction.add(R.id.container,new Mainfragment());
fragmentTransaction.commit();



    }




}