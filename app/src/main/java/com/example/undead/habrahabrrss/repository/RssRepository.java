package com.example.undead.habrahabrrss.repository;

import com.example.undead.habrahabrrss.model.RssItem;
import com.example.undead.habrahabrrss.utils.ObjectUtils;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function4;

public class RssRepository implements
        DataSource,
        WritableDataStorage,
        UpdatableDataStorage {
    private CloudDataSource mCloudDataSource;
    private CacheDataSource mCacheDataSource;

    public RssRepository() {
        mCacheDataSource = new CacheDataSource();
        mCloudDataSource = new CloudDataSource();
    }

    @Override
    public Observable<List<RssItem>> getTopDay() {
        return mCacheDataSource.getTopDay();
    }

    @Override
    public Observable<List<RssItem>> getTopWeek() {
        return mCacheDataSource.getTopWeek();
    }

    @Override
    public Observable<List<RssItem>> getTopMonth() {
        return mCacheDataSource.getTopMonth();
    }

    @Override
    public Observable<List<RssItem>> getTopAll() {
        return mCacheDataSource.getTopAll();
    }

    @Override
    public void setTopDay(List<RssItem> rssItemList) {
        mCacheDataSource.setTopDay(rssItemList);
    }

    @Override
    public void setTopWeek(List<RssItem> rssItemList) {
        mCacheDataSource.setTopWeek(rssItemList);
    }

    @Override
    public void setTopMonth(List<RssItem> rssItemList) {
        mCacheDataSource.setTopMonth(rssItemList);
    }

    @Override
    public void setTopAll(List<RssItem> rssItemList) {
        mCacheDataSource.setTopAll(rssItemList);
    }

    public Observable<Void> updateCache() {
        return Observable.defer(new Callable<ObservableSource<? extends Void>>() {
            @Override
            public ObservableSource<? extends Void> call() throws Exception {
                Observable<List<RssItem>> topDay = mCloudDataSource.getTopDay();
                Observable<List<RssItem>> topWeek = mCloudDataSource.getTopWeek();
                Observable<List<RssItem>> topMonth = mCloudDataSource.getTopMonth();
                Observable<List<RssItem>> topAll = mCloudDataSource.getTopAll();
                return Observable.zip(topDay, topWeek, topMonth, topAll,
                        new Function4<List<RssItem>, List<RssItem>, List<RssItem>, List<RssItem>, Void>() {
                            @Override
                            public Void apply(List<RssItem> topDay1, List<RssItem> topWeek1, List<RssItem> topMonth1, List<RssItem> topAll1) throws Exception {
                                if (!ObjectUtils.isEmpty(topDay1)) {
                                    mCacheDataSource.setTopDay(topDay1);
                                }
                                if (!ObjectUtils.isEmpty(topWeek1)) {
                                    mCacheDataSource.setTopWeek(topWeek1);
                                }
                                if (!ObjectUtils.isEmpty(topMonth1)) {
                                    mCacheDataSource.setTopMonth(topMonth1);
                                }
                                if (!ObjectUtils.isEmpty(topAll1)) {
                                    mCacheDataSource.setTopAll(topAll1);
                                }
                                return null;
                            }
                        });
            }
        });
    }
}
