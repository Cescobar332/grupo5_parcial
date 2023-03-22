package com.example.grupo5_parcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Partido> listaPrincipalPartidos;
    private RecyclerView rvListadoPartidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.txt_partidos));
        rvListadoPartidos = findViewById(R.id.rv_list_partidos);
        cargarPartidos();


        AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado(listaPrincipalPartidos);
        miAdaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
            @Override
            public void onItemClick(Partido miPartido, int posicion) {
                Intent intent = new Intent(MainActivity.this, EquipoRivalActivity.class);
                intent.putExtra("partido", miPartido);
                startActivity(intent);
            }


        });
        rvListadoPartidos.setAdapter(miAdaptador);
        rvListadoPartidos.setLayoutManager(new LinearLayoutManager(this));
    }
    public void cargarPartidos(){
        Partido partido1 = new Partido("Polonia", 0, "https://th.bing.com/th/id/OIP.rRxx9YfYZqubBAFV-9sTywHaEo?pid=ImgDet&rs=1", 2);
        Partido partido2 = new Partido("Australia", 1, "https://th.bing.com/th/id/R.db3b069acb7b0d3713781724f77f545c?rik=0a4QWfImSXc1bw&pid=ImgRaw&r=0", 2);
        Partido partido3 = new Partido("Países bajos", 3, "https://th.bing.com/th/id/OIP.1zmcWxJ0fWJB9cGJzIRBiQHaE7?pid=ImgDet&rs=1", 4);
        Partido partido4 = new Partido("Croacia", 0, "https://th.bing.com/th/id/OIP.SS3F3rrO5HTIQFB7PpnPlwHaDt?pid=ImgDet&rs=1", 3);
        Partido partido5 = new Partido("Francia", 2, "https://i.pinimg.com/originals/fb/e1/66/fbe166d6d025b4ee089ef065009b5067.gif", 4);

        listaPrincipalPartidos = new ArrayList<>();
        listaPrincipalPartidos.add(partido1);
        listaPrincipalPartidos.add(partido2);
        listaPrincipalPartidos.add(partido3);
        listaPrincipalPartidos.add(partido4);
        listaPrincipalPartidos.add(partido5);

    }
}