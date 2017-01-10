package com.example.undead.habrahabrrss.repository;

import com.example.undead.habrahabrrss.model.RssItem;

import java.util.List;

public interface DataSource {
    List<RssItem> getTopDay();
    List<RssItem> getTopWeek();
    List<RssItem> getTopMonth();
    List<RssItem> getTopAll();
}
