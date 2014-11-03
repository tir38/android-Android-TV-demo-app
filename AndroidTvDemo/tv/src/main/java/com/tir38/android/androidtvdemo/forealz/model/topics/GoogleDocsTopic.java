package com.tir38.android.androidtvdemo.forealz.model.topics;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

public class GoogleDocsTopic  extends Topic {

    public GoogleDocsTopic() {
        super("A Word From Google",
                GoogleDocsTopic.class.toString().hashCode(),
                R.drawable.brian_up_close,
                R.string.todo);
    }
}
