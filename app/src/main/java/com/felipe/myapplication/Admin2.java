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

    public static String investigador;
    public static String producto;
    public static String proyecto;

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
        investigador= edtx_investigador.getText().toString();
        producto=edtx_no_producto.getText().toString();
        proyecto=edtx_nombre_proyecto.getText().toString();
       // investigador="zule";
        //producto="arepas";




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
                final String txtinvestigador = edtx_investigador.getText().toString();
                final String txtidentificacion_i = edtx_identificacion.getText().toString();
                final String txt_nombre_proyecto = edtx_nombre_proyecto.getText().toString();
                final String txtno_producto = edtx_no_producto.getText().toString();
                final String txt_tipo_producto = edtx_tipo_proyecto.getText().toString();
                final String txt_numero_proyecto = edtx_numeroproyecto.getText().toString();

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
                datos_investigadores.investigador = edtx_investigador.getText().toString();

                if (txt_nombre_proyecto.isEmpty() || txt_numero_proyecto.isEmpty() || txtidentificacion_i.isEmpty() || txtinvestigador.isEmpty() || txtno_producto.isEmpty() ||txt_tipo_producto.isEmpty() ) {
                    Toast.makeText(Admin2.this, "Por favor llenar todos los campos", Toast.LENGTH_SHORT).show();
                } else {

                    myRef.child("Proyecto").child(datos_investigadores.getId()).setValue(datos_investigadores);
                    Toast.makeText(Admin2.this, "Datos insertados", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Admin2.this,Admin_Menu.class));
                }

            }
        });

    }




}