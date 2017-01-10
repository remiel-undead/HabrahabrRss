package com.example.undead.habrahabrrss.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.undead.habrahabrrss.R;
import com.example.undead.habrahabrrss.model.RssItem;

import java.util.List;

public class RssListAdapter extends ArrayAdapter<RssItem> {
    private LayoutInflater mInflater;
    private TextView mTitle;
    private TextView mDescr;

    public RssListAdapter(Context context, List<RssItem> objects) {
        super(context, 0, objects);
        mInflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_rss, null);
        }

        RssItem item = this.getItem(position);
        if (item != null) {
            String title = item.getTitle().toString();
            mTitle = (TextView)view.findViewById(R.id.item_title);
            mTitle.setText(title);
            String descr = item.getDescription().toString();
            mDescr = (TextView)view.findViewById(R.id.item_descr);
            mDescr.setText(descr);
        }
        return view;
    }
}