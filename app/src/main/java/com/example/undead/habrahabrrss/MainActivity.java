package com.example.undead.habrahabrrss;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.undead.habrahabrrss.fragment.RssListFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();

        if (manager.findFragmentByTag(RssListFragment.TAG) == null) {
            FragmentTransaction ft = manager.beginTransaction();
            mFragment = new RssListFragment();
            ft.add(R.id.frame_container, mFragment, RssListFragment.TAG);
            ft.commit();
        } else {
            mFragment = manager.findFragmentByTag(RssListFragment.TAG);
        }
    }
}
