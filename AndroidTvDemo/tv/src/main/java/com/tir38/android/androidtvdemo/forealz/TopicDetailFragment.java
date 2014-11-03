package com.tir38.android.androidtvdemo.forealz;

import android.app.Fragment;
import android.content.Intent;
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

import com.tir38.android.androidtvdemo.DetailsDescriptionPresenter;
import com.tir38.android.androidtvdemo.forealz.model.ModelStore;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

import java.util.List;

public class TopicDetailFragment extends DetailsFragment {

    private static final String EXTRA_TOPIC_ID = "TopicDetailFragment.EXTRA_TOPIC_ID";
    private static final String TAG = TopicDetailFragment.class.toString();
    private Topic mTopic;

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

        int topicId = getArguments().getInt(EXTRA_TOPIC_ID, 0);
        mTopic = ModelStore.getModelStore().getTopicById(topicId);
        if (mTopic == null) {
            Log.e(TAG, "unknown topic; finishing fragment");
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
        DetailsOverviewRow row = new DetailsOverviewRow(mTopic);
        row.setImageDrawable(getResources().getDrawable(mTopic.getImageResId()));


        List<Action> actions = mTopic.getActions();
        for (Action action : actions) {

            row.addAction(action);
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
        adapter.add(row);
        setAdapter(adapter);
    }
}

