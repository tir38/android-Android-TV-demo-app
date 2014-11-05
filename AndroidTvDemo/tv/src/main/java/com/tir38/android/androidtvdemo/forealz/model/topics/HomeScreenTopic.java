package com.tir38.android.androidtvdemo.forealz.model.topics;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

public class HomeScreenTopic extends Topic {

    public HomeScreenTopic() {
        super("Home Screen", 3, R.string.home_screen_description);
        setImageUrl("home_screen.jpg");
    }
}
