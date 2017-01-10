package com.example.undead.habrahabrrss.repository;

import com.example.undead.habrahabrrss.model.RssItem;

import java.util.List;

public interface WritableDataStorage {
    void setTopDay(List<RssItem> rssItemList);
    void setTopWeek(List<RssItem> rssItemList);
    void setTopMonth(List<RssItem> rssItemList);
    void setTopAll(List<RssItem> rssItemList);
}
