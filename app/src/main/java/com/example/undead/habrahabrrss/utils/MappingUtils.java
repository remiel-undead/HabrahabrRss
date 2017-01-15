package com.example.undead.habrahabrrss.utils;

import com.example.undead.habrahabrrss.model.RealmRssItem;
import com.example.undead.habrahabrrss.model.RssItem;

public class MappingUtils {
    public final static int OPTION_DAY = 0;
    public final static int OPTION_WEEK = 1;
    public final static int OPTION_MONTH = 2;
    public final static int OPTION_ALL = 3;

    public static RssItem convertRealmToRssItem(RealmRssItem realmRssItem) {
        return new RssItem(
                realmRssItem.getTitle(),
                realmRssItem.getDescription(),
                realmRssItem.getLink(),
                realmRssItem.getPublishedDate());
    }
}