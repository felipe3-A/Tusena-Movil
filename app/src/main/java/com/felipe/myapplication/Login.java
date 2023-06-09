package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.felipe.myapplication.Interfaces.ProducctoService;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.model.Producto;
import com.model.ProductoRespuesta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    public static String identificacion;
    DatabaseReference database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tusena-c86eb-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final TextInputLayout usuario = (TextInputLayout) findViewById(R.id.usuario);
        final TextInputLayout password = (TextInputLayout) findViewById(R.id.password_login);
        final Button loginbtn = findViewById(R.id.login_btn);
        final TextView registrarseahora = findViewById(R.id.registrarse_ahora);






        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String textTxt = usuario.getEditText().getText().toString();
                final String passwordTxt = password.getEditText().getText().toString();



                if (textTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(Login.this, "Por favor ingrese con su usuario o contraseña", Toast.LENGTH_SHORT).show();

                } else {
                    database.child("users").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(textTxt)) {
                                // usuario si existe en la bd

                                //ahora obtenga la contraseña del usuario de la bd y conéctela con la contraseña ingresada por el usuario
                                final String getPassword = snapshot.child(textTxt).child("contraseña").getValue(String.class);



                                if (getPassword.equals(passwordTxt)) {
                                   // Toast.makeText(Login.this, "inicio sesión con éxito", Toast.LENGTH_SHORT).show();
                                   Intent intent=new Intent(Login.this, Menu_Principal.class);
                                   startActivity(intent);



                                    //validacion de roles

                                    final String getUser = snapshot.child(textTxt).child("usuario").getValue(String.class);
                                    final String getAdmin = snapshot.child(textTxt).child("usuario").getValue(String.class);
                                    identificacion=textTxt;

                                    Intent intent4 = new Intent(Login.this, Menu_Principal.class);
                                    intent4.putExtra("userId", Producto.class);
                                    startActivity(intent4);



                                    if (getUser.equals("user")) {
                                        Toast.makeText(Login.this, "Has iniciado como Usuario", Toast.LENGTH_SHORT).show();
                                        Intent intento = new Intent(Login.this, Menu_Principal.class);
                                        intento.putExtra("identificacion_login",identificacion);
                                        startActivity(intento);
                                        finish();
                                    }


                                    if (getAdmin.equals("admin")) {
                                        Toast.makeText(Login.this, "Has iniciado como Admin", Toast.LENGTH_SHORT).show();
                                        Intent intent2 = new Intent(Login.this, Admin_Menu.class);
                                        intent2.putExtra("identificacion_login",identificacion);
                                        startActivity(intent2);
                                        finish();
                                    }
                                } else {
                                    Toast.makeText(Login.this, "contraseña incorrecta", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(Login.this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

        registrarseahora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });


    }

}



