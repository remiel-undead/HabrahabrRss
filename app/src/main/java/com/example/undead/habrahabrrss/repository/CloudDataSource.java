package com.example.undead.habrahabrrss.repository;

import com.example.undead.habrahabrrss.model.RssFeedResponse;
import com.example.undead.habrahabrrss.model.RssItem;
import com.example.undead.habrahabrrss.network.HabrApiInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class CloudDataSource implements DataSource {

    private static final String BASE_URL = "https://habrahabr.ru/rss/";
    private static final String DEFAULT_ERROR_MESSAGE = "Failed to process the request.";

    private HabrApiInterface mApi;

    public CloudDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        mApi = retrofit.create(HabrApiInterface.class);
    }


    @Override
    public Observable<List<RssItem>> getTopDay() {
        return mApi
                .getTopDay()
                .map(new Function<RssFeedResponse, List<RssItem>>() {
                    @Override
                    public List<RssItem> apply(RssFeedResponse rssFeedResponse) throws Exception {
                        return rssFeedResponse.getChannel().getItems();
                    }
                });
    }

    @Override
    public Observable<List<RssItem>> getTopWeek() {
        return null;
    }

    @Override
    public Observable<List<RssItem>> getTopMonth() {
        return null;
    }

    @Override
    public Observable<List<RssItem>> getTopAll() {
        return null;
    }
}
