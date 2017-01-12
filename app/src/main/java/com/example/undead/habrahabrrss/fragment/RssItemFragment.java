package com.example.undead.habrahabrrss.fragment;

import com.example.undead.habrahabrrss.MainActivity;
import com.example.undead.habrahabrrss.R;
import com.example.undead.habrahabrrss.utils.StringUtils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RssItemFragment extends BaseFragment {
    public final static String TAG = RssItemFragment.class.getSimpleName();

    @BindView(R.id.item_img)
    ImageView mImageView;
    @BindView(R.id.item_title)
    TextView mTitleTextView;
    @BindView(R.id.item_date)
    TextView mDateTextView;
    @BindView(R.id.item_descr)
    TextView mDescriptionTextView;

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
        View view = inflater.inflate(R.layout.fragment_rss_item, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        if (savedInstanceState != null) {
            mTitleTextView.setText(savedInstanceState.getString(MainActivity.RSS_ITEM_TITLE_ARG));
            mDateTextView.setText(savedInstanceState.getString(MainActivity.RSS_ITEM_DATE_ARG));
            mDescriptionTextView.setText(savedInstanceState.getString(MainActivity.RSS_ITEM_DESCR_ARG));
        } else {
            Bundle args = getArguments();
            mTitleTextView.setText(args.getString(MainActivity.RSS_ITEM_TITLE_ARG));
            mDateTextView.setText(args.getString(MainActivity.RSS_ITEM_DATE_ARG));
            mDescriptionTextView
                    .setText(StringUtils.htmlToSpanned(StringUtils.excludeHtmlImgs(args.getString(MainActivity.RSS_ITEM_DESCR_ARG))));
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hideProgress();
        hideEmptyMessage();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MainActivity.RSS_ITEM_TITLE_ARG, mTitleTextView.getText().toString());
        outState.putString(MainActivity.RSS_ITEM_DATE_ARG, mDateTextView.getText().toString());
        outState.putString(MainActivity.RSS_ITEM_DESCR_ARG, mDescriptionTextView.getText().toString());
    }
}