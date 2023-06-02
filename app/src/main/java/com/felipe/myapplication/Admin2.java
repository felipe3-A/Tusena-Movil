package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Admin2 extends AppCompatActivity {

    EditText edtx_nombre_proyecto,edtx_investigador,edtx_identificacion,edtx_no_producto,edtx_tipo_proyecto,edtx_numeroproyecto;

    Button btn_agregarinvestigador,btn_return_home;
    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);
        referenciar();
    }

    private void referenciar() {

        edtx_nombre_proyecto=findViewById(R.id.edtx_nombre_proyecto);
        edtx_numeroproyecto=findViewById(R.id.edtx_numeroproyecto);
        edtx_tipo_proyecto=findViewById(R.id.edtx_tipo_proyecto);
        edtx_investigador=findViewById(R.id.edtx_investigador);
        edtx_identificacion=findViewById(R.id.edtx_identificacion);
        edtx_no_producto=findViewById(R.id.edtx_n_producto);
        btn_agregarinvestigador=findViewById(R.id.btn_agregarinvestigador);
        btn_return_home=findViewById(R.id.float_home_return);

        btn_return_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin2.this,Admin_Menu.class));
            }
        });

        btn_agregarinvestigador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               agregar();

            }


            private void agregar() {

                database = FirebaseDatabase.getInstance(); //conexion
                myRef = database.getReference(); // referencia


                Datos datos_investigadores = new Datos();

                datos_investigadores.setId(UUID.randomUUID().toString());
                datos_investigadores.setInvestigador(edtx_investigador.getText().toString());
                datos_investigadores.setIdentificacion(edtx_identificacion.getText().toString());
                datos_investigadores.setProyecto(edtx_nombre_proyecto.getText().toString());
                datos_investigadores.setProductos(edtx_no_producto.getText().toString());
                datos_investigadores.setTipocodigoproducto(edtx_tipo_proyecto.getText().toString());
                datos_investigadores.setNumerodelproyecto(edtx_numeroproyecto.getText().toString());


                myRef.child("Proyecto").child(datos_investigadores.getProyecto()).child(datos_investigadores.getInvestigador()).child(datos_investigadores.getIdentificacion()).child(datos_investigadores.getProductos()).setValue(datos_investigadores.getProductos()); //insercion



                Toast.makeText(Admin2.this, "Datos insertados", Toast.LENGTH_SHORT).show();

            }
        });

    }




}