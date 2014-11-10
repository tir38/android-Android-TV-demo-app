package com.tir38.android.androidtvdemo.forealz.model.topics;

import android.support.v17.leanback.widget.Action;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class TwoAxisNavTopic extends Topic {
    public TwoAxisNavTopic() {

        super("Two Axis Navigation", 88, R.string.two_axis_description);
        setImageUrl("compass.jpg");

        setUrl("https://developer.android.com/design/tv/patterns.html");

        // setup actions
        List<Action> actions = new ArrayList<Action>();
        Action action1 = new Action(ACTION_LAUNCH_WEB,
                "Design Guidelines");
        actions.add(action1);
        setActions(actions);
    }
}
