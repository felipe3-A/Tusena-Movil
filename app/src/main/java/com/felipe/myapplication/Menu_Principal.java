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
import com.google.firebase.database.ValueEventListener;
import com.model.Producto;
import com.model.ProductoRespuesta;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Menu_Principal extends AppCompatActivity {

  private Retrofit retrofit;

  ActivityMenuPrincipalBinding binding;
    Button to_manual, to_calculadora, to_logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menu_principal);
        //referenciar();
        binding = ActivityMenuPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.rosa.getText().toString();
        binding.id1.getText();
        binding.btnConsumo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.id1.setText("");
                obtenerDatos(binding.rosa.getText().toString());
                Toast.makeText(Menu_Principal.this, "soii" , Toast.LENGTH_SHORT).show();

            }
        });
        //binding.edtBody.getText().toString();




    }


    private void obtenerDatos(String id){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://nodejs-deploy-render-e0el.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProducctoService service = retrofit.create(ProducctoService.class);
        Call<List<Producto>> productoCall = service.obtenerListaProducto(id);
        productoCall.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                List<Producto> productos=response.body();
                for(Producto p:productos){
                    String datos="";
                    datos+="producto_titulo"+p.getProducto_titulo()+"\n";
                    binding.rosa.append(datos);
                }
                Toast.makeText(Menu_Principal.this, "ffff", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });






                /*if(response.isSuccessful()) {
                    Toast.makeText(Menu_Principal.this, "siii", Toast.LENGTH_SHORT).show();
                    ProductoRespuesta productoRespuesta = response.body();




                    Log.e(TAG,"CONSUMO" + response.body());
                    Toast.makeText(Menu_Principal.this, ""+response.body(), Toast.LENGTH_SHORT).show();

                }else{
                    Log.e(TAG,"onresponse" +response.errorBody());
                }
            }*/
            }

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


}