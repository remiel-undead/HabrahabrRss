package com.example.undead.habrahabrrss.repository;

import com.example.undead.habrahabrrss.Unsubscribable;
import com.example.undead.habrahabrrss.model.RssItem;
import com.example.undead.habrahabrrss.utils.ObjectUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RssRepository implements
        DataSource,
        WritableDataStorage,
        UpdatableDataStorage,
        Unsubscribable {
    private CloudDataSource mCloudDataSource;
    private CacheDataSource mCacheDataSource;
    private CompositeDisposable mUpdateCompositeDisposable;

    public RssRepository() {
        mCacheDataSource = new CacheDataSource();
        mCloudDataSource = new CloudDataSource();
        mUpdateCompositeDisposable = new CompositeDisposable();
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

    public void updateCache() {
       // update top day
        mUpdateCompositeDisposable.add(mCloudDataSource
                .getTopDay()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<RssItem>>() {
                    @Override
                    public void onNext(List<RssItem> rssItems) {
                        if (!ObjectUtils.isEmpty(rssItems)) {
                            mCacheDataSource.setTopDay(rssItems);
                        }
                    }

                    @Override
                    public void onError(Throwable e) { }

                    @Override
                    public void onComplete() { }
                }));
        // update top week
        mUpdateCompositeDisposable.add(mCloudDataSource
                .getTopWeek()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<RssItem>>() {
                    @Override
                    public void onNext(List<RssItem> rssItems) {
                        if (!ObjectUtils.isEmpty(rssItems)) {
                            mCacheDataSource.setTopWeek(rssItems);
                        }
                    }

                    @Override
                    public void onError(Throwable e) { }

                    @Override
                    public void onComplete() { }
                }));
        // update top month
        mUpdateCompositeDisposable.add(mCloudDataSource
                .getTopMonth()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<RssItem>>() {
                    @Override
                    public void onNext(List<RssItem> rssItems) {
                        if (!ObjectUtils.isEmpty(rssItems)) {
                            mCacheDataSource.setTopMonth(rssItems);
                        }
                    }

                    @Override
                    public void onError(Throwable e) { }

                    @Override
                    public void onComplete() { }
                }));
        // update top all
        mUpdateCompositeDisposable.add(mCloudDataSource
                .getTopAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<RssItem>>() {
                    @Override
                    public void onNext(List<RssItem> rssItems) {
                        if (!ObjectUtils.isEmpty(rssItems)) {
                            mCacheDataSource.setTopAll(rssItems);
                        }
                    }

                    @Override
                    public void onError(Throwable e) { }

                    @Override
                    public void onComplete() { }
                }));
    }

    @Override
    public void unsubscribe() {
        mUpdateCompositeDisposable.clear();
    }
}
