package com.tir38.android.androidtvdemo.forealz.model;

import android.support.v17.leanback.widget.Action;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Topic {

    private String mTitle;
    private int mId;
    private int mDescriptionResId;
    private String mImageUrl;
    private List<Action> mActions;
    private String mUrl;

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
        // convert string url into URL
        try {
            return new URL(mUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
