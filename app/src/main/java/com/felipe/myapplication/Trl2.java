package com.felipe.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Trl2 extends AppCompatActivity {
    //private List<Preguntas> listpregunta=new ArrayList<Preguntas>();
    FirebaseDatabase firebasedatabase;
    DatabaseReference databaseReference;
    TextView txt_trl2,txt_trl2p,txt_trl80;

   // ListView list;

    public static  List<Preguntas> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trl2);
        txt_trl2=findViewById(R.id.txt_trl2);
        txt_trl2p=findViewById(R.id.txt_trl1p);
        txt_trl80=findViewById(R.id.txt_trl80);
       //list = findViewById(R.id.txt_trl1);
       cargarpregunta();
    }

    private void cargarpregunta() {
        Toast.makeText(this, "hols" +list, Toast.LENGTH_SHORT).show();

        iniciarFireBase();

       databaseReference.child("Preguntas").orderByChild("nivel").equalTo("Tlr1").addChildEventListener(new ChildEventListener() {
                   @Override
                   public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                       for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                           Preguntas pregunta = dataSnapshot.getValue(Preguntas.class);
                           Toast.makeText(Trl2.this, "valor"+previousChildName, Toast.LENGTH_SHORT).show();
                           list.add(pregunta);

                       }

                       txt_trl2.setText( list.get(0).getPregunta());
                       txt_trl2p.setText( list.get(1).getPregunta());
                       txt_trl80.setText(list.get(2).getPregunta());
                   }

                   @Override
                   public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                   }

                   @Override
                   public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                   }

                   @Override
                   public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError error) {

                   }
               });


    }



    public void iniciarFireBase() {
        FirebaseApp.initializeApp(this);
        firebasedatabase = FirebaseDatabase.getInstance(); //conexion
        databaseReference = firebasedatabase.getReference(); // referencia


    }




                }






   /* iniciarfirebase();

    Query query = myRef.child("Preguntas").child("nivel");
        query.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(@NonNull DataSnapshot snapshot) {
        Preguntas p = new Preguntas();

        for (DataSnapshot data : snapshot.getChildren()) {
        p = data.getValue(Preguntas.class);
        Log.e("TAGRes", p.toString());
        }

        asignarPregunta(list);
        }

@Override
public void onCancelled(@NonNull DatabaseError error) {

        }
        });

        }

    private void asignarPregunta(List list) {
        List<Preguntas> preguntas = list;

        txt_trl1p1.setText(preguntas.get(0).getPregunta());
        Toast.makeText(this, "FFF" + preguntas, Toast.LENGTH_SHORT).show();
    }

    private void iniciarfirebase() {

    }


    @Override
    public void onClick(View view) {

    }


    */


