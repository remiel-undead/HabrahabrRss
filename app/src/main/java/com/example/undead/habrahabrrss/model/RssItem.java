package com.example.undead.habrahabrrss.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false, name = "item")
public class RssItem {
    public RssItem() {}

    public RssItem(String title, String description, String link, String pubDate) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.pubDate = pubDate;
    }

    @Element
    private String title;

    @Element
    private String description;

    @Element
    private String link;

    @Element
    private String pubDate;

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
}
