package com.tir38.android.androidtvdemo.forealz.model.topics;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

public class RemoteAndroidAppTopic extends Topic {
    public RemoteAndroidAppTopic() {
        super("Remote Android App", 5, R.string.remote_android_app_description);
        setImageUrl("remote_app.png");

        setUrl("https://play.google.com/store/apps/details?id=com.google.android.tv.remote&hl=en");
    }
}
