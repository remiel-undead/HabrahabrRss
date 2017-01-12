package com.example.undead.habrahabrrss.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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


    private static final String TAG_OPTION = "option";
    private final static int OPTION_DAY = 0;
    private final static int OPTION_WEEK = 1;
    private final static int OPTION_MONTH = 2;
    private final static int OPTION_ALL = 3;

    private int mCurrentOption;

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
        setHasOptionsMenu(true);
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
        if (savedInstanceState == null) {
            mCurrentOption = OPTION_DAY;
        } else {
            mCurrentOption = savedInstanceState.getInt(TAG_OPTION, 0);
        }
        mItems = new ArrayList<>();
        mAdapter = new RssListAdapter(mItems, this);

        fetchDueToMenuOption();
    }

    private void fetchDueToMenuOption() {
        switch (mCurrentOption) {
            case OPTION_DAY:
                mRssListPresenter.fetchTopDay();
                break;
            case OPTION_WEEK:
                // TODO mRssListPresenter.fetchTopWeek();
                break;
            case OPTION_MONTH:
                // TODO mRssListPresenter.fetchTopMonth();
                break;
            case OPTION_ALL:
                // TODO mRssListPresenter.fetchTopAll();
                break;
            default:
                // TODO mRssListPresenter.fetchTopDay();
                break;
        }
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = false;
        switch (item.getItemId()) {
            case R.id.top_per_day:
                mCurrentOption = OPTION_DAY;
                result = true;
                break;
            case R.id.top_per_week:
                mCurrentOption = OPTION_WEEK;
                result = true;
                break;
            case R.id.top_per_month:
                mCurrentOption = OPTION_MONTH;
                result = true;
                break;
            case R.id.top_all:
                mCurrentOption = OPTION_ALL;
                result = true;
                break;
            default:
                break;
        }
        fetchDueToMenuOption();
        return result ? result : super.onOptionsItemSelected(item);
    }
}
