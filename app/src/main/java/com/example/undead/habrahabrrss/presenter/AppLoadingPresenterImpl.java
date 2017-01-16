package com.example.undead.habrahabrrss.presenter;

import com.example.undead.habrahabrrss.HabrahabrRssApplication;
import com.example.undead.habrahabrrss.Unsubscribable;
import com.example.undead.habrahabrrss.view_interface.AppLoadingView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class AppLoadingPresenterImpl implements AppLoadingPresenter, Unsubscribable {

    private AppLoadingView mAppLoadingView;
    private CompositeDisposable mUpdateCompositeDisposable;

    public AppLoadingPresenterImpl(AppLoadingView mAppLoadingView) {
        this.mAppLoadingView = mAppLoadingView;
        mUpdateCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void updateCache() {
        mUpdateCompositeDisposable.add(HabrahabrRssApplication.getInstance().getRepository()
                .updateCache()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Void>() {
                    @Override
                    public void onNext(Void aVoid) {
                        mAppLoadingView.finishSplash();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mAppLoadingView.showErrorMessage(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void unsubscribe() {
        mUpdateCompositeDisposable.clear();
    }
}
