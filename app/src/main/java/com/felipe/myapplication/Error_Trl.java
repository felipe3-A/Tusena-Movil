package com.felipe.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Error_Trl extends AppCompatActivity {

  Button button;
  Button button_volver;
  TextView reporte1;
  TextView reporte2;
  TextView reporte3;
  TextView reporte4;
  TextView reporte5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_trl);
        button=findViewById(R.id.button);
        reporte1=findViewById(R.id.reporte_nombre);
        reporte2=findViewById(R.id.reporte_proyecto);
        reporte3=findViewById(R.id.reporte_nivel);
        reporte4=findViewById(R.id.reporte_porcentaje);
        reporte5=findViewById(R.id.reporte_producto);
        button_volver=findViewById(R.id.boton_volver);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog();
            }
        });


        button_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Error_Trl.this,Menu_Principal.class));
            }
        });
        reporte1.setText(Resultados.investigador);
      //  reporte2.setText(Resultados.proyecto);
        reporte3.setText("Nivel del producto: "+Resultados.nivel);
        reporte4.setText("Nombre de Producto : "+Resultados.producto);
        reporte5.setText("Porcentaje alcanzado : " + Resultados.porcentaje);





    }
    public void AlertDialog(){
        androidx.appcompat.app.AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Analisis completado");
        builder.setMessage("Tu producto ha sido evaluado correctamente");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Error_Trl.this, "Ya puedes volver ver tu producto en el buscador", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

}

