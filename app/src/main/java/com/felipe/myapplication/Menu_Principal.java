package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Menu_Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.perfil) {
//            Intent i=new Intent(this, Perfil.class);
//            startActivity(i);
//        } else if (id == R.id.Calculadora) {
//            Toast.makeText(this, "metodo2", Toast.LENGTH_SHORT).show();
//        } else if (id == R.id.Buscador) {
//            Toast.makeText(this, "metodo3", Toast.LENGTH_SHORT).show();
//
//        }
//        return super.onOptionsItemSelected(item);
//
//    }


}