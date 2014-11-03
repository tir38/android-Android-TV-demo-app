package com.tir38.android.androidtvdemo.forealz.model.topics;

import android.support.v17.leanback.widget.Action;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AvailableDevicesTopic extends Topic {

    public AvailableDevicesTopic() {
        super("Available Devices",
                1,
                R.drawable.nexus_player,
                R.string.available_devices_description);

        // setup actions
        try {
            setUrl(new URL("https://www.google.com/intl/all/nexus/player/"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        List<Action> actions = new ArrayList<Action>();
        Action action1 = new Action(ACTION_LAUNCH_WEB,
                "some label",
                "some other label");
        actions.add(action1);
        setActions(actions);
    }
}
