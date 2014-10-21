package com.tir38.android.androidtvdemo.forealz;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;

import com.tir38.android.androidtvdemo.R;

import java.util.List;

public class DemoBrowseFragment extends BrowseFragment {


    public static Fragment newInstance() {
        return new DemoBrowseFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupUI();

        setupData();
    }

    private void setupData() {

        // get data from model store
        List<String> categories = ModelStore.getModelStore().getCategories();

        CardPresenter cardPresenter = new CardPresenter();

        // create adapter, supply view (presenter) and data (categories)
        ArrayObjectAdapter rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        List<String> topics;

        // build ListRow for each category
        for (int i = 0; i < categories.size(); i++){

            // get topics from ModelStore
            topics = ModelStore.getModelStore().getTopicsByCategory(i);

            if (topics == null) {
                break;
            }

            // NOTE: its interesting here that you pass an instance of your "view" to the Adapter
            ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(cardPresenter);

            // provide backing data to adapter
            for (String topic: topics) {
                listRowAdapter.add(topic);
            }

            // build list row header
            HeaderItem headerItem = new HeaderItem(i, categories.get(i), null); // title but no image

            rowsAdapter.add(new ListRow(headerItem, listRowAdapter));
        }

//        rowsAdapter.addAll(0, categories);
        setAdapter(rowsAdapter);
    }

    private void setupUI() {
        setTitle(getResources().getString(R.string.android_tv_is_awesome));
    }
}
