package com.example.undead.habrahabrrss.network;

import com.example.undead.habrahabrrss.model.RssFeedResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HabrApiInterface {
    @GET("interesting")
    Observable<RssFeedResponse> getTopDay();

    @GET("interesting/weekly")
    Observable<RssFeedResponse> getTopWeek();

    @GET("interesting/monthly")
    Observable<RssFeedResponse> getTopMonth();

    @GET("interesting/all")
    Observable<RssFeedResponse> getTopAll();
}
