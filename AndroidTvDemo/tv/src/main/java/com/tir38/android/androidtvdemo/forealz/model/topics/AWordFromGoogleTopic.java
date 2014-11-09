package com.tir38.android.androidtvdemo.forealz.model.topics;

import android.support.v17.leanback.widget.Action;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class AWordFromGoogleTopic extends Topic {

    public AWordFromGoogleTopic() {
        super("A Word From Google",
                AWordFromGoogleTopic.class.toString().hashCode(),
                R.string.a_word_from_google_description);

        setImageUrl("google.png");

        setUrl("https://developer.android.com/design/tv/principles.html");

        // setup actions
        List<Action> actions = new ArrayList<Action>();
        Action action1 = new Action(ACTION_LAUNCH_WEB,
                "Creative Vision",
                null);
        actions.add(action1);
        setActions(actions);
    }
}
