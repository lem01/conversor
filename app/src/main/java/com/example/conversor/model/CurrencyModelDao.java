package com.example.conversor.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CurrencyModelDao extends RealmObject {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String countryPathImg;
    private String fullNameCurrency;
    private String currency;
    private String country;
    private String symbol;
    private double amount;


    public CurrencyModelDao() {
        // Constructor vacío requerido por Realm
    }

    public CurrencyModelDao(String countryPathImg, String fullNameCurrency, String currency, String country, String symbol, double amount) {
        this.countryPathImg = countryPathImg;
        this.fullNameCurrency = fullNameCurrency;
        this.currency = currency;
        this.country = country;
        this.symbol = symbol;
        this.amount = amount;
    }

    public CurrencyModelDao(String fullNameCurrency, String country, String symbol) {
        this.fullNameCurrency = fullNameCurrency;
        this.country = country;
        this.symbol = symbol;
    }

    public String getCountryPathImg() {
        return countryPathImg;
    }

    public String getFullNameCurrency() {
        return fullNameCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCountry() {
        return country;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getAmount() {
        return amount;
    }
}