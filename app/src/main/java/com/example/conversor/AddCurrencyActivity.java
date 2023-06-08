package com.example.conversor;

import static com.example.conversor.adapter.CurrencyList.currencyList;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.CurrencyAmount;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.conversor.adapter.CurrencyAdapter;
import com.example.conversor.adapter.CurrencyList;
import com.example.conversor.model.CurrencyModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Currency;

public class AddCurrencyActivity extends AppCompatActivity {
    private Button btnCancel;
    private Button btnAcept;
    private TextInputEditText etName;
    private TextInputEditText etCountry;
    private TextInputEditText etSimbol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_currency);
        btnCancel = findViewById(R.id.btn_currency_cancel);
        btnAcept = findViewById(R.id.btn_acept_currency);
        etName = findViewById(R.id.txt_imput_et_name);
        etCountry = findViewById(R.id.txt_imput_et_country);
        etSimbol = findViewById(R.id.txt_imput_et_simbol);

        back();
        btnAcept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accept();
            }
        });
    }

    private void accept() {

        String currencyName = etName.getText().toString();
        String country = etCountry.getText().toString();
        String currencySymbol = etSimbol.getText().toString();

        // Verificar si todos los campos están llenos
        if (!TextUtils.isEmpty(currencyName) && !TextUtils.isEmpty(country) && !TextUtils.isEmpty(currencySymbol)) {
            // Crear un nuevo objeto CurrencyModel
            CurrencyModel newCurrency = new CurrencyModel("Img", currencyName, "NIO", country, currencySymbol, 100);

            // Agregar el nuevo objeto a la lista
            CurrencyList.currencyList.add(newCurrency);

            if (CurrencyList.currencyAdapter != null) {
                CurrencyList.currencyAdapter.notifyDataSetChanged();
            }

            // Cerrar la actividad actual y regresar al MainActivity
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
        }
    }


    private void back() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}