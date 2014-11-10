package com.tir38.android.androidtvdemo.forealz.model.topics;

import android.support.v17.leanback.widget.Action;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class WebBrowserTopic extends Topic {

    public WebBrowserTopic() {
        super("No Web Browser!",
                1111,
                R.string.webbrowser_description);

        setUrl("http://developer.android.com/reference/android/webkit/WebView.html");

        // setup actions
        List<Action> actions = new ArrayList<Action>();
        Action action1 = new Action(ACTION_LAUNCH_WEB,
                "Go!",
                null);
        actions.add(action1);
        setActions(actions);
    }
}
