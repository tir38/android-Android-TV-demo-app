package com.tir38.android.androidtvdemo.forealz.model.topics;

import android.support.v17.leanback.widget.Action;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class GameControllerTopic extends Topic {

    public GameControllerTopic() {
        super("Game Controller",
                2,
                R.string.game_controller_description);

        setImageUrl("controller.png");

        setUrl("https://play.google.com/store/devices/details?id=nexus_player_gamepad");

        // setup actions
        List<Action> actions = new ArrayList<Action>();
        Action action1 = new Action(ACTION_LAUNCH_WEB,
                "Google Play Store");
        actions.add(action1);
        setActions(actions);
    }


}
