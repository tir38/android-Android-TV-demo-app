package com.tir38.android.androidtvdemo.forealz.model.topics;

import android.support.v17.leanback.widget.Action;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class GoogleDocsTopic extends Topic {

    public GoogleDocsTopic() {
        super("A Word From Google",
                GoogleDocsTopic.class.toString().hashCode(),
                R.string.a_word_from_google_description);

        setImageUrl("google.png");

        setUrl("https://developer.android.com/distribute/essentials/quality/tv.html");

        // setup actions
        List<Action> actions = new ArrayList<Action>();
        Action action1 = new Action(ACTION_LAUNCH_WEB,
                "Android Style Guide",
                null);
        actions.add(action1);
        setActions(actions);
    }
}
