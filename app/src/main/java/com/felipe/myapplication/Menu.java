package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.felipe.myapplication.Framents.FragmentCalculadora;
import com.felipe.myapplication.Framents.FragmentInvestigadores;
import com.felipe.myapplication.Framents.FragmentPerfil;
import com.felipe.myapplication.Framents.Mainfragment;
import com.google.android.material.navigation.NavigationView;

public class Menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
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

        //Estableser el evento para el navigation view
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
       actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
       actionBarDrawerToggle.syncState();

   //Cargar fragmentos
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,new Mainfragment());
        fragmentTransaction.commit();

//Cargar vistas desdee fragmentos

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId()==R.id.home){
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,new Mainfragment());
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.Perfil){
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,new FragmentPerfil());
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.Calculadora){
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,new FragmentCalculadora());
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.Investigadores){
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,new FragmentInvestigadores());
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.Manual){
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,new Manual_Usuario());
            fragmentTransaction.commit();
        }



        return false;

    }
}