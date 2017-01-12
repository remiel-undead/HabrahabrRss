package com.example.undead.habrahabrrss;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.undead.habrahabrrss.fragment.RssItemFragment;
import com.example.undead.habrahabrrss.fragment.RssListFragment;

public class MainActivity extends AppCompatActivity {
    private static String CURRENT_FRAGMENT_TAG = "current_fragment_tag";
    private String mCurrentFragmentTag;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mCurrentFragmentTag = savedInstanceState.getString(mCurrentFragmentTag, RssListFragment.TAG);
        } else {
            mCurrentFragmentTag = RssListFragment.TAG;
        }
        FragmentManager manager = getSupportFragmentManager();
        mFragment = manager.findFragmentByTag(mCurrentFragmentTag);
        if (mFragment == null) {
            mFragment = RssListFragment.newInstance();
        }
        manager.beginTransaction().replace(R.id.frame_container, mFragment).commit();
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
            manager.beginTransaction().replace(R.id.frame_container, mFragment).commit();
        } else {
            super.onBackPressed();
        }
    }
}
