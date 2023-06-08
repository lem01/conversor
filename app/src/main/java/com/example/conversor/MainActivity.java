package com.example.conversor;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conversor.adapter.CurrencyAdapter;
import com.example.conversor.model.CurrencyModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab_add_currency;
    private RecyclerView recyclerView;
    private CurrencyAdapter currencyAdapter;
    private List<CurrencyModel> currencyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab_add_currency = findViewById(R.id.fab_add_currency);
        recyclerView = findViewById(R.id.rc_currency);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        startLoadData(); // Llama al método para cargar los datos en el RecyclerView
        addItem();


    }


    private void addItem() {
        fab_add_currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCurrencyActivity.class);
                startActivity(intent);
            }
        });
    }

    private void startLoadData() {
        currencyList = new ArrayList<>(); // Crea una nueva lista de monedas

        // Agrega 10 elementos a la lista de monedas
        for (int i = 0; i < 10; i++) {
            CurrencyModel currency = new CurrencyModel(
                    "path_img_",
                    "Córdoba ",
                    "NIO ",
                    "Nicaragua " + i,
                    "C$",
                    5000.0
            );
            currencyList.add(currency);
        }

        currencyAdapter = new CurrencyAdapter(currencyList);
        recyclerView.setAdapter(currencyAdapter);
    }
}
