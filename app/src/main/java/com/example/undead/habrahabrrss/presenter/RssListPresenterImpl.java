package com.example.undead.habrahabrrss.presenter;

import com.example.undead.habrahabrrss.HabrahabrRssApplication;
import com.example.undead.habrahabrrss.model.RssItem;
import com.example.undead.habrahabrrss.repository.RssRepository;
import com.example.undead.habrahabrrss.view_interface.BaseView;
import com.example.undead.habrahabrrss.view_interface.RssListView;


import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RssListPresenterImpl implements RssListPresenter {

    public interface OnListItemClickListener {
        void onListItemClick(RssItem item);
    }

    private class RssListDisposableObserver extends DisposableObserver<List<RssItem>> {
        @Override
        public void onNext(List<RssItem> rssItems) {
            mRssListView.setRssItemList(rssItems);
        }

        @Override
        public void onError(Throwable e) {
            mBaseView.showErrorMessage(e.getMessage());
        }

        @Override
        public void onComplete() { }
    }

    private CompositeDisposable mDisposable;
    private RssRepository mRssRepository;
    private RssListView mRssListView;
    private BaseView mBaseView;
    private OnListItemClickListener mOnListItemClickListener;

    public RssListPresenterImpl(RssListView rssListView, BaseView baseView, OnListItemClickListener onListItemClickListener) {
        this.mRssListView = rssListView;
        this.mBaseView = baseView;
        this.mOnListItemClickListener = onListItemClickListener;
        this.mRssRepository = HabrahabrRssApplication.getInstance().getRepository();
        this.mDisposable = new CompositeDisposable();
    }

    @Override
    public void fetchTopDay() {
        mDisposable.add(mRssRepository
                .getTopDay()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new RssListDisposableObserver()));
    }

    @Override
    public void fetchTopWeek() {
        mDisposable.add(mRssRepository
                .getTopWeek()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new RssListDisposableObserver()));
    }

    @Override
    public void fetchTopMonth() {
        mDisposable.add(mRssRepository
                .getTopMonth()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new RssListDisposableObserver()));
    }

    @Override
    public void fetchTopAll() {
        mDisposable.add(mRssRepository
                .getTopAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new RssListDisposableObserver()));
    }

    @Override
    public void unsubscribe() {
        mDisposable.clear();
    }
}
