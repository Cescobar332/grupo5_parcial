package com.example.grupo5_parcial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.ViewHolder>{

    public void setListadoPartidos(ArrayList<Partido> listadoPartidos) {
        this.listadoPartidos = listadoPartidos;
        notifyDataSetChanged();
    }

    private ArrayList<Partido> listadoPartidos;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AdaptadorPersonalizado(ArrayList<Partido> listadoPartidos) {
        this.listadoPartidos = listadoPartidos;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizado.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View miView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_partidos, parent, false);
        return new ViewHolder(miView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.ViewHolder holder, int position) {
        Partido miPartido = listadoPartidos.get(position);
        holder.enlazar(miPartido);
    }

    @Override
    public int getItemCount() {
        return listadoPartidos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void enlazar(Partido miPartido){

            if(onItemClickListener != null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(miPartido, getAdapterPosition());
                    }
                });

            }
        }
    }
    public interface OnItemClickListener{
        void onItemClick(Partido miPartido, int posicion);

    }
}
