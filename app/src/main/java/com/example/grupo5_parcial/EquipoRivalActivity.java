package com.example.grupo5_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Objects;

public class EquipoRivalActivity extends AppCompatActivity {
    private ListView Lv_data;
    private TextView Tv_data;
    private String[] polonia = {"Wojciech Szczesny","Robert Lewandowski","Jakub Kiwior","Kamil Glik","Matty Cash","Bartosz Bereszyński","Piotr Zielinski","Krystian Bielik","Grzegorz Krychowiak","Przemyslaw Frankowski","Karol Swiderski"};
    private String[] australia = {"Mathew Ryan", "Aziz Behich", "Kye Rowles", "Harry Souttar", "Milos Degenek", "Mathew Leckie", "Mitchell Duke", "Jackson Irvine", "Aaron Mooy", "Riley McGree", "Keanu Baccus"};
    private String[] paisesBajos = {"Noppert", "Nathan Ake", "Virgil van Dijk", "Jurrien Timber", "Daley Blind", "Frenkie de Jong", "Marten De Roon", "Denzel Dumfries", "Cody Gakpo", "Memphis Depay", "Steven Bergwijn"};
    private String[] croacia = {"Borna Sosa", "Ivan Perisic", "Mario Pasalic", "Luka Modric", "Dejan Lovren", "Andrej Kramaric", "Mateo Kovacic", "Josip Juranovic", "Dominik Livakovic", "Josko Gvardiol", "Marcelo Brozovic"};
    private String[] francia = {"Raphael Varane", "Hugo Lloris", "Dayot Upamecano", "Aurelien Tchouameni", "Adrien Rabiot", "Kylian Mbappe", "Jules Kounde", "Theo Hernandez", "Antoine Griezman", "Olivier Giroud", "Ousmane Dembelé"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo_rival);
        setTitle(getString(R.string.txt_detalle));
        Lv_data = findViewById(R.id.lv_alineacion);
        Tv_data = findViewById(R.id.tv_principal_alineacion);
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, polonia);
        ArrayAdapter<String>adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, australia);
        ArrayAdapter<String>adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, paisesBajos);
        ArrayAdapter<String>adapter4= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, croacia);
        ArrayAdapter<String>adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, francia);







        Partido miPartidoAtrapado = (Partido) getIntent().getSerializableExtra("partido");
        Tv_data.setText(miPartidoAtrapado.getNombreRival());
        if(Objects.equals(miPartidoAtrapado.getNombreRival(), "Polonia")){
            Lv_data.setAdapter(adapter);
        } else if (Objects.equals(miPartidoAtrapado.getNombreRival(), "Australia")) {
            Lv_data.setAdapter(adapter2);
        } else if (Objects.equals(miPartidoAtrapado.getNombreRival(), "Países bajos")) {
            Lv_data.setAdapter(adapter3);
        }else if (Objects.equals(miPartidoAtrapado.getNombreRival(), "Croacia")) {
            Lv_data.setAdapter(adapter4);
        }else if (Objects.equals(miPartidoAtrapado.getNombreRival(), "Francia")) {
            Lv_data.setAdapter(adapter5);
        }
    }
}