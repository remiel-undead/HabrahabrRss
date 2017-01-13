package com.example.undead.habrahabrrss.repository;

import com.example.undead.habrahabrrss.model.RssItem;

import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;

public class CacheDataSource implements DataSource, WritableDataStorage {
    private Realm mRealm;

    public CacheDataSource() {
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    public Observable<List<RssItem>> getTopDay() {
        return null;
    }

    @Override
    public Observable<List<RssItem>> getTopWeek() {
        return null;
    }

    @Override
    public Observable<List<RssItem>> getTopMonth() {
        return null;
    }

    @Override
    public Observable<List<RssItem>> getTopAll() {
        return null;
    }

    @Override
    public void setTopDay(List<RssItem> rssItemList) {

    }

    @Override
    public void setTopWeek(List<RssItem> rssItemList) {

    }

    @Override
    public void setTopMonth(List<RssItem> rssItemList) {

    }

    @Override
    public void setTopAll(List<RssItem> rssItemList) {

    }
}
