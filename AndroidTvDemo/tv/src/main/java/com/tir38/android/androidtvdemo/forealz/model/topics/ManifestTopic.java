package com.tir38.android.androidtvdemo.forealz.model.topics;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

public class ManifestTopic extends Topic {

    public ManifestTopic() {
        super("AndroidManifest.xml",
                111,
                R.string.manifest_description);

        setImageUrl("green.jpg");
    }
}
