package com.tir38.android.androidtvdemo.forealz;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.DetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.OnActionClickedListener;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
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

    public static Fragment newInstance(int topicId) {

        // add topic ID to fragment arguments
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

        setupEventListeners();

        setupUI();
    }

    private void setupEventListeners() {
        setOnItemViewClickedListener(new OnItemViewClickedListener() {
            @Override
            public void onItemClicked(Presenter.ViewHolder viewHolder, Object o, RowPresenter.ViewHolder viewHolder2, Row row) {
                // TODO
            }
        });

        setOnItemViewSelectedListener(new OnItemViewSelectedListener() {
            @Override
            public void onItemSelected(Presenter.ViewHolder viewHolder, Object o, RowPresenter.ViewHolder viewHolder2, Row row) {
                // TODO
            }
        });
    }

    private void setupUI() {

        // create single Row
        mRow = new DetailsOverviewRow(mTopic);

        // setup action(s)
        List<Action> actions = mTopic.getActions();
        for (Action action : actions) {
            mRow.addAction(action);
        }

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
        ArrayObjectAdapter adapter = new ArrayObjectAdapter(dorPresenter);
        adapter.add(mRow);
        setAdapter(adapter);

        Uri uri = Uri.parse(ModelStore.BASE_IMAGE_RESOURCE_URL + mTopic.getImageUrl());
        Picasso.with(getActivity())
                .load(uri)
                .placeholder(R.drawable.brian_up_close)
                .error(R.drawable.brian_up_close)
                .into(new TopicImageTarget());
    }

    /**
     * custom Picasso Target
     */
    protected class TopicImageTarget implements Target {

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            Log.d(TAG, "bitmap loaded");
            mRow.setImageBitmap(getActivity(), bitmap);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            Log.d(TAG, "bitmap failed");
            mRow.setImageDrawable(errorDrawable);
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            Log.d(TAG, "bitmap prepared");
            mRow.setImageDrawable(placeHolderDrawable);
        }
    }
}

