package com.tir38.android.androidtvdemo.forealz.model.topics;

import android.support.v17.leanback.widget.Action;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class AvailableDevicesTopic extends Topic {

    public AvailableDevicesTopic() {
        super("Available Devices",
                1,
                R.string.available_devices_description);

        setImageUrl("nexus_player.jpg");


        setUrl("https://www.google.com/intl/all/nexus/player/");

        // setup actions
        List<Action> actions = new ArrayList<Action>();
        Action action1 = new Action(ACTION_LAUNCH_WEB,
                "Nexus Player");
        actions.add(action1);
        setActions(actions);
    }
}
