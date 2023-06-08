package com.example.conversor.DAO;

import com.example.conversor.model.CurrencyModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class CurrencyDAO {

    public void addCurrency(CurrencyModel currencyModel) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(currencyModel);
            }
        });
        realm.close();
    }

    public void updateCurrency(CurrencyModel currencyModel) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(currencyModel);
            }
        });
        realm.close();
    }

    public void deleteCurrency(String currencyId) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CurrencyModel currencyModel = realm.where(CurrencyModel.class)
                        .equalTo("id", currencyId)
                        .findFirst();
                if (currencyModel != null) {
                    currencyModel.deleteFromRealm();
                }
            }
        });
        realm.close();
    }

    public RealmResults<CurrencyModel> getAllCurrencies() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<CurrencyModel> currencyModels = realm.where(CurrencyModel.class).findAll();
        // Ordenar la lista si es necesario
        currencyModels = currencyModels.sort("fullNameCurrency");
        realm.close();
        return currencyModels;
    }

    public CurrencyModel getCurrencyById(String currencyId) {
        Realm realm = Realm.getDefaultInstance();
        CurrencyModel currencyModel = realm.where(CurrencyModel.class)
                .equalTo("id", currencyId)
                .findFirst();
        realm.close();
        return currencyModel;
    }

    public void clearAllCurrencies() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(CurrencyModel.class);
            }
        });
        realm.close();
    }

}
