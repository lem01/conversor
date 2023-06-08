package com.example.conversor.model;


public class CurrencyModel {
    private String countryPathImg;
    private String fullNameCurrency;
    private String currency;
    private String country;
    private String symbol;
    private double amount;

    public CurrencyModel(String countryPathImg, String fullNameCurrency, String currency, String country, String symbol, double amount) {
        this.countryPathImg = countryPathImg;
        this.fullNameCurrency = fullNameCurrency;
        this.currency = currency;
        this.country = country;
        this.symbol = symbol;
        this.amount = amount;
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
