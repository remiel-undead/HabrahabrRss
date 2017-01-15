package com.example.undead.habrahabrrss.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmRssItem extends RealmObject {
    private String title;
    private String description;
    private String link;
    @PrimaryKey
    private String pubDate;

    private int feedType;

    public RealmRssItem() { }

    public RealmRssItem(RssItem rssItem, int feedType) {
        this.feedType = feedType;
        this.title = rssItem.getTitle();
        this.description = rssItem.getDescription();
        this.link = rssItem.getLink();
        this.pubDate = rssItem.getPublishedDate();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getPublishedDate() {
        return pubDate;
    }

    public int getFeedType() {
        return feedType;
    }
}