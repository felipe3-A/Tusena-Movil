package com.felipe.myapplication.Framents;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.felipe.myapplication.Preguntas;
import com.felipe.myapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class FragmentCalculadora extends Fragment{


    FirebaseDatabase database;
    DatabaseReference myRef;

    List<Preguntas> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_calculadora_trl1,container,false);
       return view;


    }

    private void referenciar() {
    }


}
