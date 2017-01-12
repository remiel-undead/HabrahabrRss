package com.example.undead.habrahabrrss.fragment;

import com.example.undead.habrahabrrss.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RssItemFragment extends Fragment {
    public final static String TAG = RssItemFragment.class.getSimpleName();

    public RssItemFragment() {
    }

    public static RssItemFragment newInstance() {
        return new RssItemFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rss_item, container, false);
    }
}