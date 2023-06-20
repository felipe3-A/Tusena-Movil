package com.felipe.myapplication;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.felipe.myapplication.Interfaces.ProducctoService;
import com.felipe.myapplication.databinding.ActivityMenuPrincipalBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.model.Producto;
import com.model.ProductoRespuesta;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class Menu_Principal extends AppCompatActivity {
    private Retrofit retrofit;


    ActivityMenuPrincipalBinding binding;
    ArrayList<String> productList;
    Handler mainHandler = new Handler();
    ProgressDialog progressDialog;
    ArrayAdapter<String> listAdapter;


    TextView recibeid;
    int id = Integer.parseInt(Login.identificacion);
    public static String nombre_investigador;
    public static  String producto_investigador;

    public  static  String proyecto;
    public static String anio;
    public static String subProducto;
    public static String tipo;

    public static String id_investigador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        binding = ActivityMenuPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new obtener().start();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://nodejs-deploy-render-e0el.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Ir a
        binding.btnFloatExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Principal.this, Login.class));
            }
        });
        binding.btnFoatToManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Principal.this, MainActivity.class));
            }
        });

        obtenerDatos(id);
        iniciarlistadeproductos();

        binding.recibeProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(Menu_Principal.this,Tlr1_1.class));
               String textItemList = (productList.get(position));
               producto_investigador=textItemList;
            }
        });


    }

    private void iniciarlistadeproductos() {
        productList = new ArrayList<>();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,productList);
        binding.recibeProductos.setAdapter(listAdapter);
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

                    nombre_investigador= listproducto.get(0).getFuncionario_nombre()+" "+listproducto.get(0).getFuncionario_apellido();
                    id_investigador=listproducto.get(0).getFuncionario_iden();
                    subProducto=listproducto.get(0).getProducto_subtipo();
                    tipo=listproducto.get(0).getProducto_tipo();
                    anio=listproducto.get(0).getProducto_ano();
                    proyecto=listproducto.get(0).getProyecto_nombre();

                    String nombre_investigador=listproducto.get(0).getFuncionario_nombre()+" "+listproducto.get(0).getFuncionario_apellido();;
                    binding.NombreInvestigador.setText("Investigador : "+nombre_investigador);


                    Toast.makeText(Menu_Principal.this, "Bienvenid@" + " " + listproducto.get(0).getFuncionario_nombre() + " " + "" + listproducto.get(0).getFuncionario_apellido(), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Menu_Principal.this, "Este usuario no existe o se ha borrado de la base de datos" + response.errorBody(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductoRespuesta> call, Throwable t) {
                Log.e(TAG, "onFailure" + t.getMessage());
            }
        });
    }

    class obtener extends Thread {
        String data = "";

        @Override
        public void run() {

            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    progressDialog = new ProgressDialog(Menu_Principal.this);
                    progressDialog.setMessage("Buscando datos...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                }
            });

            try {
                URL url = new URL("https://nodejs-deploy-render-e0el.onrender.com/productos/"+Login.identificacion);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    data = data + line;
                }

                if (!data.isEmpty()) {

                    JSONObject jsonObject = new JSONObject(data);
                    JSONArray products = jsonObject.getJSONArray("producto");
                    productList.clear();

                    for (int i = 0; i < products.length(); i++) {
                        JSONObject datos = products.getJSONObject(i);
                        String dato = datos.getString("producto_titulo");
                        productList.add(dato);
                    }
                }


                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                           listAdapter.notifyDataSetChanged();
                        {

                        }
                    }
                });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        }


    }


}







  /*  private void obtener_automatico() {
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

                        Toast.makeText(Menu_Principal.this, "Bienvenid@ " + datos.investigador, Toast.LENGTH_SHORT).show();

                        nombre_investigador=datos.investigador;
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
    }*/


//    private void obtener_automatico() {
//        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
//        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION
//
//
//        Bundle recibe_parametros = this.getIntent().getExtras();
//        if (recibe_parametros != null) {
//            String recibe_id = recibe_parametros.getString("identificacion_login");
////            Toast.makeText(this, "Id usuario" + recibe_id, Toast.LENGTH_SHORT).show();
//
//            myref.child("Proyecto").orderByChild("identificacion").equalTo(recibe_id).addValueEventListener(new ValueEventListener() {
//
//                @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                        Datos datos = dataSnapshot.getValue(Datos.class);
//                        String t = "";
//                        t += datos.investigador.toString() + "\n";
//                        t += datos.identificacion.toString() + "\n";
//                        t += datos.productos.toString() + "\n";
//
//                        binding.datosPerfil.setText(t);
//
//                        Toast.makeText(Menu_Principal.this, "Bienvenid@ " + datos.investigador, Toast.LENGTH_SHORT).show();
//
//                        nombre_investigador = datos.investigador;
//                    }
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });
//        }
//        binding.irACalculadora.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Menu_Principal.this, Tlr1_1.class));
//            }
//        });
//    }













