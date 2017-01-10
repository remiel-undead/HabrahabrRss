package com.example.undead.habrahabrrss.fragment;

import android.support.v4.app.Fragment;

import com.example.undead.habrahabrrss.adapter.RssListAdapter;
import com.example.undead.habrahabrrss.model.RssItem;
import com.example.undead.habrahabrrss.repository.RssRepository;

import org.reactivestreams.Subscription;

import java.util.List;

public class RssListFragment extends Fragment {
    public final static String TAG = RssListFragment.class.getSimpleName();
    private List<RssItem> mItems;
    private RssListAdapter mAdapter;

    private Subscription mSubscription;
    private RssRepository mRssRepository;

    private OnListItemClickListener mOnListItemClickListener;

    public interface OnListItemClickListener {
        void onListItemClick(int position, RssItem item);
    }

    public void setOnListItemClickListener(OnListItemClickListener onListItemClickListener) {
        mOnListItemClickListener = onListItemClickListener;
    }
}
