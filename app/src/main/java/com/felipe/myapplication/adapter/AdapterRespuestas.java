package com.felipe.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.felipe.myapplication.R;
import com.felipe.myapplication.Resultados;

import java.util.List;

public class AdapterRespuestas extends RecyclerView.Adapter<AdapterRespuestas.viewholderrespuestas> {
    List<Resultados> resultadolist;


    public AdapterRespuestas(List<Resultados> resultadolist) {
        this.resultadolist = resultadolist;
    }

    @NonNull
    @Override
    public viewholderrespuestas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_resultados,parent,false );
        viewholderrespuestas holder = new viewholderrespuestas(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholderrespuestas holder, int position) {
        Resultados rp = resultadolist.get(position);
        holder.rc_proyecto.setText(rp.getProyecto());
        holder.rc_producto.setText(rp.getProducto());
        holder.rc_nombre_investigador.setText(rp.getInvestigador());
        holder.rc_niveltrl.setText(rp.getNivel());
    }



    @Override
    public int getItemCount() {
        return resultadolist.size();
    }

    public class viewholderrespuestas extends RecyclerView.ViewHolder {

        TextView rc_proyecto,rc_producto,rc_nombre_investigador,rc_niveltrl;
        public viewholderrespuestas(@NonNull View itemView) {
            super(itemView);

            rc_proyecto = itemView.findViewById(R.id.rc_proyecto);
            rc_producto = itemView.findViewById(R.id.rc_producto);
            rc_nombre_investigador = itemView.findViewById(R.id.rc_nombre_investigador);
            rc_niveltrl = itemView.findViewById(R.id.rc_niveltrl);
        }
    }
}
