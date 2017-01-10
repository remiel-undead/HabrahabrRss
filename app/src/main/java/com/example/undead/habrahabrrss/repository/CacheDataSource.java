package com.example.undead.habrahabrrss.repository;

import com.example.undead.habrahabrrss.model.RssItem;

import java.util.List;

public class CacheDataSource implements DataSource, WritableDataStorage {
    @Override
    public List<RssItem> getTopDay() {
        return null;
    }

    @Override
    public List<RssItem> getTopWeek() {
        return null;
    }

    @Override
    public List<RssItem> getTopMonth() {
        return null;
    }

    @Override
    public List<RssItem> getTopAll() {
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
