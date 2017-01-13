package com.example.undead.habrahabrrss;

import android.app.Application;

import com.example.undead.habrahabrrss.repository.RssRepository;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class HabrahabrRssApplication extends Application {
    private RssRepository mRssRepository;

    private static HabrahabrRssApplication sInstance;

    public static HabrahabrRssApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        mRssRepository = new RssRepository();
    }

    public RssRepository getRepository() {
        return mRssRepository;
    }
}
