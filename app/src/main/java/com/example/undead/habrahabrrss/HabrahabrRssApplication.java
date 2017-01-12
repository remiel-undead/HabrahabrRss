package com.example.undead.habrahabrrss;

import android.app.Application;

import com.example.undead.habrahabrrss.repository.RssRepository;

public class HabrahabrRssApplication extends Application {
    private RssRepository mRssRepository = new RssRepository();

    private static HabrahabrRssApplication sInstance;

    public static HabrahabrRssApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public RssRepository getRepository() {
        return mRssRepository;
    }
}
