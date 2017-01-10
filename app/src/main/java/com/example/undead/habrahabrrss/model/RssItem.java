package com.example.undead.habrahabrrss.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false, name = "item")
public class RssItem {

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
