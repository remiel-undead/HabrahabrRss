package com.example.undead.habrahabrrss.repository;

import com.example.undead.habrahabrrss.model.RssItem;

import java.util.List;

import io.reactivex.Observable;

public interface DataSource {
    Observable<List<RssItem>> getTopDay();
    Observable<List<RssItem>> getTopWeek();
    Observable<List<RssItem>> getTopMonth();
    Observable<List<RssItem>> getTopAll();
}
