package com.example.undead.habrahabrrss.adapter;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.undead.habrahabrrss.R;
import com.example.undead.habrahabrrss.model.RssItem;
import com.example.undead.habrahabrrss.presenter.RssListPresenterImpl;
import com.example.undead.habrahabrrss.utils.StringUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RssListAdapter extends RecyclerView.Adapter<RssListAdapter.ViewHolder> {

    private final List<RssItem> mRssItemList;
    private final RssListPresenterImpl.OnListItemClickListener mOnListItemClickListener;

    public RssListAdapter(final List<RssItem> rssItemList,
                          RssListPresenterImpl.OnListItemClickListener onListItemClickListener) {
        this.mRssItemList = rssItemList;
        this.mOnListItemClickListener = onListItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rss, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindItem(mRssItemList.get(position), mOnListItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mRssItemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView mImageView;
        @BindView(R.id.item_title)
        TextView mTitleTextView;
        @BindView(R.id.item_date)
        TextView mDateTextView;
        @BindView(R.id.item_descr)
        TextView mDescriptionTextView;

        private final View mView;

        ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }

        void bindItem(final RssItem rssItem, final RssListPresenterImpl.OnListItemClickListener clickListener) {
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    clickListener.onListItemClick(rssItem);
                }
            });
            mTitleTextView.setText(rssItem.getTitle());
            mDateTextView.setText(rssItem.getPublishedDate());
            mDescriptionTextView.setText(StringUtils.excludeHtml(rssItem.getDescription()));
            // TODO set img
        }
    }
}