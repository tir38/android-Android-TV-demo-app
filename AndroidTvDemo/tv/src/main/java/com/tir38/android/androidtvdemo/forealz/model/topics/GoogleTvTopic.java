package com.tir38.android.androidtvdemo.forealz.model.topics;

import android.support.v17.leanback.widget.Action;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class GoogleTvTopic extends Topic {
    public GoogleTvTopic() {
        super("Google TV vs. Android TV", 44, R.string.google_tv_description);
        setImageUrl("google_tv.jpg");
        setUrl("https://en.wikipedia.org/wiki/Google_TV");

        // setup actions
        List<Action> actions = new ArrayList<Action>();
        Action action1 = new Action(ACTION_LAUNCH_WEB,
                "Wikipedia",
                null);
        actions.add(action1);
        setActions(actions);
    }
}
