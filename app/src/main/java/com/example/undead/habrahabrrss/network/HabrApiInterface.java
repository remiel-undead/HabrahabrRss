package com.example.undead.habrahabrrss.network;

import com.example.undead.habrahabrrss.model.RssFeedResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HabrApiInterface {
    @GET("interesting")
    Observable<RssFeedResponse> getInteresting();

    @GET("all")
    Observable<RssFeedResponse> getAll();

    @GET("best")
    Observable<RssFeedResponse> getTopDay();

    @GET("best/weekly")
    Observable<RssFeedResponse> getTopWeek();

    @GET("best/monthly")
    Observable<RssFeedResponse> getTopMonth();

    @GET("best/alltime")
    Observable<RssFeedResponse> getTopAll();
}
