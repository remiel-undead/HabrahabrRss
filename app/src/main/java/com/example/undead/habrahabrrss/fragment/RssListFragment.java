package com.example.undead.habrahabrrss.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.undead.habrahabrrss.R;
import com.example.undead.habrahabrrss.adapter.RssListAdapter;
import com.example.undead.habrahabrrss.model.RssItem;
import com.example.undead.habrahabrrss.presenter.RssListPresenter;
import com.example.undead.habrahabrrss.presenter.RssListPresenterImpl;
import com.example.undead.habrahabrrss.view_interface.RssListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RssListFragment extends BaseFragment
        implements RssListView, RssListPresenterImpl.OnListItemClickListener {

    public final static String TAG = RssListFragment.class.getSimpleName();
    private List<RssItem> mItems;
    private RssListAdapter mAdapter;
    private RssListPresenter mRssListPresenter;

    @BindView(R.id.listView)
    RecyclerView mRecyclerView;

    public RssListFragment() {
    }

    public static RssListFragment newInstance() {
        return new RssListFragment();
    }

    @Override
    public void setRssItemList(List<RssItem> rssItemList) {
        mRecyclerView.swapAdapter(new RssListAdapter(rssItemList, this), false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mRssListPresenter = new RssListPresenterImpl(this, this, this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRssListPresenter.unsubscribe();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mItems = new ArrayList<>();
        mAdapter = new RssListAdapter(mItems, this);

        // TODO fetch due to menu
        mRssListPresenter.fetchTopDay();
    }

    @Override
    public void onListItemClick(RssItem item) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rss_list, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}
