package com.tir38.android.androidtvdemo.forealz.model.topics;

import android.support.v17.leanback.widget.Action;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class LeanbackTopic extends Topic {

    public LeanbackTopic() {
        super("Leanback Support Library", 77, R.string.leanback_description);
        setImageUrl("leanback.gif");
        setUrl("https://developer.android.com/tools/support-library/features.html#v17-leanback");

        // setup actions
        List<Action> actions = new ArrayList<Action>();
        Action action1 = new Action(ACTION_LAUNCH_WEB,
                "Docs",
                null);
        actions.add(action1);
        setActions(actions);
    }
}
