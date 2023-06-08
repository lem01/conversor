package com.example.conversor;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.conversor.adapter.CurrencyList;
import com.example.conversor.model.CurrencyModel;
import com.google.android.material.textfield.TextInputEditText;

public class EditCurrencyActivity extends AppCompatActivity {

    private Button btnCancel;
    private Button btnAcept;
    private TextInputEditText etName;
    private TextInputEditText etCountry;
    private TextInputEditText etSimbol;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_currency);

        btnCancel = findViewById(R.id.editcurrencyactivity_btn_currency_cancel);
        btnAcept = findViewById(R.id.editcurrencyactivity_btn_acept_currency);
        etName = findViewById(R.id.editcurrencyactivity_txt_imput_et_name);
        etCountry = findViewById(R.id.editcurrencyactivity_txt_imput_et_country);
        etSimbol = findViewById(R.id.editcurrencyactivity_txt_imput_et_simbol);

        position = getIntent().getIntExtra("position", 0);


        initValuesEditText();
        back();
        accept();

    }

    private void back() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initValuesEditText() {
        etName.setText(CurrencyList.currencyList.get(position).getFullNameCurrency());
        etCountry.setText(CurrencyList.currencyList.get(position).getCountry());
        etSimbol.setText(CurrencyList.currencyList.get(position).getSymbol());
    }


    private void accept() {


        btnAcept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currencyName = etName.getText().toString();
                String country = etCountry.getText().toString();
                String currencySymbol = etSimbol.getText().toString();

                // Verificar si todos los campos están llenos
                if (!TextUtils.isEmpty(currencyName) && !TextUtils.isEmpty(country) && !TextUtils.isEmpty(currencySymbol)) {
                    // Crear un nuevo objeto CurrencyModel
                    CurrencyModel newCurrency = new CurrencyModel("Img", currencyName, "NIO", country, currencySymbol, 100);

                    // Actualizar el  objeto de la lista
                    CurrencyList.currencyList.set(position, newCurrency);

                    if (CurrencyList.currencyAdapter != null) {
                        CurrencyList.currencyAdapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "Elemento actuaizado", Toast.LENGTH_SHORT).show();

                    }

                    // Cerrar la actividad actual y regresar al MainActivity
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}