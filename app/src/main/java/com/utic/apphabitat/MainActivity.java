package com.utic.apphabitat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView tvPaises;
    private ListView lvPaises;
    //arreglos
    private String [] paises= {"Argentina","Chile","Paraguay","Bolivia","Peru","Ecuador","Brasil",
            "Colombia","Venezuela","Uruguay"};
    private String[] habitantes={"45.808.747","19.212.362","7.453.000","11.832.936","33.396.000",
            "17.888.474","213.993.441","51.049.000","28.704.947","3.485.152"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //intrucciones
        tvPaises=findViewById(R.id.tvPaises);
        lvPaises=findViewById(R.id.lvPaises);
        ArrayAdapter adactador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,paises);
        lvPaises.setAdapter(adactador);

        //eventos
        lvPaises.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                tvPaises.setText("La población de  "+lvPaises.getItemAtPosition(position)+" es: "+habitantes[position]);

            }
        });

    }
}