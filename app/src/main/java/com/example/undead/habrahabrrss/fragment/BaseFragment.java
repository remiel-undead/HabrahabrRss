package com.example.undead.habrahabrrss.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.undead.habrahabrrss.R;
import com.example.undead.habrahabrrss.view_interface.BaseView;

import butterknife.BindView;
import butterknife.Unbinder;

public class BaseFragment extends Fragment implements BaseView {
    @BindView(R.id.emptyTextView)
    protected TextView mEmptyTextView;
    @BindView(R.id.progressBar)
    protected ProgressBar mProgressBar;

    protected Unbinder mUnbinder;

    public BaseFragment() {
    }

    @Override
    public void showErrorMessage(String errorMsg) {
        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mProgressBar.setIndeterminate(true);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
        mProgressBar.setIndeterminate(false);
    }

    @Override
    public void showEmptyMessage() {
        mEmptyTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyMessage() {
        mEmptyTextView.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}