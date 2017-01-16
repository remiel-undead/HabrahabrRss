package com.example.undead.habrahabrrss.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.undead.habrahabrrss.presenter.AppLoadingPresenterImpl;
import com.example.undead.habrahabrrss.view_interface.AppLoadingView;

public class SplashActivity extends AppCompatActivity implements AppLoadingView {
    private AppLoadingPresenterImpl mAppLoadingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppLoadingPresenter = new AppLoadingPresenterImpl(this);
        mAppLoadingPresenter.updateCache();
    }

    @Override
    public void showErrorMessage(String errorMsg) {
        Toast.makeText(SplashActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
        finishSplash();
    }

    @Override
    public void finishSplash() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAppLoadingPresenter.unsubscribe();
    }
}