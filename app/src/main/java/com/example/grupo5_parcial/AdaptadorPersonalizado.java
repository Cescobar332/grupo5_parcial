package com.example.grupo5_parcial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        this.onItemClickListener=null;
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
        private TextView tvEquipo, tvGolesEquipo, tvGolesRival;
        private ImageView ivEscudo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEquipo = itemView.findViewById(R.id.tv_equipo);
            tvGolesEquipo = itemView.findViewById(R.id.tv_goles_equipo);
            tvGolesRival = itemView.findViewById(R.id.tv_goles_rival);
            ivEscudo = itemView.findViewById(R.id.iv_escudo);

        }
        public void enlazar(Partido miPartido){
            tvEquipo.setText(miPartido.getNombreRival());
            tvGolesEquipo.setText(String.valueOf(miPartido.getGolesEquipo()));
            tvGolesRival.setText(String.valueOf(miPartido.getGolesRival()));

            Picasso.get()
                    .load(miPartido.getUrlEscudoRival())
                    .error(R.drawable.ic_launcher_background)
                    .into(ivEscudo);

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
