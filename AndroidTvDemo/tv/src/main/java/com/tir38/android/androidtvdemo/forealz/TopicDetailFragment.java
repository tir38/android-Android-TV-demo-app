package com.tir38.android.androidtvdemo.forealz;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v17.leanback.app.BackgroundManager;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.DetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.OnActionClickedListener;
import android.util.Log;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.tir38.android.androidtvdemo.DetailsDescriptionPresenter;
import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.ModelStore;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.util.List;

public class TopicDetailFragment extends DetailsFragment {

    private static final String EXTRA_TOPIC_ID = "TopicDetailFragment.EXTRA_TOPIC_ID";
    private static final String TAG = TopicDetailFragment.class.toString();
    private Topic mTopic;
    private DetailsOverviewRow mRow;
    private ArrayObjectAdapter mAdapter;
    private PicassoBackgroundManagerTarget mBackgroundTarget;

    public static Fragment newInstance(int topicId) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_TOPIC_ID, topicId);
        TopicDetailFragment fragment = new TopicDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get topic from model store
        int topicId = getArguments().getInt(EXTRA_TOPIC_ID, 0);
        mTopic = ModelStore.getModelStore().getTopicById(topicId);
        if (mTopic == null) {
            Log.e(TAG, "No topic found");
        }

        // prepare background image manager
        BackgroundManager backgroundManager = BackgroundManager.getInstance(getActivity());
        backgroundManager.attach(getActivity().getWindow());
        mBackgroundTarget = new PicassoBackgroundManagerTarget(backgroundManager);

        setupUI();
    }

    private void setupUI() {

        // create single Row
        mRow = new DetailsOverviewRow(mTopic);

        // setup action(s)
        List<Action> actions = mTopic.getActions();
        for (Action action : actions) {
            mRow.addAction(action);
        }

        updateBackground();

        // build presenter
        DetailsOverviewRowPresenter dorPresenter = new DetailsOverviewRowPresenter(new DetailsDescriptionPresenter(getActivity()));
        dorPresenter.setOnActionClickedListener(new OnActionClickedListener() {
            @Override
            public void onActionClicked(Action action) {
                if (action.getId() == Topic.ACTION_LAUNCH_WEB) {
                    // start browser
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra(WebViewActivity.EXTRA_URL, mTopic.getUrl());
                    startActivity(intent);
                }
            }
        });

        // build adapter
        mAdapter = new ArrayObjectAdapter(dorPresenter);
        mAdapter.add(mRow);

        // for topic 555 add a few extra rows
        if (mTopic.getId() == 555) {
            mAdapter.add(mRow);
            mAdapter.add(mRow);
        }

        setAdapter(mAdapter);

        TopicImageTarget target = new TopicImageTarget();

        Uri uri = Uri.parse(ModelStore.BASE_IMAGE_RESOURCE_URL + mTopic.getImageUrl());
        Picasso.with(getActivity())
                .load(uri)
                .placeholder(R.drawable.blank)
                .error(R.drawable.blank)
                .into(target);
    }

    protected void updateBackground() {
        if (mTopic.getBackgroundImageUrl() != null) {
            Log.d(TAG, "downloading background");
            Picasso.with(getActivity())
                    .load(mTopic.getBackgroundImageUrl())
                    .into(mBackgroundTarget);
        }
    }

    /**
     * custom Picasso Target
     */
    protected class TopicImageTarget implements Target {

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            mRow.setImageBitmap(getActivity(), bitmap);
            mAdapter.notifyArrayItemRangeChanged(0, 1);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            mRow.setImageDrawable(errorDrawable);
            mAdapter.notifyArrayItemRangeChanged(0, 1);
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            mRow.setImageDrawable(placeHolderDrawable);
            mAdapter.notifyArrayItemRangeChanged(0, 1);
        }

        @Override
        public boolean equals(Object o) {
            return this == o || o != null && o instanceof TopicImageTarget;
        }

        // use Object's hashcode;
    }
}


