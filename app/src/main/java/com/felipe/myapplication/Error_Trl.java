package com.felipe.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Error_Trl extends AppCompatActivity {
TextView respuestas,respuestas_trl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_trl);
        referenciar();
    }

    private void referenciar() {
        respuestas=findViewById(R.id.resultado);
        respuestas_trl=findViewById(R.id.resultado_trl);

        respuestas.setText("Su porcentaje es  : "+Tlr1_1.todos + "%");
        respuestas_trl.setText("Su Trl es : "+Tlr1_1.nivel);

    }
}