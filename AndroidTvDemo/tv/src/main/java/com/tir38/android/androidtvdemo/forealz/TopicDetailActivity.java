package com.tir38.android.androidtvdemo.forealz;

import android.app.Fragment;

public class TopicDetailActivity extends SingleFragmentActivity
{
    public static final String EXTRA_TOPIC_ID = "MyDetailsActivity.EXTRA_TOPIC_ID";

    @Override
    protected Fragment createFragment() {

        // get id from intent
        int topicId = getIntent().getIntExtra(EXTRA_TOPIC_ID, 0);

        // create fragment
        return TopicDetailFragment.newInstance(topicId);
    }
}
