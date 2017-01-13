package com.example.undead.habrahabrrss.utils;

import com.example.undead.habrahabrrss.model.RealmRssItem;
import com.example.undead.habrahabrrss.model.RssItem;

public class MappingUtils {
    public static RssItem convertRealmToRssItem(RealmRssItem realmRssItem) {
        return new RssItem(
                realmRssItem.getTitle(),
                realmRssItem.getDescription(),
                realmRssItem.getLink(),
                realmRssItem.getPublishedDate());
    }
}