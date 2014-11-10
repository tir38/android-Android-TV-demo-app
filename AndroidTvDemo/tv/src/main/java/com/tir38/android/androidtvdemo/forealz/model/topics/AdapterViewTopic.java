package com.tir38.android.androidtvdemo.forealz.model.topics;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

public class AdapterViewTopic extends Topic {

    public AdapterViewTopic() {
        super("Adapter + View",
                555,
                R.string.adapter_view_description);

        setImageUrl("light_blue.jpg");
    }
}
