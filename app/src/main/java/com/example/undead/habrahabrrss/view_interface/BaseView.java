package com.example.undead.habrahabrrss.view_interface;

public interface BaseView {
    void showErrorMessage(String errorMsg);
    void showProgress();
    void hideProgress();
    void showEmptyMessage();
}