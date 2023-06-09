package com.felipe.myapplication;

import static android.content.ContentValues.TAG;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.felipe.myapplication.Interfaces.ProducctoService;
import com.felipe.myapplication.databinding.ActivityMenuPrincipalBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.google.firebase.database.ValueEventListener;
import com.model.Producto;
import com.model.ProductoRespuesta;

import java.util.ArrayList;
import java.util.List;



public class Menu_Principal extends AppCompatActivity {

    private Retrofit retrofit;
    ActivityMenuPrincipalBinding binding;
    TextView recibeid;

    TextView datosusers;

    FirebaseDatabase database;
    DatabaseReference myref;

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        datosusers = findViewById(R.id.datos_perfil);

        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION
        binding = ActivityMenuPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        datosusers.setText("");


        Bundle recibe_parametros = this.getIntent().getExtras();
        if (recibe_parametros != null) {
            String recibe_id = recibe_parametros.getString("identificacion_login");
//            Toast.makeText(this, "Id usuario" + recibe_id, Toast.LENGTH_SHORT).show();

            myref.child("Proyecto").orderByChild("identificacion").equalTo(recibe_id).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Datos datos = dataSnapshot.getValue(Datos.class);
                        String t="";
                        t+=datos.investigador.toString()+"\n";
                        t+=datos.identificacion.toString()+"\n";
                        t+=datos.productos.toString()+"\n";


                        binding.datosPerfil.setText(t);
                        Toast.makeText(Menu_Principal.this, "Investigador "+t, Toast.LENGTH_SHORT).show();

//                        almacenar.add(datos);
//                        adapter = new ArrayAdapter<Datos>(Menu_Principal.this, android.R.layout.simple_list_item_1, almacenar);
//                        binding.datosPerfil.setAdapter(adapter);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}










                /*if(response.isSuccessful()) {
                    Toast.makeText(Menu_Principal.this, "siii", Toast.LENGTH_SHORT).show();
                    ProductoRespuesta productoRespuesta = response.body();




                    Log.e(TAG,"CONSUMO" + response.body());
                    Toast.makeText(Menu_Principal.this, ""+response.body(), Toast.LENGTH_SHORT).show();

                }else{
                    Log.e(TAG,"onresponse" +response.errorBody());

            }*/



           /* @Override
            public void onFailure(Call<ProductoRespuesta> call, Throwable t) {
                Log.e(TAG,"onresponse" +t.getMessage());

            }
        });

    }






   /* private void referenciar() {
        to_manual = findViewById(R.id.btn_foat_to_manual);
        to_logout = findViewById(R.id.btn_float_exit);
        to_calculadora = findViewById(R.id.ir_a_calculadora);


            to_calculadora.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Menu_Principal.this, Tlr1_1.class));

                }
            });



        to_manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Principal.this, MainActivity.class));
            }
        });
        to_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Principal.this,Login.class));
                Toast.makeText(Menu_Principal.this, "Has cerrado sesion", Toast.LENGTH_SHORT).show();
            }
        });


    }*/


