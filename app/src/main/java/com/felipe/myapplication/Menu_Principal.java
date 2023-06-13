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
import com.felipe.myapplication.databinding.ActivityTrl11Binding;
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

    public static String consumo;


    TextView datosusers,id4;

    FirebaseDatabase database;
    DatabaseReference myref;

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);


        id4 = findViewById(R.id.id_4);
        datosusers = findViewById(R.id.datos_perfil);

        consumo=id4.getText().toString();


        binding = ActivityMenuPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        datosusers.setText("");

        obtener_automatico();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://nodejs-deploy-render-e0el.onrender.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();



        binding.btnConsumo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(binding.rosa.getText().toString());
                binding.rosa1.getText().toString();
                binding.id3.getText().toString();
                binding.id4.getText().toString();


                Toast.makeText(Menu_Principal.this, "soii", Toast.LENGTH_SHORT).show();
                obtenerDatos(id);


            }

            private void obtenerDatos(int id) {

                ProducctoService service = retrofit.create(ProducctoService.class);
                Call<ProductoRespuesta> productoRespuestaCall = service.obtenerListaProducto(id);
                productoRespuestaCall.enqueue(new Callback<ProductoRespuesta>() {
                    @Override
                    public void onResponse(Call<ProductoRespuesta> call, Response<ProductoRespuesta> response) {

                        if (response.isSuccessful()) {
                            ProductoRespuesta productoRespuesta = response.body();
                            List<Producto> listproducto = productoRespuesta.getProducto();
                            binding.rosa.setText(listproducto.get(0).getFuncionario_nombre());
                            binding.rosa1.setText(listproducto.get(0).getFuncionario_apellido());
                            binding.id3.setText(listproducto.get(0).getProducto_titulo());
                            binding.id4.setText(listproducto.get(0).getFuncionario_iden());

                            Log.e(TAG, "cosumo" + response.body());
                            Toast.makeText(Menu_Principal.this, "" + response.body(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Menu_Principal.this, "onResponse" + response.errorBody(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ProductoRespuesta> call, Throwable t) {
                        Log.e(TAG, "onFailure" + t.getMessage());


                    }
                });


            }

        });
    }

    private void obtener_automatico() {
        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION
        Bundle recibe_parametros = this.getIntent().getExtras();
        if (recibe_parametros != null) {
            String recibe_id = recibe_parametros.getString("identificacion_login");
//            Toast.makeText(this, "Id usuario" + recibe_id, Toast.LENGTH_SHORT).show();
            myref.child("Proyecto").orderByChild("identificacion").equalTo(recibe_id).addValueEventListener(new ValueEventListener() {


                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Datos datos = dataSnapshot.getValue(Datos.class);
                        String t = "";
                        t += datos.investigador.toString() + "\n";
                        t += datos.identificacion.toString() + "\n";
                        t += datos.productos.toString() + "\n";


                        binding.datosPerfil.setText(t);
                        Toast.makeText(Menu_Principal.this, "Investigador " + t, Toast.LENGTH_SHORT).show();

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
        binding.irACalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Principal.this, Tlr1_1.class));
            }
        });
    }



}








