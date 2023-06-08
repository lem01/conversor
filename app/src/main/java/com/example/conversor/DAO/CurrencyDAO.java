package com.example.conversor.DAO;

import com.example.conversor.model.CurrencyModelDao;

import io.realm.Realm;
import io.realm.RealmResults;

public class CurrencyDAO {

    public void addCurrency(CurrencyModelDao CurrencyModelDao) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(CurrencyModelDao);
            }
        });
        realm.close();
    }

    public void updateCurrency(CurrencyModelDao CurrencyModelDao) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(CurrencyModelDao);
            }
        });
        realm.close();
    }

    public void deleteCurrency(String currencyId) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CurrencyModelDao CurrencyModelDao = realm.where(CurrencyModelDao.class)
                        .equalTo("id", currencyId)
                        .findFirst();
                if (CurrencyModelDao != null) {
                    CurrencyModelDao.deleteFromRealm();
                }
            }
        });
        realm.close();
    }

    public RealmResults<CurrencyModelDao> getAllCurrencies() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<CurrencyModelDao> CurrencyModelDaos = realm.where(CurrencyModelDao.class).findAll();
        // Ordenar la lista si es necesario
        CurrencyModelDaos = CurrencyModelDaos.sort("fullNameCurrency");
        realm.close();
        return CurrencyModelDaos;
    }

    public CurrencyModelDao getCurrencyById(String currencyId) {
        Realm realm = Realm.getDefaultInstance();
        CurrencyModelDao CurrencyModelDao = realm.where(CurrencyModelDao.class)
                .equalTo("id", currencyId)
                .findFirst();
        realm.close();
        return CurrencyModelDao;
    }

    public void clearAllCurrencies() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(CurrencyModelDao.class);
            }
        });
        realm.close();
    }

}