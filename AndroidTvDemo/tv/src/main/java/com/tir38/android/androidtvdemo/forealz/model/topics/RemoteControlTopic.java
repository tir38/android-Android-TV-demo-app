package com.tir38.android.androidtvdemo.forealz.model.topics;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

public class RemoteControlTopic extends Topic {
    public RemoteControlTopic() {
        super("Remote Control", 4, R.string.remote_control_description);
        setImageUrl("nexus_remote.jpg");
    }
}
