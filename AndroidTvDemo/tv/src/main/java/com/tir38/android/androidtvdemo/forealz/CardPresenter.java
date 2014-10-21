package com.tir38.android.androidtvdemo.forealz;

import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;

public class CardPresenter extends AbstractDetailsDescriptionPresenter {
    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object o) {
        String title = (String) o;

        if (title != null) {
            viewHolder.getTitle().setText(title);
            viewHolder.getSubtitle().setText("my subtitle");
            viewHolder.getBody().setText("my body text");
        }
    }
}
