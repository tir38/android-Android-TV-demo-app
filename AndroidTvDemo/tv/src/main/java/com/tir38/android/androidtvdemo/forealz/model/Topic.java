package com.tir38.android.androidtvdemo.forealz.model;

import android.support.v17.leanback.widget.Action;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Topic {

    private String mTitle;
    private int mId;
    private int mDescriptionResId;
    private String mImageUrl;
    private List<Action> mActions;
    private URL mUrl;

    // public Action keys
    public static final long ACTION_LAUNCH_WEB = 12434245;

    public Topic(String title, int id, int descriptionResId) {
        mTitle = title;
        mId = id;
        mDescriptionResId = descriptionResId;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getId() {
        return mId;
    }

    public int getDescriptionResId() {
        return mDescriptionResId;
    }

    public List<Action> getActions() {
        if (mActions == null) {
            return new ArrayList<Action>();
        }
        return mActions;
    }

    public void setActions(List<Action> actions) {
        mActions = actions;
    }

    public URL getUrl() {
        return mUrl;
    }

    public void setUrl(URL url) {
        mUrl = url;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
