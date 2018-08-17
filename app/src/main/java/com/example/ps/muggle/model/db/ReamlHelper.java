package com.example.ps.muggle.model.db;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ReamlHelper implements DBHelper {

    private static final String DB_NAME = "myRealm.realm";

    private Realm mRealm;

    @Inject
    public ReamlHelper() {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }

    @Override
    public void insertId(int id) {

    }
}
