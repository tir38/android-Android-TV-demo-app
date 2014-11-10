package com.tir38.android.androidtvdemo.forealz.model.topics;

import android.support.v17.leanback.widget.Action;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class NewFragmentsTopic extends Topic {

    public NewFragmentsTopic() {
        super("New Fragments", 333, R.string.new_fragments_description);

        setUrl("https://developer.android.com/reference/android/support/v17/leanback/app/package-summary.html");
        // setup actions
        List<Action> actions = new ArrayList<Action>();
        Action action1 = new Action(ACTION_LAUNCH_WEB,
                "Docs",
                null);
        actions.add(action1);
        setActions(actions);
    }
}
