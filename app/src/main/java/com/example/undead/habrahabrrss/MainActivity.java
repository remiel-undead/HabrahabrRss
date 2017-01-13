package com.example.undead.habrahabrrss;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.undead.habrahabrrss.fragment.RssItemFragment;
import com.example.undead.habrahabrrss.fragment.RssListFragment;
import com.example.undead.habrahabrrss.model.RssItem;

public class MainActivity extends AppCompatActivity implements RssListFragment.OnListItemClickListener {
    private static String CURRENT_FRAGMENT_TAG = "current_fragment_tag";
    public static String RSS_ITEM_TITLE_ARG = "rss_item_title_arg";
    public static String RSS_ITEM_DATE_ARG = "rss_item_date_arg";
    public static String RSS_ITEM_DESCR_ARG = "rss_item_descr_arg";
    private String mCurrentFragmentTag;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            mCurrentFragmentTag = RssListFragment.TAG;
            mFragment = RssListFragment.newInstance();
            manager.beginTransaction().replace(R.id.frame_container, mFragment, mCurrentFragmentTag).commit();
        } else {
            mCurrentFragmentTag = savedInstanceState.getString(CURRENT_FRAGMENT_TAG, RssListFragment.TAG);
            mFragment = manager.findFragmentByTag(mCurrentFragmentTag);
            if (mFragment == null) {
                mFragment = RssListFragment.newInstance();
                manager.beginTransaction().replace(R.id.frame_container, mFragment, mCurrentFragmentTag).commit();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CURRENT_FRAGMENT_TAG, mCurrentFragmentTag);
    }

    @Override
    public void onBackPressed() {
        if (mFragment != null && mFragment.isVisible() && mCurrentFragmentTag.equals(RssItemFragment.TAG)) {
            FragmentManager manager = getSupportFragmentManager();
            mFragment = manager.findFragmentByTag(RssListFragment.TAG);
            if (mFragment == null) {
                mFragment = RssListFragment.newInstance();
            }
            mCurrentFragmentTag = RssListFragment.TAG;
            manager.beginTransaction()
                    .replace(R.id.frame_container, mFragment, mCurrentFragmentTag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                    .commit();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onListItemClick(RssItem item) {
        if (mFragment != null && mFragment.isVisible() && mCurrentFragmentTag.equals(RssListFragment.TAG)) {
            FragmentManager manager = getSupportFragmentManager();
            mFragment = manager.findFragmentByTag(RssItemFragment.TAG);
            if (mFragment == null) {
                mFragment = RssItemFragment.newInstance(item.getTitle(), item.getPublishedDate(), item.getDescription());
            }
            mCurrentFragmentTag = RssItemFragment.TAG;
            manager.beginTransaction()
                    .replace(R.id.frame_container, mFragment, mCurrentFragmentTag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        }
    }
}
