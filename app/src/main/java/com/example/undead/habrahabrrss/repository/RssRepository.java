package com.example.undead.habrahabrrss.repository;

import com.example.undead.habrahabrrss.model.RssItem;

import java.util.List;

import io.reactivex.Observable;

public class RssRepository implements DataSource, WritableDataStorage {
    private CloudDataSource mCloudDataSource;
    private CacheDataSource mCacheDataSource;

    public RssRepository() {
        mCacheDataSource = new CacheDataSource();
        mCloudDataSource = new CloudDataSource();
    }

    @Override
    public Observable<List<RssItem>> getTopDay() {
        // TODO implement fetch from cache
        return mCloudDataSource.getTopDay();
    }

    @Override
    public Observable<List<RssItem>> getTopWeek() {
        // TODO implement fetch from cache
        return mCloudDataSource.getTopWeek();
    }

    @Override
    public Observable<List<RssItem>> getTopMonth() {
        // TODO implement fetch from cache
        return mCloudDataSource.getTopMonth();
    }

    @Override
    public Observable<List<RssItem>> getTopAll() {
        // TODO implement fetch from cache
        return mCloudDataSource.getTopAll();
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
