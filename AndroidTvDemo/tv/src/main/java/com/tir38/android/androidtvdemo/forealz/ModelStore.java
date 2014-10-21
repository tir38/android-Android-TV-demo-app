package com.tir38.android.androidtvdemo.forealz;


import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Everything in this class is ugly. Do not mimic the behavior here.
 * This is just a hacky way to provide data to the "real" parts of this app.
 */
public class ModelStore {

    private static final String TAG = "ModelStore";

    private static ModelStore sModelStore;

    private List<String> mCategories = new ArrayList<String>();
    private List<List<String>> mTopics = new ArrayList<List<String>>();

    public ModelStore() {
        // setup categories
        mCategories.add("Intro");
        mCategories.add("General");
        mCategories.add("Adapter + View Pattern");


        // setup topics
        String[] category1Topics = {"topic 1", "topic 2"};
        String[] category2Topics = {"topic 3", "topic 4"};

        mTopics.add(new ArrayList<String>(Arrays.asList(category1Topics)));
        mTopics.add(new ArrayList<String>(Arrays.asList(category2Topics)));
    }

    public static ModelStore getModelStore() {
        if (sModelStore == null) {
            sModelStore = new ModelStore();
        }

        return sModelStore;
    }

    public List<String> getCategories() {
        return mCategories;
    }

    public List<String> getTopicsByCategory(int categoryIndex) {
        // make sure category index has topics
        if (categoryIndex >= mTopics.size()) {
            Log.e(TAG, "Attempting to access Category index that doesn't have any topics.");
            return null;
        }

        return mTopics.get(categoryIndex);
    }
}
