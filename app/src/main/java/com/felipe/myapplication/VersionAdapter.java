package com.felipe.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VersionAdapter extends RecyclerView.Adapter<VersionAdapter.VersionVH> {

    List<Version>versionList;

    public VersionAdapter(List<Version> versionList) {
        this.versionList = versionList;
    }

    @NonNull
    @Override
    public VersionAdapter.VersionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
      return new VersionVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VersionAdapter.VersionVH holder, int position) {
    Version version=versionList.get(position);
    holder.codeNameTxt.setText(version.getCodeName());
    holder.versionTxt.setText(version.getVersion());
    holder.descripcionTxt.setText(version.getDescripcion());

boolean isExpadable=versionList.get(position).getExpandible();
holder.expandableLayout.setVisibility(isExpadable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return versionList.size();
    }

    public class VersionVH extends RecyclerView.ViewHolder {
        //Vistas
        TextView codeNameTxt,versionTxt,apiLevelTxt,descripcionTxt;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;


        public VersionVH(@NonNull View itemView) {
            super(itemView);
            codeNameTxt=itemView.findViewById(R.id.code_name);
            versionTxt=itemView.findViewById(R.id.version);
            descripcionTxt=itemView.findViewById(R.id.descripcion);
            linearLayout=itemView.findViewById(R.id.linear_layout);
            expandableLayout=itemView.findViewById(R.id.expandible_layout);


            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Version version=versionList.get(getAdapterPosition());
                    version.setExpandible(!version.getExpandible());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
