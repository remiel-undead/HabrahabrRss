package com.example.undead.habrahabrrss.presenter;

import com.example.undead.habrahabrrss.HabrahabrRssApplication;
import com.example.undead.habrahabrrss.Unsubscribable;
import com.example.undead.habrahabrrss.model.RssItem;
import com.example.undead.habrahabrrss.repository.RssRepository;
import com.example.undead.habrahabrrss.utils.ObjectUtils;
import com.example.undead.habrahabrrss.view_interface.BaseView;
import com.example.undead.habrahabrrss.view_interface.RssListView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RssListPresenterImpl implements RssListPresenter, Unsubscribable {

    private class RssListDisposableObserver extends DisposableObserver<List<RssItem>> {
        @Override
        public void onNext(List<RssItem> rssItems) {
            mBaseView.hideProgress();
            if (ObjectUtils.isEmpty(rssItems)) {
                mBaseView.showEmptyMessage();
            } else {
                mBaseView.hideEmptyMessage();
            }
            mRssListView.setRssItemList(rssItems);
        }

        @Override
        public void onError(Throwable e) {
            mBaseView.hideProgress();
            mBaseView.showErrorMessage(e.getMessage());
        }

        @Override
        public void onComplete() {
        }
    }

    private CompositeDisposable mDisposable;
    private RssRepository mRssRepository;
    private RssListView mRssListView;
    private BaseView mBaseView;

    public RssListPresenterImpl(RssListView rssListView, BaseView baseView) {
        this.mRssListView = rssListView;
        this.mBaseView = baseView;
        this.mRssRepository = HabrahabrRssApplication.getInstance().getRepository();
        this.mDisposable = new CompositeDisposable();
    }

    @Override
    public void fetchTopDay() {
        mBaseView.showProgress();
        mDisposable.add(mRssRepository
                .getTopDay()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new RssListDisposableObserver()));
    }

    @Override
    public void fetchTopWeek() {
        mBaseView.showProgress();
        mDisposable.add(mRssRepository
                .getTopWeek()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new RssListDisposableObserver()));
    }

    @Override
    public void fetchTopMonth() {
        mBaseView.showProgress();
        mDisposable.add(mRssRepository
                .getTopMonth()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new RssListDisposableObserver()));
    }

    @Override
    public void fetchTopAll() {
        mBaseView.showProgress();
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
