package com.tir38.android.androidtvdemo.forealz.model.topics;

import android.support.v17.leanback.widget.Action;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class AndroidStudioTemplateTopic extends Topic {

    public AndroidStudioTemplateTopic() {
        super("Android Studio: Android TV Template", 66, R.string.android_studio_temmplate_description);
        setImageUrl("android_studio_icon.png");
        setUrl("https://github.com/tir38/Android-TV-demo-app/tree/master/AndroidTvDemo/web_images/android_studio_template.png");

        // setup actions
        List<Action> actions = new ArrayList<Action>();
        Action action1 = new Action(ACTION_LAUNCH_WEB,
                "Template",
                null);
        actions.add(action1);
        setActions(actions);
    }
}
