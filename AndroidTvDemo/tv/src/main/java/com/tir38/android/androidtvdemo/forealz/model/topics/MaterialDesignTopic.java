package com.tir38.android.androidtvdemo.forealz.model.topics;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

public class MaterialDesignTopic extends Topic {
    public MaterialDesignTopic() {
        super("Material Design",
                2222,
                R.string.material_design_description);

        setImageUrl("material.png");

        setBackgroundImageUrl("https://material-design.storage.googleapis.com/publish/v_1/quantumexternal/0Bx4BSt6jniD7SjE5bTNHN3JpQXc/style_color_introduction.png");
    }
}
