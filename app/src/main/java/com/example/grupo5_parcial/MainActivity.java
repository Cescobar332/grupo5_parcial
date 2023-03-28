package com.example.grupo5_parcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Partido> listaPrincipalPartidos;
    private RecyclerView rvListadoPartidos;
    private TextView tvNumGanar, tvNumEmpatar, tvNumPerder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.txt_partidos));
        rvListadoPartidos = findViewById(R.id.rv_list_partidos);
        tvNumGanar = findViewById(R.id.tv_num_ganar);
        tvNumEmpatar = findViewById(R.id.tv_num_empatar);
        tvNumPerder = findViewById(R.id.tv_num_perder);
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

        Integer gl1 = 0;
        Integer gl2 = 0;
        Integer gl3= 0;
        Integer gl4 = 0;
        Integer gl5 = 0;
        Integer gv1 = 0;
        Integer gv2 = 0;
        Integer gv3 = 0;
        Integer gv4 = 0;
        Integer gv5 = 0;
        Integer w = 0;
        Integer L = 0;
        Integer T = 0;

        gl1 = (partido1.getGolesEquipo());
        gl2 = (partido2.getGolesEquipo());
        gl3 = (partido3.getGolesEquipo());
        gl4 = (partido4.getGolesEquipo());
        gl5 = (partido5.getGolesEquipo());
        gv1 = (partido1.getGolesRival());
        gv2 = (partido2.getGolesRival());
        gv3 = (partido3.getGolesRival());
        gv4 = (partido4.getGolesRival());
        gv5 = (partido5.getGolesRival());
        if(gl1>gv1){
            w=w+1;
            tvNumGanar.setText(w.toString());
        } else if (gl1<gv1) {
            L=L+1;
            tvNumPerder.setText(L.toString());
        } else if (gl1==gv1){
            T=T+1;
            tvNumEmpatar.setText(T.toString());
        }
        if(gl2>gv2){
            w=w+1;
            tvNumGanar.setText(w.toString());
        } else if (gl2<gv2) {
            L=L+1;
            tvNumPerder.setText(L.toString());
        } else if (gl2==gv2){
            T=T+1;
            tvNumEmpatar.setText(T.toString());
        }
        if(gl3>gv3){
            w=w+1;
            tvNumGanar.setText(w.toString());
        } else if (gl3<gv3) {
            L=L+1;
            tvNumPerder.setText(L.toString());
        } else if (gl3==gv3){
            T=T+1;
            tvNumEmpatar.setText(T.toString());
        }
        if(gl4>gv4){
            w=w+1;
            tvNumGanar.setText(w.toString());
        } else if (gl4<gv4) {
            L=L+1;
            tvNumPerder.setText(L.toString());
        } else if (gl4==gv4){
            T=T+1;
            tvNumEmpatar.setText(T.toString());
        }
        if(gl5>gv5){
            w=w+1;
            tvNumGanar.setText(w.toString());
        } else if (gl5<gv5) {
            L=L+1;
            tvNumPerder.setText(L.toString());
        } else if (gl5==gv5){
            T=T+1;
            tvNumEmpatar.setText(T.toString());
        }


    }
}