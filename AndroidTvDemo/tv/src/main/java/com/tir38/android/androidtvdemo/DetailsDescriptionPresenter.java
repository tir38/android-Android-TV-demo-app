package com.tir38.android.androidtvdemo;

import android.content.Context;
import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;

import com.tir38.android.androidtvdemo.forealz.model.Topic;

public class DetailsDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    Context mContext;
    public DetailsDescriptionPresenter(Context context) {
        mContext = context;
    }

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        Topic topic = (Topic) item;

        if (topic  != null){
            viewHolder.getTitle().setText(topic.getTitle());

            if (topic.getDescriptionResId() > 0) {
                viewHolder.getBody().setText(mContext.getResources().getString(topic.getDescriptionResId()));
            }
        }
    }
}
