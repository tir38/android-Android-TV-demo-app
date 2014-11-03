package com.tir38.android.androidtvdemo.forealz;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.util.Log;
import android.widget.Toast;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.ModelStore;
import com.tir38.android.androidtvdemo.forealz.model.Topic;
import com.tir38.android.androidtvdemo.forealz.view.MyTopicPresenter;

import java.util.List;

public class MyBrowseFragment extends BrowseFragment {

    private static final String TAG = "DemoBrowseFragment";

    public static Fragment newInstance() {
        return new MyBrowseFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupUI();

        setupData();

        setupEventListeners();
    }

    private void setupEventListeners() {
        // setup CLICK listener
        setOnItemViewClickedListener(new OnItemViewClickedListener() {
            @Override
            public void onItemClicked(Presenter.ViewHolder viewHolder, Object o, RowPresenter.ViewHolder viewHolder2, Row row) {
                Topic topic = (Topic) o;
                String message = "item Clicked: " + topic.getTitle();
                Log.d(TAG, message);
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), TopicDetailActivity.class);
                intent.putExtra(TopicDetailActivity.EXTRA_TOPIC_ID, topic.getId());
                startActivity(intent);
            }
        });

        // setup SELECTED listener
        setOnItemViewSelectedListener(new OnItemViewSelectedListener() {
            @Override
            public void onItemSelected(Presenter.ViewHolder viewHolder, Object o, RowPresenter.ViewHolder viewHolder2, Row row) {
                Log.d(TAG, "item SELECTED");
            }
        });
    }

    private void setupData() {
        // get data from model store
        List<String> categories = ModelStore.getModelStore().getCategories();

        MyTopicPresenter topicPresenter = new MyTopicPresenter();

        // create adapter, supply view (presenter) and data (categories)
        ArrayObjectAdapter rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        List<Topic> topics;

        // build ListRow for each category
        for (int i = 0; i < categories.size(); i++) {

            // get topics from ModelStore
            topics = ModelStore.getModelStore().getTopicsByCategory(i);

            if (topics == null) {
                break;
            }

            // NOTE: its interesting here that you pass an instance of your "view" to the Adapter constructor
            ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(topicPresenter);

            // provide backing data to adapter
            for (Topic topic : topics) {
               listRowAdapter.add(topic);
            }

            // build list row header
            HeaderItem headerItem = new HeaderItem(i, categories.get(i), null); // title but no image

            // add a row to the adapter
            rowsAdapter.add(new ListRow(headerItem, listRowAdapter));
        }
        setAdapter(rowsAdapter);
    }

    private void setupUI() {
        setTitle(getResources().getString(R.string.android_tv_is_awesome));
    }
}
