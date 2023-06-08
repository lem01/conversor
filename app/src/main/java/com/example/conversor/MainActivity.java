package com.example.conversor;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conversor.DAO.CurrencyDAO;
import com.example.conversor.adapter.CurrencyAdapter;
import com.example.conversor.adapter.CurrencyList;
import com.example.conversor.model.CurrencyModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab_add_currency;
    private RecyclerView recyclerView;
    private List<CurrencyModel> currencyList;
    private CurrencyDAO currencyDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        //////////////////////agregar configuracion inicial
//        Realm.init(this);
//        RealmConfiguration config = new RealmConfiguration.Builder()
//                .deleteRealmIfMigrationNeeded()
//                .build();
//
//        Realm.setDefaultConfiguration(config);
//
//        CurrencyDAO currencyDAO = new CurrencyDAO();
//
//        currencyDAO.clear();

// Inicializar Realm
        Realm.init(this);
        // Inicializar el DAO
        currencyDAO = new CurrencyDAO();



        // Llamar a la función para agregar y mostrar las monedas
        addAndShowCurrencies();


        setContentView(R.layout.activity_main);
        fab_add_currency = findViewById(R.id.fab_add_currency);
        recyclerView = findViewById(R.id.rc_currency);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        addItem();


    }

    private void addAndShowCurrencies() {
        // Agregar 10 monedas utilizando el DAO
        for (int i = 0; i < 10; i++) {
            CurrencyModel currency = new CurrencyModel(
                    "Country " + i,
                    "Full Name " + i,
                    "Currency " + i,
                    "Country " + i,
                    "Symbol " + i,
                    i * 100.0
            );
            currencyDAO.addCurrency(currency);
        }

        // Obtener todas las monedas utilizando el DAO
        List<CurrencyModel> currencies = currencyDAO.getAllCurrencies();

        // Mostrar las monedas en el registro de logs
        for (CurrencyModel currency : currencies) {
            Log.d("Currency", "Country: " + currency.getCountry() +
                    ", Full Name: " + currency.getFullNameCurrency() +
                    ", Currency: " + currency.getCurrency() +
                    ", Symbol: " + currency.getSymbol() +
                    ", Amount: " + currency.getAmount());
        }
    }


//    private void llenarDatos() {
//        List<CurrencyModel> modeloC = new ArrayList<>();
//
//        modeloC.add(new CurrencyModel(
//                "path_img_",
//                "Córdoba ",
//                "NIO ",
//                "Nicaragua ",
//                "C$",
//                5000.0
//        ));   modeloC.add(new CurrencyModel(
//                "path_img_",
//                "Córdoba ",
//                "NIO ",
//                "Nicaragua ",
//                "C$",
//                5000.0
//        ));   modeloC.add(new CurrencyModel(
//                "path_img_",
//                "Córdoba ",
//                "NIO ",
//                "Nicaragua ",
//                "C$",
//                5000.0
//        ));
//
////        CurrencyDAO.addAll(modeloC);
//        consultarDatos();
//
//    }
//
//
//        private void consultarDatos(){
//
//            List<CurrencyModel> nuevoModeloLista = CurrencyDAO.getSelected();
//
//            for (CurrencyModel auxModelo: nuevoModeloLista){
//                Log.i("R E A L M ",auxModelo.getCountry());
//            }
//        }



    private void addItem() {
        fab_add_currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCurrencyActivity.class);
                startActivity(intent);
            }
        });
    }

//    private void addItemInDB(){
//        // Ejemplo de agregar un elemento
//        CurrencyModel newCurrency = new CurrencyModel(
//                "path_img_",
//                "Córdoba ",
//                "NIO ",
//                "Nicaragua ",
//                "C$",
//                5000.0
//        );
//
//        realm.executeTransaction(realm -> {
//            realm.copyToRealmOrUpdate(newCurrency);
//        });
//
//        CurrencyList.currencyAdapter.addCurrency(newCurrency);
//
////        recyclerView.setAdapter(CurrencyList.currencyAdapter);
//    }

//    private void startLoadData() {
//
//
//// Ejemplo de agregar un elemento
//        CurrencyModel newCurrency = new CurrencyModel(
//                "path_img_",
//                "Córdoba ",
//                "NIO ",
//                "Nicaragua ",
//                "C$",
//                5000.0
//        );
//
//        realm.executeTransaction(realm -> {
//            realm.copyToRealmOrUpdate(newCurrency);
//        });
//
//        CurrencyList.currencyAdapter.addCurrency(newCurrency);
//
//        // Obtener datos de Realm y agregarlos a la lista
//        currencyList.addAll(realm.where(CurrencyModel.class).findAll());
//
//        recyclerView.setAdapter(CurrencyList.currencyAdapter);
//
//
//
//
////        currencyList = new ArrayList<>(); // Crea una nueva lista de monedas
//
//
//
////        // Agrega 10 elementos a la lista de monedas
////        for (int i = 0; i < 1; i++) {
////            CurrencyModel currency = new CurrencyModel(
////                    "path_img_",
////                    "Córdoba ",
////                    "NIO ",
////                    "Nicaragua " + i,
////                    "C$",
////                    5000.0
////            );
////            currencyList.add(currency);
////
////            realm.executeTransaction(realm -> {
////                realm.copyToRealmOrUpdate(newTask);
////            });
////        }
////
////
//////        CurrencyList.currencyAdapter = new CurrencyAdapter(currencyList);
////
////        taskAdapter.addTask(newTask);
////
////        recyclerView.setAdapter(CurrencyList.currencyAdapter);
//    }
}
