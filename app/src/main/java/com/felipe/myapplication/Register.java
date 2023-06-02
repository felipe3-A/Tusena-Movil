package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    TextInputLayout txt_name, txt_apellido, txt_email, txt_number, txt_password, txt_cpassword;
    Button btn_register;
    TextView inicia_ahora;

    DatabaseReference database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tusena-c86eb-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txt_name =(TextInputLayout) findViewById(R.id.txt_name);
        txt_apellido = (TextInputLayout)findViewById(R.id.txt_apellido);
        txt_email = (TextInputLayout)findViewById(R.id.txt_email);
        txt_number = (TextInputLayout)findViewById(R.id.txt_number);
        txt_password = (TextInputLayout)findViewById(R.id.txt_password);
        txt_cpassword = (TextInputLayout)findViewById(R.id.txt_cpassword);
        inicia_ahora = findViewById(R.id.inicio_ya);

        btn_register = findViewById(R.id.btn_registar);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //obtener datos de cajas de texto en cadenas de variables

                final String nameTxt = txt_name.getEditText().getText().toString();
                final String apellidoTxt = txt_apellido.getEditText().getText().toString();
                final String emailTxt = txt_email.getEditText().getText().toString();
                final String numberTxt = txt_number.getEditText().getText().toString();
                final String passwordTxt = txt_password.getEditText().getText().toString();
                final String cpasswordTxt = txt_cpassword.getEditText().getText().toString();

                //comprobar si el usuario rellena todos los campos antes de enviar datos a la BD
                if (nameTxt.isEmpty() || apellidoTxt.isEmpty() || emailTxt.isEmpty() || numberTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(Register.this, "Por favor llenar todos los campos", Toast.LENGTH_SHORT).show();

                }
                //comprobar si las contraseñas coinciden entre sí
                else if (!passwordTxt.equals(cpasswordTxt)) {
                    Toast.makeText(Register.this, "Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                } else {

                    database.child("users").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //compruebe si identificacion no está registrado antes


                            if (snapshot.hasChild(numberTxt)) {
                                Toast.makeText(Register.this, "Identificacion ya esta registrada", Toast.LENGTH_SHORT).show();
                            } else {
                                //enviado datos a la bd
                                //estamos usando el usuario como identidad única de cada persona
                                //por lo que todos los demás detalles del usuario se incluyen en el nombre de usuario
                                database.child("users").child(numberTxt).child("Nombre").setValue(nameTxt);
                                database.child("users").child(numberTxt).child("Apellido").setValue(apellidoTxt);
                                database.child("users").child(numberTxt).child("Email").setValue(emailTxt);
                                database.child("users").child(numberTxt).child("Identificacion").setValue(numberTxt);
                                database.child("users").child(numberTxt).child("contraseña").setValue(passwordTxt);
                                database.child("users").child(numberTxt).child("usuario").setValue("");


                                Toast.makeText(Register.this, "Registro satisfactorio", Toast.LENGTH_SHORT).show();
                                finish();


                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        inicia_ahora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Login.class));
                finish();
            }
        });
    }
}
