package com.tir38.android.androidtvdemo.forealz.model;


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
    private List<List<Topic>> mTopics = new ArrayList<List<Topic>>();

    public ModelStore() {
        // setup categories
        mCategories.add("Intro");
        mCategories.add("General");
        mCategories.add("Adapter + View Pattern");


        // setup topics
        Topic[] category1Topics = {new Topic("topic 1"), new Topic("topic 2")};
        Topic[] category2Topics = {new Topic ("topic 3"), new Topic("topic 4")};

        mTopics.add(new ArrayList<Topic>(Arrays.asList(category1Topics)));
        mTopics.add(new ArrayList<Topic>(Arrays.asList(category2Topics)));
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

    public List<Topic> getTopicsByCategory(int categoryIndex) {
        // make sure category index has topics
        if (categoryIndex >= mTopics.size()) {
            Log.e(TAG, "Attempting to access Category index that doesn't have any topics.");
            return null;
        }

        return mTopics.get(categoryIndex);
    }
}
